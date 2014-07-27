package com.google.checkstyle.test.chapter5naming.rule527localvariablenames;

final class InputSimple
{
    public static final int badConstant = 2;
    
    public static final int MAX_ROWS = 2;

    private static int badStatic = 2;
    
    private static int sNumCreated = 0;

    private int badMember = 2;
    
    private int mNumCreated1 = 0;
     
    protected int mNumCreated2 = 0;

    private int[] mInts = new int[] {1,2, 3,
                                     4};

    /** test local variables */
    private void localVariables()
    {
        //bad examples
        int a;
        int aA;
        int a1_a;
        int A_A;
        int aa2_a;
        int _a;
        int _aa;
        int aa_;
        
        //good examples
        int aa;
        int aaAa1a;
        int aaAaaAa2a1;
    }
 
    /** some lines to test the error column after tabs */
    void errorColumnAfterTabs()
    {
        // with tab-width 8 all statements below start at the same column,
        // with different combinations of ' ' and '\t' before the statement
                int tab0 =1;
            int tab1 =1;
             int tab2 =1;
        int tab3 =1;
            int tab4 =1;
              int tab5 =1;
    }
}
