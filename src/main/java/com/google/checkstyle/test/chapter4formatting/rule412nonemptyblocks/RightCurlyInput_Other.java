package com.google.checkstyle.test.chapter4formatting.rule412nonemptyblocks;

class RightCurlyInput_Other
{
    /** @see test method **/
    int foo() throws InterruptedException
    {
        int x = 1;
        int a = 2;
        while (true)
        {
            try
            {
                if (x > 0)
                {
                    break;
                } else if (x < 0) {  //ok
                
                    ;
                } //warn
                else
                {
                    break;
                }//ok
                switch (a)
                {
                case 0:
                    break;
                default:
                    break;
                } //ok
            } //warn
            catch (Exception e)
            {
                break;
            }//ok
        }//ok

        synchronized (this)
        {
            do
            {
                x = 2;
            } while (x == 2); //ok
        }//ok

        this.wait(666
                 ); // Bizarre, but legal

        for (int k = 0; k < 1; k++)
        {
            String innerBlockVariable = "";
        }//ok

        
        if (System.currentTimeMillis() > 1000)
            return 1;
        else
            return 2;
    }//ok

    
    static
    {
        int x = 1; 
    }//ok



    public enum GreetingsEnum
    {
        HELLO,
        GOODBYE
    }; //ok

    void method2()
    {
        boolean flag = true;
        if (flag) {
            System.out.println("heh");
            flag = !flag; } System.err.  //warn
              println("Xe-xe");
        
       
        if (flag) { System.err.println("it is ok."); }
    } //ok
} //ok

/**
 * Test input for closing brace if that brace terminates 
 * a statement or the body of a constructor. 
 */
class FooCtor
{
    int i;
    public FooCtor()
    {
        i = 1;
    }} //warn

/**
* Test input for closing brace if that brace terminates 
* a statement or the body of a method. 
*/
class FooMethod
{
    public void fooMethod()
    {
        int i = 1;
    }} //warn

/**
* Test input for closing brace if that brace terminates 
* a statement or the body of a named class. 
*/
class FooInner
{
    class InnerFoo
    {
        public void fooInnerMethod ()
        {
            
        }
    }} //warn
