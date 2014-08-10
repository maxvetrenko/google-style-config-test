package com.google.checkstyle.test.chapter4formatting.rule4832nocstylearray;

/**
 * Test case for ArrayTypeStyle (Java vs C)
 **/
public class ArrayTypeStyleInput
{
    private int[] javaStyle = new int[0];
    private int cStyle[] = new int[0]; //warn

    public static void mainJava(String[] aJavaStyle) //ok
    {
    }

    public static void mainC(String aCStyle[]) //warn
    {
        final int[] blah = new int[0]; //ok
        final boolean isOK1 = aCStyle instanceof String[]; //ok
        final boolean isOK2 = aCStyle instanceof java.lang.String[]; //ok
        final boolean isOK3 = blah instanceof int[]; //ok
    }

    public class Test
    {
        public Test[]
            variable; //ok

        public Test[]
            getTests()
        { // we shouldn't check methods because there is no alternatives.
            return null;
        }

        public Test[] getNewTest() //ok
        {
            return null;
        }
    }
}
