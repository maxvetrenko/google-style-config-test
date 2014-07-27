package com.google.checkstyle.test.chapter5naming.rule526parameternames;

import java.io.*;

final class InputSimple
{                      //warn      warn       warn       warn      warn                  
    void toManyArgs(int $arg1, int ar$g2, int arg3$, int a_rg4, int _arg5, 
    		int arg6_, int aArg7, int aArg8, int aar_g)
            //warn ^    warn ^     warn ^     warn ^
    {}
}

class InputSimple2
{

    /** Some more Javadoc. */
    public void doSomething(int aaa, int abn, String aaA, 
            boolean bB) //warn
    {
        for (Object O : new java.util.ArrayList())
        {

        }
    }
}


/** Test enum for member naming check */
enum MyEnum1
{
    /** ABC constant */
    ABC,

    /** XYZ constant */
    XYZ;

    /** Should be mSomeMemeber */
    private int someMember;
    
    public void doEnum(int aaaL,
    		long llll_llll, //warn
            boolean bB) {} //warn 
}
