package com.google.checkstyle.test.chapter4formatting.rule451wheretobreack;

public class SeparatorWrapInput { 
    public void goodCase() 
    {
        int i = 0;
        String s = "ffffooooString";
        s
            .isEmpty(); //good wrapping
        s.isEmpty();
        
        foo(i,
                s); //good wrapping
    }
    public static void foo(int i, String s) 
    {
        
    }
}

class badCase {
    
    public void goodCase(int... aFoo) 
    {
        int i = 0;
        
        String s = "ffffooooString";
        s.
            isEmpty(); //bad wrapping
        foo(i
                ,s);  //bad wrapping
        int[] j;        
    }
    public static String foo(int i, String s) 
    {
        String maxLength = "123";
        int truncationLength = 1;
        CharSequence seq = null;
        Object truncationIndicator = null;
        return new StringBuilder(maxLength )
        .append(seq, 0, truncationLength )
        .append(truncationIndicator)
        .toString();
    }
}