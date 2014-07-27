package com.google.checkstyle.test.chapter3filestructure.rule3421overloadsplit;

public class DeclarationOrderInput_Overloads
{
    class overloadInput
    {
        public void overloadMethod(int i) //ok
        {
            //some foo code
        }
        
        public void overloadMethod(String s) //ok
        {
            //some foo code
        }
        
        public void overloadMethod(boolean b) //ok
        {
            //some foo code
        }
        
        public void fooMethod()
        {
            
        }
        
        //error because overloads never split
        public void overloadMethod(String s, Boolean b, int i) //warn
        {
            //some foo code
        }
    }
}

interface Fooable
{
    public abstract void foo(int i);//ok
    public abstract void foo(String s);//ok
    public abstract void noFoo();
    public abstract void foo(String s, Boolean b, int i);//warn
}

class DifferentOverloadMethos
{
	static boolean overloadMethod(boolean b)
	{ 
		return b;
	}
	
	public void noFoo() {}
	
	void overloadMethod() {}
}