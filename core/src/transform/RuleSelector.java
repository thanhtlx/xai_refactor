package transform;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.text.Document;
import transform.refactor.For2While;
import transform.refactor.RenameVariable;
import transform.refactor.ReverseIf;
import transform.refactor.While2For;
//import transform.rules.*;
import transform.refactor.*;

import java.util.ArrayList;

public class RuleSelector {
    static final int RenameVariable = 1;
    static final int For2While = 2;
    static final int While2For = 3;
    static final int ReverseIf = 4;
    static final int ReorderParameter = 5;
    static final int ChangeCondition = 6;
    static final int RemoveCondition = 7;
    static final int ChangeOperator = 8;
    static final int RemoveUseStatement = 9;

    static ASTVisitor create(String ruleIdStr, CompilationUnit cu_, Document document_, String outputDirPath_, ArrayList targetLines, float threshold) {
        int ruleID = Integer.parseInt(ruleIdStr);
        switch (ruleID) {
            //Rename variables and methods
            case ReverseIf:
                return new ReverseIf(cu_, document_, outputDirPath_, targetLines, threshold);
            //Transform for-loop to while-loop
            case For2While:
                return new For2While(cu_, document_, outputDirPath_, targetLines, threshold);
            //Transform while-loop to for-loop
            case While2For:
                return new While2For(cu_, document_, outputDirPath_, targetLines, threshold);
            case RenameVariable:
                return new RenameVariable(cu_, document_, outputDirPath_, targetLines, threshold);
            case ReorderParameter:
                return  new ReoderParameter(cu_, document_, outputDirPath_, targetLines, threshold);
            case ChangeCondition:
                return  new ReverseCondition(cu_, document_, outputDirPath_, targetLines, threshold);
            case RemoveCondition:
                return  new RemoveControlStatement(cu_, document_, outputDirPath_, targetLines, threshold);
            case ChangeOperator:
                return  new ChangeOperator(cu_, document_, outputDirPath_, targetLines, threshold);
            case RemoveUseStatement:
                return  new RemoveDefStatement(cu_, document_, outputDirPath_, targetLines, threshold);
            default:
                System.out.println("ERROR:" + "No rule belongs to this id!");
                System.exit(5);
                return null;
        }
    }
}
