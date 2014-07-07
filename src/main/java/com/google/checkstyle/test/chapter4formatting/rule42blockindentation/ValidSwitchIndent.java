/*
 * InputValidSwitchIndent.java
 *
 * Created on November 27, 2002, 11:40 PM
 */

package com.google.checkstyle.test.chapter4formatting.rule42blockindentation;

/**
 *
 * @author  jrichard
 */
public class ValidSwitchIndent {
    
    private static final int CONST = 5;
    private static final int CONST2 = 2;
    private static final int CONST3 = 3;
    
    /** Creates a new instance of InputValidSwitchIndent */
    public ValidSwitchIndent() {
    }
    
    private void method1() {
        int s = 3;
        
        switch (s) {
            
            case 4:
                System.out.println("");
                break;

            case CONST:
                break;

            case CONST2:
            case CONST3:
                break;

            default:
                System.out.println("");
                break;
        }
        

        // some people like to add curlys to their cases:
        switch (s) {
            
            case 4: {
                System.out.println("");
                break;
            }

            case CONST:
                break;

            case CONST2:
            case CONST3:
            {
                System.out.println("");
                break;
            }

            default:
                break;
        }
         
        // check broken 'case' lines
        switch (s) {
            
            case 
                4: {
                System.out.println("");
                break;
            }

            case 
                CONST:
                break;

            case CONST2:
            case 
                CONST3:
            {
                System.out.println("");
                break;
            }

            default:
                break;
        }        

        switch (s) {
        }

        
        switch (s) {
            default:
                System.out.println("");
                break;
        }
        
    }
    
}
