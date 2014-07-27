package com.google.checkstyle.test.chapter5naming.rule526parameternames;

import java.io.*;

final class InputSimple
{
    void toManyArgs(int aArg1, int aArg2, int aArg3, int aArg4, int aArg5, //warn
                    int aArg6, int aArg7, int aArg8, int aArg9)
    {
    }
}

class InputSimple2
{

    /** Some more Javadoc. */
    public void doSomething(int aaa, int abn, String aaA, 
            boolean bB) //warn
    {
        //"O" should be named "o"
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
    
    public void doEnum(int aaaL, long lllllllLlL, 
            boolean bB) //warn
    {
        //"O" should be named "o"
        for (Object O : new java.util.ArrayList())
        {

        }
    }
}
