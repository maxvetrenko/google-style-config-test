package com.google.checkstyle.test.chapter4formatting.rule412nonemptyblocks;

class LeftCurlyInput_Method
{ //warn
    LeftCurlyInput_Method() {} //ok
    LeftCurlyInput_Method(String aOne) {//ok
    }
    LeftCurlyInput_Method(int aOne)
    { //warn
    }

    void method1() {}//ok
    void method2() {//ok
    }
    void method3()
    { //warn
    }
    void                                                               method4()
    {//ok
    }
    void method5(String aOne,
                 String aTwo)
    {//ok
    }
    void method6(String aOne,
                 String aTwo) {//warn
    }
}

enum InputLeftCurlyMethodEnum
{//warn
    CONSTANT1("hello")
    {//warn
        void method1() {}//ok
        void method2() {
        }//ok
        void method3()
        {//warn
        }
        void                                                               method4()
        {//ok
        }
        void method5(String aOne,
                     String aTwo)
        {//ok
        }
        void method6(String aOne,
                     String aTwo) {//warn
        }
    },

    CONSTANT2("hello") {//ok

    },
    
    CONSTANT3("hellohellohellohellohellohellohellohellohellohellohellohellohellohello")
    {//ok
    };

    private InputLeftCurlyMethodEnum(String value)
    {//warn

    }

    void method1() {}//ok
    void method2() {//ok
    }
    void method3()
    {//warn
    }
    void                                                               method4()
    {//ok
    }
    void method5(String aOne,
                 String aTwo)
    {//ok
    }
    void method6(String aOne,
                 String aTwo) {//warn
    }
}

