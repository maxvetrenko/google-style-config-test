package com.google.checkstyle.test.chapter4formatting.rule4841indentation; // indent:0 ; exp:0; ok

class FooFieldClass { // indent:0 ; exp:0; ok
    
  boolean flag = conditionFirst("Loooooooooooooooooong", new // indent:2 ; exp:2; ok
      SecondFieldClassWithVeryVeryVeryLongName("Loooooooooooooooooog"). // indent:6 ; exp:6; ok
      getInteger(new FooFieldClass(), "Loooooooooooooooooog"), // indent:6 ; exp:6; ok
      new InnerClassFoo());
  
  boolean secondFlag = conditionSecond(10000000000.0, new // indent:2 ; exp:2; ok
      SecondFieldClassWithVeryVeryVeryLongName("Looooooooooooo" // indent:6 ; exp:6; ok
      + "oooooooooooong").getString(new FooFieldClass(), // indent:6 ; exp:6; ok
      new SecondFieldClassWithVeryVeryVeryLongName("loooooooooong"). // indent:6 ; exp:6; ok
      getInteger(new FooFieldClass(), "loooooooooooooong")), "loooooooooooong") // indent:6 ; exp:6; ok
      || conditionThird(2048) || conditionFourth(new // indent:6 ; exp:6; ok
      SecondFieldClassWithVeryVeryVeryLongName("Looooooooooooooo" // indent:6 ; exp:6; ok
      + "ooooooooooooong").getBoolean(new FooFieldClass(), false)) || // indent:6 ; exp:6; ok
      conditionFifth(true, new SecondFieldClassWithVeryVeryVeryLongName(getString(2048, "Looo" // indent:6 ; exp:6; ok
      + "ooooooooooooooooooooooooooooooooooooooooooong")).getBoolean( // indent:6 ; exp:6; ok
      new FooFieldClass(), true)) || conditionSixth(false, new // indent:6 ; exp:6; ok
      SecondFieldClassWithVeryVeryVeryLongName(getString(100000, "Loooooong" // indent:6 ; exp:6; ok
      + "Fooooooo><"))) || conditionNoArg() // indent:6 ; exp:6; ok
      || conditionNoArg() || // indent:6 ; exp:6; ok
      conditionNoArg() || conditionNoArg(); // indent:6 ; exp:6; ok

  String getString(int someInt, String someString) { // indent:2 ; exp:2; ok
    return "String"; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok

  private boolean conditionFirst(String longString, int // indent:2 ; exp:2; ok
      integer, InnerClassFoo someInstance) { // indent:6 ; exp:6; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  private boolean conditionSecond(double longLongLongDoubleValue, // indent:2 ; exp:2; ok
      String longLongLongString, String secondLongLongString) { // indent:6 ; exp:6; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  private boolean conditionThird(long veryLongValue) { // indent:2 ; exp:2; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok

  private boolean conditionFourth(boolean flag) { // indent:2 ; exp:2; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  private boolean conditionFifth(boolean flag1, boolean flag2) { // indent:2 ; exp:2; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  private boolean conditionSixth(boolean flag, // indent:2 ; exp:2; ok
      SecondFieldClassWithVeryVeryVeryLongName instance) { // indent:6 ; exp:6; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  private boolean conditionNoArg() { // indent:2 ; exp:2; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  class InnerClassFoo { // indent:2 ; exp:2; ok
      
    boolean flag = conditionFirst("Loooooooooooooooooong", new // indent:4 ; exp:4; ok
        SecondFieldClassWithVeryVeryVeryLongName("Loooooooooooooooooog"). // indent:8 ; exp:8; ok
            getInteger(new FooFieldClass(), "Loooooooooooooooooog"), // indent:12 ; exp:>8; ok
             new InnerClassFoo()); // indent:13 ; exp:>8; ok
          
    boolean secondFlag = conditionSecond(10000000000.0, new // indent:4 ; exp:4; ok
        SecondFieldClassWithVeryVeryVeryLongName("Looooooooooooo" // indent:8 ; exp:8; ok
           + "oooooooooooong").getString(new FooFieldClass(), // indent:11 ; exp:>8; ok
          new SecondFieldClassWithVeryVeryVeryLongName("loooooooooong"). // indent:10 ; exp:>8; ok
            getInteger(new FooFieldClass(), "loooooooooooooong")), "loooooooooooong") // indent:12 ; exp:>8; ok
             || conditionThird(2048) || conditionFourth(new // indent:13 ; exp:>8; ok
                SecondFieldClassWithVeryVeryVeryLongName("Looooooooooooooo" // indent:16 ; exp:>8; ok
            + "ooooooooooooong").getBoolean(new FooFieldClass(), false)) || // indent:12 ; exp:>8; ok
           conditionFifth(true, new SecondFieldClassWithVeryVeryVeryLongName(getString(2048, "Looo" // indent:11 ; exp:>8; ok
               + "ooooooooooooooooooooooooooooooooooooooooooong")).getBoolean( // indent:15 ; exp:>8; ok
            new FooFieldClass(), true)) || conditionSixth(false, new // indent:12 ; exp:>8;
            SecondFieldClassWithVeryVeryVeryLongName(getString(100000, "Loooooong" // indent:11 ; exp:>8; ok
                + "Fooooooo><"))) || conditionNoArg() // indent:16 ; exp:>8; ok
          || conditionNoArg() || // indent:10 ; exp:>8; ok
          conditionNoArg() || conditionNoArg(); // indent:10 ; exp:>8; ok

    FooFieldClass anonymousClass = new FooFieldClass() { // indent:4 ; exp:4; ok
      boolean secondFlag = conditionSecond(10000000000.0, new // indent:6 ; exp:6; ok
          SecondFieldClassWithVeryVeryVeryLongName("Looooooooooooo" // indent:10 ; exp:10; ok
            + "oooooooooooong").getString(new FooFieldClass(), // indent:12 ; exp:>10; ok
               new SecondFieldClassWithVeryVeryVeryLongName("loooooooooong"). // indent:15 ; exp:>10; ok
             getInteger(new FooFieldClass(), "loooooooooooooong")), "loooooooooooong") // indent:13 ; exp:>10; ok
              || conditionThird(2048) || conditionFourth(new // indent:14 ; exp:>10; ok
                 SecondFieldClassWithVeryVeryVeryLongName("Looooooooooooooo" // indent:17 ; exp:>10; ok
             + "ooooooooooooong").getBoolean(new FooFieldClass(), false)) || // indent:13 ; exp:>10; ok
            conditionFifth(true, new SecondFieldClassWithVeryVeryVeryLongName(getString(2048, "Looo" // indent:12 ; exp:>10; ok
                + "ooooooooooooooooooooooooooooooooooooooooooong")).getBoolean( // indent:16 ; exp:>10; ok
             new FooFieldClass(), true)) || conditionSixth(false, new // indent:13 ; exp:>8;
             SecondFieldClassWithVeryVeryVeryLongName(getString(100000, "Loooooong" // indent:12 ; exp:>10; ok
                 + "Fooooooo><"))) || conditionNoArg() // indent:17 ; exp:>10; ok
           || conditionNoArg() || // indent:11 ; exp:>10; ok
           conditionNoArg() || conditionNoArg(); // indent:11 ; exp:>10; ok
    }; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
}

class SecondFieldClassWithVeryVeryVeryLongName { // indent:0 ; exp:0; ok
    
  public SecondFieldClassWithVeryVeryVeryLongName(String string) { // indconditionTenthent:2 ; exp:2; ok
    
  } // indent:2 ; exp:2; ok
    
  String getString(FooFieldClass instance, int integer) { // indent:2 ; exp:2; ok
    return "String"; // indent:4 ; exp:4; ok  
  } // indent:2 ; exp:2; ok
  
  int getInteger(FooFieldClass instance, String string) { // indent:2 ; exp:2; ok
    return -1;   // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  boolean getBoolean(FooFieldClass instance, boolean flag) { // indent:2 ; exp:2; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  SecondFieldClassWithVeryVeryVeryLongName getInstanse() { // indent:2 ; exp:2; ok
    return new SecondFieldClassWithVeryVeryVeryLongName("VeryLoooooooooo" // indent:4 ; exp:4; ok
        + "oongString"); // indent:8 ; exp:8; ok
  } // indent:2 ; exp:2; ok
}