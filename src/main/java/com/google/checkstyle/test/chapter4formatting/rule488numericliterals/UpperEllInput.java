package com.google.checkstyle.test.chapter4formatting.rule488numericliterals;

class UpperEllInput
{
    /** test **/
    private static final long IGNORE = 666l + 666L; //warn
    
    private static String notWarn = "666l"; //ok
    
    private long foo()
    {
        return 666l + 666L; //warn
    }
}
