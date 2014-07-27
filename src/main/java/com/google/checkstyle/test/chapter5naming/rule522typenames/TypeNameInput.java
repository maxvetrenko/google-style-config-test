package com.google.checkstyle.test.chapter5naming.rule522typenames;

class inputHeaderClass { //warn

    public interface inputHeaderInterface {}; //warn

    public enum inputHeaderEnum { one, two }; //warn
    
    class noValidName {} //warn

}

class ValidName {} //ok
