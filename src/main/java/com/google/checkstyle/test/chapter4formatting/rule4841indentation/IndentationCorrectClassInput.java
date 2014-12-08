package com.google.checkstyle.test.chapter4formatting.rule4841indentation;  // indent:0 ; exp:0; ok

import java.util.Iterator;  // indent:0 ; exp:0; ok

public class IndentationCorrectClassInput  // indent:0 ; exp:0; ok
    implements Runnable, Cloneable {  // indent:4 ; exp:4; ok
    
  class InnerClass implements  // indent:2 ; exp:2; ok
          Iterable<String>,  // indent:11 ; exp:>6; ok
             Cloneable {  // indent:13 ; exp:>6; ok
    @Override
    public Iterator<String> iterator() {  // indent:4 ; exp:4; ok
      return null;  // indent:6 ; exp:6; ok
    }  // indent:4 ; exp:4; ok
  }  // indent:2 ; exp:2; ok
  
  class InnerClass2  // indent:2 ; exp:2; ok
       extends  // indent:7 ; exp:>6; ok
          SecondClassReturnWithVeryVeryVeryLongName {  // indent:10 ; exp:>6; ok
    public InnerClass2(String string) {  // indent:4 ; exp:4; ok
      super(string);  // indent:6 ; exp:6; ok
      // TODO Auto-generated constructor stub
    }  // indent:4 ; exp:4; ok
  }  // indent:2 ; exp:2; ok

  @Override  // indent:2 ; exp:2; ok
  public void run() {  // indent:2 ; exp:2; ok
    SecondClassWithLongLongLongLongName anon =  // indent:4 ; exp:4; ok
          new SecondClassWithLongLongLongLongName() {  // indent:10 ; exp:>8; ok

    };  // indent:4 ; exp:4; ok
    
    SecondClassWithLongLongLongLongName anon2 = new  // indent:4 ; exp:4; ok
          SecondClassWithLongLongLongLongName() {  // indent:10 ; exp:>8; ok

    };  // indent:4 ; exp:4; ok
  }  // indent:2 ; exp:2; ok
}

class SecondClassWithLongLongLongLongName  // indent:0 ; exp:0; ok
    extends  // indent:4 ; exp:4; ok
         IndentationCorrectClassInput{  // indent:9 ; exp:>4; ok
  
}  // indent:0 ; exp:0; ok
