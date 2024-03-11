package transform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static transform.RuleSelector.*;

public class StatementExtraction {
//    static final int GetIfStatement = "1";
//    static final int GetElseStatement = "2";
//    static final int GetForStatement = "3";
//    static final int GetWhileStatement = "4";
//    static final int GetStatement = "5";

//    static final int RenameVariable = 1;
//    static final int For2While = 2;
//    static final int While2For = 3;
//    static final int ReverseIf = 4;
//    static final int ReorderParameter = 5;
//    static final int ChangeCondition = 6;
//    static final int RemoveCondition = 7;
//    static final int ChangeOperator = 8;
//    static final int RemoveUseStatement = 9;

    static ArrayList<Integer> getStatements(String code, int typeStatement, float threshold) {
        ArrayList<Integer> result = new ArrayList<>();

        switch (typeStatement) {
            case ReverseIf:
                result = getIf(code);
                break;
            case For2While:
                result = getFor(code);
                break;
            case While2For:
                result = getWhile(code);
                break;
            case RenameVariable:
                result = getStatement(code);
                break;
            case ReorderParameter:
                result = getStatement(code);
                break;
            case ChangeCondition:
                result = getIf(code);
                break;
            case RemoveCondition:
                result = getIf(code);
                break;
            case ChangeOperator:
                result = getStatement(code);
                break;
            case RemoveUseStatement:
                result = getStatement(code);
                break;
        }
        if (true)
        return result;

        ArrayList<Integer> tmp = new ArrayList<>();
        if (result.size() >0)
        tmp.add(result.get(0));
        System.out.println("size");
        System.out.println(tmp.size());
        return tmp;
    }

    private static ArrayList<Integer> getStatement(String code) {
        ArrayList<Integer> result = new ArrayList<>();
        int lineNum = 1;
        for (String line : code.split("\n")) {
            if (line.strip().length() > 1) {
                result.add(lineNum);
            }
            lineNum += 1;

        }
        System.out.println(lineNum);
        return result;
    }

    private static ArrayList<Integer> getIf(String code) {
        ArrayList<Integer> result = new ArrayList<>();
        int lineNum = 1;
        for (String line : code.split("\n")) {
            if (line.strip().startsWith("if")) {
                result.add(lineNum);
            }
            lineNum+=1;

        }
        return result;
    }

    private static ArrayList<Integer> getElse(String code) {
        ArrayList<Integer> result = new ArrayList<>();
        int lineNum = 1;
        for (String line : code.split("\n")) {
            if (line.strip().startsWith("else")) {
                result.add(lineNum);
            }
            lineNum += 1;

        }
        return result;
    }

    private static ArrayList<Integer> getWhile(String code) {
        ArrayList<Integer> result = new ArrayList<>();
        int lineNum = 1;
        for (String line : code.split("\n")) {
            if (line.strip().startsWith("while")) {
                result.add(lineNum);
            }
            lineNum += 1;

        }
        return result;
    }

    private static ArrayList<Integer> getFor(String code) {
        ArrayList<Integer> result = new ArrayList<>();
        int lineNum = 1;
        for (String line : code.split("\n")) {
            if (line.strip().startsWith("for")) {
                result.add(lineNum);
            }
            lineNum += 1;

        }
        return result;
    }
}
