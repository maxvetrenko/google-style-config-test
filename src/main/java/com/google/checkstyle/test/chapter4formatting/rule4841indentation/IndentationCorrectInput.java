package com.google.checkstyle.test.chapter4formatting.rule4841indentation; // indent:0 ; exp:0; ok

import java.util.Map; // indent:0 ; exp:0; ok
import java.util.ArrayList;// indent:0 ; exp:0; ok

public abstract class IndentationCorrectInput { // indent:0 ; exp:0; ok

  static int i; // indent:2 ; exp: 2; ok
  
  int[] c = {1, 2, 3, // indent:2 ; exp: 2; ok 
      4, 5, 6}; // indent:6 ; exp: 6; ok
  
  int b; // indent:2 ; exp: 2; ok

  static { // indent:2 ; exp: 2; ok
    i = 0; // indent:4 ; exp: 4; ok
  } // indent:2 ; exp: 2; ok

  { // indent:2 ; exp: 2; ok
    b = 2; // indent:4 ; exp: 4; ok
  } // indent:2 ; exp: 2; ok

  public static final IndentationCorrectInput // indent:2 ; exp: 2; ok
      BREAKING_WHITESPACE = new IndentationCorrectInput() { // indent:6 ; exp: 6; ok
    @Override // indent:4 ; exp: 4; ok
    public boolean matches(char c) { // indent:4 ; exp: 4; ok
      switch (c) { // indent:6 ; exp: 6; ok
        case ' ': // indent:8 ; exp: 8; ok
        case '\u3000': // indent:8 ; exp: 8; ok
            return true; // indent:12 ; exp: 12; ok
        case '\u2007': // indent:8 ; exp: 8; ok
            return false; // indent:12 ; exp: 12; ok
        default: // indent:8 ; exp: 8; ok
            return c >= '\u2000' && c <= '\u200a'; // indent:12 ; exp: 12; ok
      } // indent:6 ; exp: 6; ok
    } // indent:4 ; exp:4; ok

    @Override // indent:4 ; exp: 4; ok
    public String toString() { // indent:4 ; exp:4; ok
      return "CharMatcher.BREAKING_WHITESPACE"; // indent:6 ; exp:6; ok
    } // indent:4 ; exp:4; ok
  }; // indent:2 ; exp:2; ok

  private static abstract class RangesMatcher { // indent:2 ; exp:2; ok

    private static final String ZEROES = "0\u0660\u06f0" // indent:4 ; exp:4; ok
        + "\u0c66\u0ce6" // indent:8 ; exp:8; ok
        + "\u1c40\u1c50"; // indent:8 ; exp: 8; ok

    public static final IndentationCorrectInput JAVA_LETTER_OR_DIGIT = // indent:4 ; exp:4; ok
        new IndentationCorrectInput() { // indent:8 ; exp:8; ok
      @Override public boolean matches(char c) { // indent:6 ; exp:6; ok
        return Character.isLetterOrDigit(c); // indent:8 ; exp:8; ok
      } // indent:6 ; exp:6; ok
    }; // indent:4 ; exp:4; ok

    /** Matches no characters. */
    public static final FastMatcher NONE = // indent:4 ; exp:4; ok
            new FastMatcher() { // indent:12 ; exp:>8; ok
      @Override public boolean matches(char c) { // indent:6 ; exp:6; ok
        return false; // indent:8 ; exp:8; ok
      } // indent:4 ; exp:4; ok

      @Override public String replaceFrom(CharSequence sequence, CharSequence replacement) { // indent:6 ; exp:6; ok
        checkNotNull(replacement); // indent:8 ; exp:8; ok
        return sequence.toString(); // indent:8 ; exp:8; ok
      } // indent:6 ; exp:6; ok

      private void checkNotNull(CharSequence replacement) {}

      @Override public String collapseFrom(CharSequence sequence, // indent:6 ; exp:6; ok
          char replacement) { // indent:10 ; exp:10; ok
        return sequence.toString(); // indent:8 ; exp:8; ok
      } // indent:6 ; exp:6; ok

      @Override // indent:6 ; exp:6; ok
      public String trimTrailingFrom(CharSequence sequence) { // indent:6 ; exp:6; ok
        return sequence.toString(); // indent:8 ; exp:8; ok
      } // indent:6 ; exp:6; ok
    }; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok

  public boolean matches(char c) { // indent:2 ; exp:2; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
  
  public void foo() { // indent:2 ; exp:2; ok
    int i = 0; // indent:4 ; exp:4; ok
    for (; i < 9; i++) { // indent:4 ; exp:4; ok
      if (veryLongLongLongCondition() // indent:6 ; exp:6; ok
              || veryLongLongLongCondition2()) { // indent:14 ; exp:>10; ok
        someFooMethod("longString", "veryLongString", // indent:8 ; exp:8; ok
            "superVeryExtraLongString"); // indent:12 ; exp:12; ok
        if (veryLongLongLongCondition()) { // indent:8 ; exp:8; ok
          while (veryLongLongLongCondition2() // indent:10 ; exp:10; ok
                && veryLongLongLongCondition2()) { // indent:16 ; exp:>14; ok
            try { // indent:12 ; exp:12; ok
              doSmth(); // indent:14 ; exp:14; ok
            } catch (Exception e) { // indent:12 ; exp:12; ok
              throw new AssertionError(e); // indent:14 ; exp:14; ok
            } // indent:12 ; exp:12; ok
          } // indent:10 ; exp:10; ok
        } // indent:8 ; exp:8; ok
      } // indent:6 ; exp:6; ok
    } // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok

  public boolean veryLongLongLongCondition() { // indent:2 ; exp:2; ok
	if (veryLongLongLongCondition2()) { // indent:4 ; exp:4; ok
      return true; // indent:6 ; exp:6; ok
	} // indent:4 ; exp:4; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok

  public boolean veryLongLongLongCondition2() { // indent:2 ; exp:2; ok
    return false; // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok

  public void someFooMethod(String longString, // indent:2 ; exp:2; ok
      String superLongString, String exraSuperLongString) {} // indent:6 ; exp:6; ok

  public void fooThrowMethod() // indent:2 ; exp:2; ok
          throws Exception { // indent:10 ; exp:>6; ok
      /* Some code*/
  } // indent:2 ; exp:2; ok

  public void doSmth() { // indent:2 ; exp:2; ok
    for (int h // indent:4 ; exp:4; ok
          : c) { // indent:10 ; exp:>8; ok
      someFooMethod("longString", "veryLongString", // indent:6 ; exp:6; ok
          "superVeryExtraLongString"); // indent:10 ; exp:10; ok
    } // indent:4 ; exp:4; ok
  } // indent:2 ; exp:2; ok
} // indent:0 ; exp:0; ok
