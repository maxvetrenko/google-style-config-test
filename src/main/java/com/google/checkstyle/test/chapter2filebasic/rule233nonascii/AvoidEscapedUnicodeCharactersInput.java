package com.google.checkstyle.test.chapter2filebasic.rule233nonascii;

public class AvoidEscapedUnicodeCharactersInput {
	
	private String unitAbbrev2 = "\u03bcs"; //warn

	private String unitAbbrev3 = "\u03bcs"; //Greek letter mu ok

	private String unitAbbrev4 =
			"\u03bcs"; //Greek letter mu

	public Object fooString()
	{
		String unitAbbrev = "μs";
		String unitAbbrev2 = "\u03bcs"; //warn
		String unitAbbrev3 = "\u03bcs"; // Greek letter mu, "s" ok
		String fakeUnicode = "asd\tsasd"; 
		String fakeUnicode2 = "\\u23\\u123i\\u";
		String content = "";
		return "\ufeff" + content ; // byte order mark ok
	}

	public Object fooChar()
	{
		char unitAbbrev2 = '\u03bc'; //warn
		char unitAbbrev3 = '\u03bc'; // Greek letter mu, "s" ok
		String content = "";
		return '\ufeff' + content; // byte order mark ok
	}

	public void multiplyString()
	{
		String unitAbbrev2 = "asd\u03bcsasd"; //warn
		String unitAbbrev3 = "aBc\u03bcssdf\u03bc"; /* Greek letter mu, "s"*/ //ok
		String unitAbbrev4 = "\u03bcaBc\u03bcssdf\u03bc"; //warn
		String allCharactersEscaped = "\u03bc\u03bc"; //ok
	}
}