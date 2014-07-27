package com.google.checkstyle.test.chapter5naming.rule525nonconstantfieldnames;
import java.io.*;

final class InputSimple
{

    public static final int badConstant = 2;

    public static final int MAX_ROWS = 2;

    
    private static int badStatic = 2;
   
    private static int sNumCreated = 0;

   
    private int badMember = 2;

    private int mNumCreated1 = 0; //warn

    protected int mNumCreated2 = 0; //warn


    private int[] mInts = new int[] {1,2, 3, //warn
                                     4};


    public static int sTest1;

    protected static int sTest3;

    static int sTest2;


    int mTest1; //warn

    public int mTest2; //warn


    void errorColumnAfterTabs()
    {
                int tab0 =1;
            int tab1 =1;
             int tab2 =1;
        int tab3 =1;
            int tab4 =1;
              int tab5 =1;
    }
}
