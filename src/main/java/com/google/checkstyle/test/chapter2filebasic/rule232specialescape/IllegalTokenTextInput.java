package com.google.checkstyle.test.chapter2filebasic.rule232specialescape;

/**
 * Test for illegal tokens
 */
public class IllegalTokenTextInput
{
    public void defaultMethod()
    {
        int i = 0;
        switch (i)
        {
            default:
                i--;
                i++;
                break;
        }
    }

    public native void nativeMethod();

    public void methodWithLiterals()
    {
        final String ref = "<a href=\"";
        final String refCase = "<A hReF=\"";
    }
    
    public String wrongEscapeSequences() 
    {
        final String r1 = "\u0008"; //warn
        final String r2 = "\u0009"; //warn
        final String r3 = "\u000csssdfsd"; //warn
        final String r4  = "\u1111sdfsd\444"; //no warn
        
        final char r5 = '\012'; //warn
        final char r6 = '\u0022'; //warn
        final char r7 = '\b'; //no warn
        return "\u000csssdfsd"; //warn
    }
}
