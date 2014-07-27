package com.google.checkstyle.test.chapter4formatting.rule451wheretobreack;

class OperatorWrapInput
{
    void test()
    {
        /*Warn*/int x = 1 + 
                /*Warn*/ 2 - 
            3
            -
            4;
        x = x + 2;
        boolean y = true
            &&
            false;
        /*Warn*/ y = true && 
            false;
        y = false
            && true;
    }
    
    void testAssignment()
    {
        int x
            = 0; //error when checking assignment operators with EOL wrap option
        int y =
            0;
    }
    
    <
    /*Warn*/ T extends Comparable & 
        java.io.Serializable
    >
    void testGenerics1()
    {
        Comparable
            <
            String
            >
            c = new String(); 
    }
}
