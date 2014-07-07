/*
 * InputValidBlockIndent.java
 *
 * Created on December 8, 2002, 12:06 PM
 */

package com.google.checkstyle.test.chapter4formatting.rule42blockindentation;

/**
 *
 * @author  jrichard
 */
public class InvalidBlockIndent {
    
    /** Creates a new instance of InputValidBlockIndent */
    public InvalidBlockIndent() {
    }
    
    public void method1() {
        
        { }
       { }
         { }
       
         {
       }
         
      {
            
      }
      {
        }
      
         {
             int var = 3;
            
             var += 3;
         }

        
      {
          int var = 3;
            
          var += 3;
      }
        
        
      {  int var = 5; }
    
        {
          int var = 3;
            
            var += 3;
            
          {
                int innerVar = 4;
                
                innerVar += var;
          }
        }
        {
            int var = 3;
            
          var += 3;
            
          {
              int innerVar = 4;
                
                innerVar += var;
            }
        }
        
        {
            int var = 3;
            
            var += 3;
            
            {
                int innerVar = 4;
                
                innerVar += var;
          }
        }
    
    }


//  static init at beginning of line is broken for now
 
    
  static { int var = 4; }
      static { int var = 4; }

    
    static {
       int var = 4; 
    }

      static {
        int var = 4; 
  }
    
  static {
        int var = 4; 
      }
    
  static 
    {
      int var = 4; 
    }
    static 
  {
      int var = 4; 
      }


    static 
    {
      int var = 4; 
    }

    static 
    {
    int var = 4; 
  }

    static 
    {
        int var = 4; 
      }

 
  { int var = 4; }
      { int var = 4; }

    
  {
        int var = 4; 
      }
    
      {
        int var = 4; 
  }
    
    {
      int var = 4; 
    }
    
}
