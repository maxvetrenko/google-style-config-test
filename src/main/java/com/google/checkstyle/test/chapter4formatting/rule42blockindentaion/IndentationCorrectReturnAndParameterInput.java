package com.google.checkstyle.test.chapter4formatting.rule42blockindentaion; // indent:0 ; exp:0; ok

class FooReturnClass { // indent:0 ; exp:0; ok
    
  String getString(int someInt, String someString) { // indent:2 ; exp:2; ok
    return "String"; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok

  boolean fooMethodWithIf() { // indent:2 ; exp:2; ok
    
    return conditionSecond(10000000000.0, new // indent:4 ; exp:4; ok
        SecondClassReturnWithVeryVeryVeryLongName("Looooooooooooo" // indent:8 ; exp:8; ok
        + "oooooooooooong").getString(new FooReturnClass(), // indent:8 ; exp:8; ok
        new SecondClassReturnWithVeryVeryVeryLongName("loooooooooong"). // indent:8 ; exp:8; ok
        getInteger(new FooReturnClass(), "loooooooooooooong")), "loooooooooooong") // indent:8 ; exp:8; ok
        || conditionThird(2048) || conditionFourth(new // indent:8 ; exp:8; ok
        SecondClassReturnWithVeryVeryVeryLongName("Looooooooooooooo" // indent:8 ; exp:8; ok
        + "ooooooooooooong").getBoolean(new FooReturnClass(), false)) || // indent:8 ; exp:8; ok
        conditionFifth(true, new SecondClassReturnWithVeryVeryVeryLongName(getString(2048, "Looo" // indent:8 ; exp:8; ok
        + "ooooooooooooooooooooooooooooooooooooooooooong")).getBoolean( // indent:8 ; exp:8; ok
        new FooReturnClass(), true)) || conditionSixth(false, new // indent:8 ; exp:8; ok
        SecondClassReturnWithVeryVeryVeryLongName(getString(100000, "Loooooong" // indent:8 ; exp:8; ok
        + "Fooooooo><"))) || conditionNoArg() // indent:8 ; exp:8; ok
        || conditionNoArg() || // indent:8 ; exp:8; ok
        conditionNoArg() || conditionNoArg();// indent:8 ; exp:8; ok
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
      SecondClassReturnWithVeryVeryVeryLongName instance) { // indent:6 ; exp:6; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  private boolean conditionNoArg() { // indent:2 ; exp:2; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  class InnerClassFoo { // indent:2 ; exp:2; ok

    boolean fooMethodWithIf() { // indent:4 ; exp:4; ok
      return conditionFirst("Loooooooooooooooooong", new // indent:6 ; exp:6; ok
          SecondClassReturnWithVeryVeryVeryLongName("Loooooooooooooooooog"). // indent:10 ; exp:10; ok
              getInteger(new FooReturnClass(), "Loooooooooooooooooog"), // indent:14 ; exp:>10; ok
              new InnerClassFoo()); // indent:14 ; exp:>10; ok
    } // indent:4 ; exp:4; ok
    
    boolean fooReturn() { // indent:4 ; exp:4; ok
      return conditionSecond(10000000000.0, new // indent:6 ; exp:6; ok
          SecondClassReturnWithVeryVeryVeryLongName("Looooooooooooo" // indent:10 ; exp:10; ok
          + "oooooooooooong").getString(new FooReturnClass(), // indent:10 ; exp:10; ok
          new SecondClassReturnWithVeryVeryVeryLongName("loooooooooong"). // indent:10 ; exp:10; ok
          getInteger(new FooReturnClass(), "loooooooooooooong")), "loooooooooooong") // indent:10 ; exp:10; ok
          || conditionThird(2048) || conditionFourth(new // indent:10 ; exp:10; ok
          SecondClassReturnWithVeryVeryVeryLongName("Looooooooooooooo" // indent:10 ; exp:10; ok
            + "ooooooooooooong").getBoolean(new FooReturnClass(), false)) || // indent:12 ; exp:>10; ok
            conditionFifth(true, new SecondClassReturnWithVeryVeryVeryLongName(getString(2048, "Looo" // indent:12 ; exp:>10; ok
            + "ooooooooooooooooooooooooooooooooooooooooooong")).getBoolean( // indent:12 ; exp:>10; ok
            new FooReturnClass(), true)) || conditionSixth(false, new // indent:12 ; exp:>10; ok
              SecondClassReturnWithVeryVeryVeryLongName(getString(100000, "Loooooong" // indent:14 ; exp:>10; ok
              + "Fooooooo><"))) || conditionNoArg() // indent:14 ; exp:>10; ok
              || conditionNoArg() || // indent:14 ; exp:>10; ok
              conditionNoArg() || conditionNoArg(); // indent:14 ; exp:>10; ok
    }

    FooReturnClass anonymousClass = new FooReturnClass() { // indent:4 ; exp:4; ok

      boolean fooMethodWithIf(String stringStringStringStringLooooongString, // indent:6 ; exp:6; ok
          int intIntIntVeryLongNameForIntVariable, boolean // indent:10 ; exp:10; ok
              fooooooooobooleanBooleanVeryLongName) { // indent:14 ; exp:>10; ok

        return conditionSecond(10000000000.0, new // indent:8 ; exp:8; ok
            SecondClassReturnWithVeryVeryVeryLongName("Looooooooooooo" // indent:12 ; exp:12; ok
            + "oooooooooooong").getString(new FooReturnClass(), // indent:12 ; exp:12; ok
            new SecondClassReturnWithVeryVeryVeryLongName("loooooooooong"). // indent:12 ; exp:12; ok
            getInteger(new FooReturnClass(), "loooooooooooooong")), "loooooooooooong") // indent:12 ; exp:12; ok
            || conditionThird(2048) || conditionFourth(new // indent:12 ; exp:12; ok
            SecondClassReturnWithVeryVeryVeryLongName("Looooooooooooooo" // indent:12 ; exp:12; ok
              + "ooooooooooooong").getBoolean(new FooReturnClass(), false)) || // indent:14 ; exp:>12; ok
              conditionFifth(true, new SecondClassReturnWithVeryVeryVeryLongName(getString(2048, "Looo" // indent:14 ; exp:>12; ok
              + "ooooooooooooooooooooooooooooooooooooooooooong")).getBoolean( // indent:14 ; exp:>12; ok
              new FooReturnClass(), true)) || conditionSixth(false, new // indent:14 ; exp:>12; ok
                SecondClassReturnWithVeryVeryVeryLongName(getString(100000, "Loooooong" // indent:16 ; exp:>12; ok
                + "Fooooooo><"))) || conditionNoArg() // indent:16 ; exp:>12; ok
                || conditionNoArg() || // indent:16 ; exp:>12; ok
                  conditionNoArg() || conditionNoArg() // indent:18 ; exp:>12; ok
                     && fooooooooobooleanBooleanVeryLongName; // indent:21 ; exp:>12; ok
      } // indent:6 ; exp:6; ok

      boolean fooReturn() { // indent:6 ; exp:6; ok
    	return conditionFirst("Loooooooooooooooooong", new // indent:8 ; exp:8; ok
    	    SecondClassReturnWithVeryVeryVeryLongName("Loooooooooooooooooog"). // indent:12 ; exp:12; ok
    	        getInteger(new FooReturnClass(), "Loooooooooooooooooog"), // indent:16 ; exp:>12; ok
    	           new InnerClassFoo()); // indent:19 ; exp:>12; ok
      }
    }; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
}

class SecondClassReturnWithVeryVeryVeryLongName { // indent:0 ; exp:0; ok
    
  public SecondClassReturnWithVeryVeryVeryLongName(String string) { // indent:2 ; exp:2; ok
    
  } // indent:2 ; exp:2; ok
    
  String getString(FooReturnClass instance, int integer) { // indent:2 ; exp:2; ok
    return "String"; // indent:4 ; exp:4; ok  
  } // indent:2 ; exp:2; ok
  
  int getInteger(FooReturnClass instance, String string) { // indent:2 ; exp:2; ok
    return -1;   // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  boolean getBoolean(FooReturnClass instance, boolean flag) { // indent:2 ; exp:2; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  SecondClassReturnWithVeryVeryVeryLongName getInstanse() { // indent:2 ; exp:2; ok
    return new SecondClassReturnWithVeryVeryVeryLongName("VeryLoooooooooo" // indent:4 ; exp:4; ok
        + "oongString"); // indent:8 ; exp:8; ok
  } // indent:2 ; exp:2; ok
}