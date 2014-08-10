package com.google.checkstyle.test.chapter2filebasic.rule21filename;

@MyAnnotation1(name = "ABC", version = 1)
public class OuterTypeFilenameInput_1 //ok
{

}

@interface MyAnnotation1 { //warn
    String name();
    int version();
}

enum Enum1 //ok
{
    A, B, C;
    Enum1() {}
    public String toString() {
        return ""; //some custom implementation
    }
}

interface TestRequireThisEnum //ok
{
    enum DAY_OF_WEEK
    {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }
}


