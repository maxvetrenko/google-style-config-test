package com.google.checkstyle.test.chapter4formatting.rule42blockindentaion; // indent:0 ; exp:0; ok

import java.util.ArrayList; // indent:0 ; exp:0; ok
import java.util.HashMap; // indent:0 ; exp:0; ok
import java.util.Iterator; // indent:0 ; exp:0; ok
import java.util.List; // indent:0 ; exp:0; ok
import java.util.Map; // indent:0 ; exp:0; ok

class FooForClass { // indent:0 ; exp:0; ok
    
  String getString(int someInt, String someString) { // indent:2 ; exp:2; ok
    return "String"; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok

  void fooMethodWithIf() { // indent:2 ; exp:2; ok

    for (int i = 1; i < 10; i ++) {} // indent:4 ; exp:4; ok
    
    for (int i = new SecondForClassWithVeryVeryVeryLongName("Loooooooooooooooooooo" // indent:4 ; exp:4; ok
        + "oong").getInteger(new FooForClass(), // indent:8 ; exp:8; ok
          getString(1000000000, "Loooooooooooooooong")); i < 10; i++) {} // indent:10 ; exp:>8; ok

    for (Map.Entry<String, String> entry : new SecondForClassWithVeryVeryVeryLongName("Loo" // indent:4 ; exp:4; ok
        + "ooooooooooooooooooooong").getMap(new // indent:8 ; exp:8; ok
        FooForClass(), 10000000, // indent:8 ; exp:8; ok
        getString(10000, "Loooooooooo" // indent:8 ; exp:8; ok
        + "ooooong")).entrySet()) {} // indent:8 ; exp:8; ok
    
    for (Map.Entry<String, String> entry : new SecondForClassWithVeryVeryVeryLongName("Loo" // indent:4 ; exp:4; ok
        + "ooooooooooooooooooooong").getMap(new // indent:8 ; exp:8; ok
            FooForClass(), 10000000, // indent:12 ; exp:>8; ok
          getString(10000, "Loooooooooo" // indent:10 ; exp:>8; ok
               + "ooooong")).entrySet()) {} // indent:15 ; exp:>8; ok
    
    for (String string : new SecondForClassWithVeryVeryVeryLongName(getString(1024 // indent:4 ; exp:4; ok
        , "Looooooooooooooooooong")). // indent:8 ; exp:8; ok
        getList(new FooForClass(), 1000, getString(1024, // indent:8 ; exp:8; ok
        "Loooooooooooooooooooooooooooooooo" // indent:8 ; exp:8; ok
        + "oooooooooooooooooooooooooooooooooooooooo" // indent:8 ; exp:8; ok
        + "oooooooooong"))) {} // indent:8 ; exp:8; ok
    
    for (String string : new SecondForClassWithVeryVeryVeryLongName(getString(1024 // indent:4 ; exp:4; ok
        , "Looooooooooooooooooong")). // indent:8 ; exp:8; ok
            getList(new FooForClass(), 1000, getString(1024, // indent:12 ; exp:>8; ok
              "Loooooooooooooooooooooooooooooooo" // indent:14 ; exp:>8; ok
          + "oooooooooooooooooooooooooooooooooooooooo" // indent:10 ; exp:>8; ok
             + "oooooooooong"))) {} // indent:13 ; exp:>8; ok
    
  } // indent:2 ; exp:2; ok
  
  class InnerClassFoo { // indent:2 ; exp:2; ok

    void fooMethodWithIf() { // indent:4 ; exp:4; ok

      for (int i = 1; i < 10; i ++) {} // indent:6 ; exp:6; ok

      for (int i = new SecondForClassWithVeryVeryVeryLongName("Loooooooooooooooooooo" // indent:6 ; exp:6; ok
          + "oong").getInteger(new FooForClass(), // indent:10 ; exp:10; ok
            getString(1000000000, "Loooooooooooooooong")); i < 10; i++) {} // indent:12 ; exp:>10; ok

      for (Map.Entry<String, String> entry : new SecondForClassWithVeryVeryVeryLongName("Loo" // indent:6 ; exp:6; ok
          + "ooooooooooooooooooooong").getMap(new // indent:10 ; exp:10; ok
          FooForClass(), 10000000, // indent:10 ; exp:10; ok
          getString(10000, "Loooooooooo" // indent:10 ; exp:10; ok
          + "ooooong")).entrySet()) {} // indent:10 ; exp:10; ok

      for (Map.Entry<String, String> entry : new SecondForClassWithVeryVeryVeryLongName("Loo" // indent:6 ; exp:6; ok
            + "ooooooooooooooooooooong").getMap(new // indent:12 ; exp:>10; ok
             FooForClass(), 10000000, // indent:13 ; exp:>10; ok
                  getString(10000, "Loooooooooo" // indent:18 ; exp:>10; ok
               + "ooooong")).entrySet()) {} // indent:15 ; exp:>10; ok
        
      for (String string : new SecondForClassWithVeryVeryVeryLongName(getString(1024 // indent:6 ; exp:6; ok
          , "Looooooooooooooooooong")). // indent:10 ; exp:10; ok
          getList(new FooForClass(), 1000, getString(1024, // indent:10 ; exp:10; ok
          "Loooooooooooooooooooooooooooooooo" // indent:10 ; exp:10; ok
          + "oooooooooooooooooooooooooooooooooooooooo" // indent:10 ; exp:10; ok
          + "oooooooooong"))) {} // indent:10 ; exp:10; ok

      for (String string : new SecondForClassWithVeryVeryVeryLongName(getString(1024 // indent:6 ; exp:6; ok
               , "Looooooooooooooooooong")). // indent:15 ; exp:>10; ok
             getList(new FooForClass(), 1000, getString(1024, // indent:13 ; exp:>10; ok
                   "Loooooooooooooooooooooooooooooooo" // indent:19 ; exp:>10; ok
                     + "oooooooooooooooooooooooooooooooooooooooo" // indent:21 ; exp:>10; ok
          + "oooooooooong"))) {} // indent:10 ; exp:10; ok
    } // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
}

class SecondForClassWithVeryVeryVeryLongName // indent:0 ; exp:0; ok
        implements Iterable<String>{ // indent:8 ; exp:>4; ok
    
  public SecondForClassWithVeryVeryVeryLongName(String string) { // indent:2 ; exp:2; ok
    
  } // indent:2 ; exp:2; ok
    
  int getInteger(FooForClass instance, String string) { // indent:2 ; exp:2; ok
    return -1;   // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  Map<String, String> getMap(FooForClass instance, int integer, String string) { // indent:2 ; exp:2; ok
    return new HashMap<String, String>(); // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  List<String> getList(FooForClass instance, long longLong, String string) { // indent:2 ; exp:2; ok
    return new ArrayList<String>(); // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok

  public Iterator<String> iterator() { // indent:2 ; exp:2; ok
    return null; // indent:6 ; exp:6; ok
  } // indent:2 ; exp:2; ok
}