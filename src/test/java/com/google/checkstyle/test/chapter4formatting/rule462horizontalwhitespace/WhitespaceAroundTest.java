package com.google.checkstyle.test.chapter4formatting.rule462horizontalwhitespace;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.whitespace.GenericWhitespaceCheck;
import com.puppycrawl.tools.checkstyle.checks.whitespace.WhitespaceAroundCheck;

public class WhitespaceAroundTest extends BaseCheckTestSupport{

    static ConfigurationBuilder builder;

    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
            "checkstyle_google_style.xml");
    }

    @Test
    public void whitespaceAroundBasicTest() throws IOException, Exception {
        
        Class<WhitespaceAroundCheck> clazz = WhitespaceAroundCheck.class;
        String msgPreceded = "ws.notPreceded";
        String msgFollowed = "ws.notFollowed";

        final String[] expected = {
            "10:22: " + getCheckMessage(clazz, msgPreceded, "="),
            "10:23: " + getCheckMessage(clazz, msgFollowed, "="),
            "12:24: " + getCheckMessage(clazz, msgFollowed, "="),
            "20:14: " + getCheckMessage(clazz, msgPreceded, "="),
            "21:10: " + getCheckMessage(clazz, msgPreceded, "="),
            "21:11: " + getCheckMessage(clazz, msgFollowed, "="),
            "22:10: " + getCheckMessage(clazz, msgPreceded, "+="),
            "22:12: " + getCheckMessage(clazz, msgFollowed, "+="),
            "23:13: " + getCheckMessage(clazz, msgFollowed, "-="),
            "31:21: " + getCheckMessage(clazz, msgFollowed, "synchronized"),
            "33:12: " + getCheckMessage(clazz, msgFollowed, "try"),
            "33:12: " + getCheckMessage(clazz, msgPreceded, "{"),
            "35:14: " + getCheckMessage(clazz, msgFollowed, "catch"),
            "35:34: " + getCheckMessage(clazz, msgPreceded, "{"),
            "52:11: " + getCheckMessage(clazz, msgFollowed, "if"),
            "70:19: " + getCheckMessage(clazz, msgFollowed, "return"),
            "91:29: " + getCheckMessage(clazz, msgPreceded, "?"),
            "91:30: " + getCheckMessage(clazz, msgFollowed, "?"),
            "91:34: " + getCheckMessage(clazz, msgPreceded, ":"),
            "91:35: " + getCheckMessage(clazz, msgFollowed, ":"),
            "92:15: " + getCheckMessage(clazz, msgPreceded, "=="),
            "92:17: " + getCheckMessage(clazz, msgFollowed, "=="),
            "98:20: " + getCheckMessage(clazz, msgFollowed, "*"),
            "98:21: " + getCheckMessage(clazz, msgPreceded, "*"),
            "113:18: " + getCheckMessage(clazz, msgPreceded, "%"),
            "114:20: " + getCheckMessage(clazz, msgFollowed, "%"),
            "115:18: " + getCheckMessage(clazz, msgPreceded, "%"),
            "115:19: " + getCheckMessage(clazz, msgFollowed, "%"),
            "117:18: " + getCheckMessage(clazz, msgPreceded, "/"),
            "118:20: " + getCheckMessage(clazz, msgFollowed, "/"),
            "119:18: " + getCheckMessage(clazz, msgPreceded, "/"),
            "119:19: " + getCheckMessage(clazz, msgFollowed, "/"),
            "147:15: " + getCheckMessage(clazz, msgFollowed, "assert"),
            "150:20: " + getCheckMessage(clazz, msgPreceded, ":"),
            "150:21: " + getCheckMessage(clazz, msgFollowed, ":"),
        };

        Configuration checkConfig = builder.getCheckConfig("WhitespaceAround");
        String filePath = builder.getFilePath("WhitespaceAroundInput");

        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void whitespaceAroundGenericsTest() throws IOException, Exception {
        
        String msgPreceded = "ws.preceded";
        String msgFollowed = "ws.followed";
        
        Class<GenericWhitespaceCheck> clazz = GenericWhitespaceCheck.class;
        final String[] expected = {
            "12:16: " + getCheckMessage(clazz, msgPreceded, "<"),
            "12:18: " + getCheckMessage(clazz, msgFollowed, "<"),
            "12:36: " + getCheckMessage(clazz, msgPreceded, "<"),
            "12:38: " + getCheckMessage(clazz, msgFollowed, "<"),
            "12:47: " + getCheckMessage(clazz, msgPreceded, ">"),
            "12:49: " + getCheckMessage(clazz, msgFollowed, ">"),
            "12:49: " + getCheckMessage(clazz, msgPreceded, ">"),
            "14:32: " + getCheckMessage(clazz, msgPreceded, "<"),
            "14:34: " + getCheckMessage(clazz, msgFollowed, "<"),
            "14:45: " + getCheckMessage(clazz, msgPreceded, ">"),
            "15:32: " + getCheckMessage(clazz, msgPreceded, "<"),
            "15:34: " + getCheckMessage(clazz, msgFollowed, "<"),
            "15:45: " + getCheckMessage(clazz, msgPreceded, ">"),
            "20:38: " + getCheckMessage(clazz, msgPreceded, "<"),
            "20:40: " + getCheckMessage(clazz, msgFollowed, "<"),
            "20:61: " + getCheckMessage(clazz, msgPreceded, ">"),
        };

        Configuration checkConfig = builder.getCheckConfig("GenericWhitespace");
        String filePath = builder.getFilePath("WhitespaceAroundInput_Generics");

        verify(checkConfig, filePath, expected);
    }
    @Test
    public void whitespaceAroundEmptyTypesCyclesTest() throws IOException, Exception {
        
        final String[] expected = {};

        Configuration checkConfig = builder.getCheckConfig("WhitespaceAround");
        String filePath = builder.getFilePath("WhitespaceAroundnput_EmptyTypesAndCycles");

        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void genericWhitespaceTest() throws IOException, Exception
    {
        Class<GenericWhitespaceCheck> clazz = GenericWhitespaceCheck.class;
        String msgPreceded = "ws.preceded";
        String msgFollowed = "ws.followed";
        String msgNotPreceded = "ws.notPreceded";
        String msgIllegalFollow = "ws.illegalFollow";
        
        
        final String[] expected = {
            "16:13: " + getCheckMessage(clazz, msgPreceded, "<"),
            "16:15: " + getCheckMessage(clazz, msgFollowed, "<"),
            "16:23: " + getCheckMessage(clazz, msgPreceded, ">"),
            "16:43: " + getCheckMessage(clazz, msgPreceded, "<"),
            "16:45: " + getCheckMessage(clazz, msgFollowed, "<"),
            "16:53: " + getCheckMessage(clazz, msgPreceded, ">"),
            "17:13: " + getCheckMessage(clazz, msgPreceded, "<"),
            "17:15: " + getCheckMessage(clazz, msgFollowed, "<"),
            "17:20: " + getCheckMessage(clazz, msgPreceded, "<"),
            "17:22: " + getCheckMessage(clazz, msgFollowed, "<"),
            "17:30: " + getCheckMessage(clazz, msgPreceded, ">"),
            "17:32: " + getCheckMessage(clazz, msgFollowed, ">"),
            "17:32: " + getCheckMessage(clazz, msgPreceded, ">"),
            "17:52: " + getCheckMessage(clazz, msgPreceded, "<"),
            "17:54: " + getCheckMessage(clazz, msgFollowed, "<"),
            "17:59: " + getCheckMessage(clazz, msgPreceded, "<"),
            "17:61: " + getCheckMessage(clazz, msgFollowed, "<"),
            "17:69: " + getCheckMessage(clazz, msgPreceded, ">"),
            "17:71: " + getCheckMessage(clazz, msgFollowed, ">"),
            "17:71: " + getCheckMessage(clazz, msgPreceded, ">"),
            "30:17: " + getCheckMessage(clazz, msgNotPreceded, "<"),
            "30:21: " + getCheckMessage(clazz, msgIllegalFollow, ">"),
            "42:21: " + getCheckMessage(clazz, msgPreceded, "<"),
            "42:30: " + getCheckMessage(clazz, msgFollowed, ">"),
            "60:60: " + getCheckMessage(clazz, msgNotPreceded, "&"),
            "63:60: " + getCheckMessage(clazz, msgFollowed, ">"),
        };

        Configuration checkConfig = builder.getCheckConfig("GenericWhitespace");
        String filePath = builder.getFilePath("GenericWhitespaceInput");

        verify(checkConfig, filePath, expected);
    }
}


