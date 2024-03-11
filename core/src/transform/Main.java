package transform;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.text.Document;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;

import static transform.StatementExtraction.getStatements;


public class Main {

    public static void parserFileInDir(String inDir, String outDir, String ruleID,
                                       float threshold) throws RuntimeException, IOException {
        int rule = Integer.parseInt(ruleID);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<String>> futures = new ArrayList<>();
        File folder = new File(inDir);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".java")) {
                String codeOfCurFile = Utils.readFileToString(inDir + "/" + file.getName());
                ArrayList<Integer> statements = getStatements(codeOfCurFile, rule);
//                System.out.println(outDir);
                ObjectProcessor task = new ObjectProcessor(file.getName(), inDir, outDir, ruleID, statements, threshold);
                Future<String> f = executorService.submit(task);
                futures.add(f);
            }
        }

        for (Future<String> future : futures) {
            try {
                String result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("catch");
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        String inDir = Config.inDir;
        String outDir = Config.outDir;
        String ruleID = Config.ruleID;
        float threshold = Config.threshold;
        try {
            Files.createDirectories(Paths.get(outDir));
            parserFileInDir(inDir, outDir, ruleID, threshold);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ObjectProcessor implements Callable<String> {
    //    private final Defects4jProject myObject;
    private final String outDir;
    private final String fileName;
    private final String inDir;
    private final String ruleID;

    private final float threshold;

    private final ArrayList<Integer> statements;

    public ObjectProcessor(String fileName, String inDir, String outDir, String ruleID, ArrayList<Integer> statements, float threshold) {
        this.inDir = inDir;
        this.outDir = outDir;
        this.threshold = threshold;

        this.ruleID = ruleID;
        this.statements = statements;
        this.fileName = fileName;
    }

    //TODO: Add support for mulitple target lines
    public static void parse(String code, String dirPath, String outputdir, String ruleID, ArrayList targetLines, float threshold) {
        //init a parser with JLS13 AST (Java 13)
        ASTParser parser = ASTParser.newParser(AST.JLS13);

        // Resolve binding
        parser.setResolveBindings(true);

        // Set kind if parser at compliation unit level
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        // allow binding recovery
        parser.setBindingsRecovery(true);

        // get default compiler options and set them as parser options
        Map<String, String> options = JavaCore.getOptions();
        parser.setCompilerOptions(options);

        String unitName = "Unit.java";// Just some random name.
        parser.setUnitName(unitName);

        //This code for setting environment. But we do not need for now
        String[] sources = {""};//Just the file itself.
        String[] classpath = {""};
        parser.setEnvironment(classpath, sources, new String[]{"UTF-8"}, true);

        parser.setSource(code.toCharArray());
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);

        //Create a document object of code
        Document document = new Document(code);
        cu.accept(RuleSelector.create(ruleID, cu, document, outputdir, targetLines, threshold));
        return;
    }

    @Override
    public String call() throws Exception {

        String filePath = inDir + "/" + fileName;
        String outputFile = outDir + "/" + fileName;
        String codeOfCurFile = Utils.readFileToString(filePath);
        parse(codeOfCurFile, inDir, outputFile, ruleID, statements, this.threshold);
        return "Processed";
    }
}
