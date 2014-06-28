/*
 * InputValidLabelIndent.java
 *
 * Created on February 21, 2003, 11:28 PM
 */

package com.google.checkstyle.test.chapter4formatting.rule42blockindentation;

/**
 *
 * @author  jrichard
 */
public class InputValidLabelIndent {
    
    /** Creates a new instance of InputValidLabelIndent */
    public InputValidLabelIndent() {
        boolean test = true;
        
        while (test) {
        label:
            System.out.println("label test");
            
            if (test) {
            unusedLabel:
                System.out.println("more testing");
            }
            
        }
    label2:
        System.out.println("toplevel");
    }
    
}
