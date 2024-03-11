package transform;

import java.io.File;
import java.nio.file.Files;

public class Config {
    //Dir
//    static final int RenameVariable = 1;
//    static final int For2While = 2;
//    static final int While2For = 3;
//    static final int ReverseIf = 4;
//    static final int ReorderParameter = 5;
//    static final int ChangeCondition = 6;
//    static final int RemoveCondition = 7;
//    static final int ChangeOperator = 8;
//    static final int RemoveUseStatement = 9;
    public static String inDir = "input";
    public static String ruleID = "1";

    public static String outDir = "output/" + ruleID + "/";

    public static String infoDir = "buggy_method_info.json";

    //Parameter
    public static int maxTrans = 5;
    public static int randomSeed = 42;
}
