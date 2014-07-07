package com.google.checkstyle.test.chapter4formatting.rule42blockindentation;

@SuppressWarnings({"this", "that"})
public class WhitespaceAround
{
    protected WhitespaceAround ( int i )
    {
        this ();
        toString ();
    }
    protected WhitespaceAround ()
    {
        super ();
    }
    
    public void enhancedFor ()
    {
        int[] i = new int[2];
        for ( int j: i ) {
            System.out.println ( j );
        }
    }
}
