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
    public static void setConfigurationBuilder() throws CheckstyleException, IOException {
        builder = new ConfigurationBuilder(new File("src/"));
    }

    @Test
    public void whitespaceAroundBasicTest() throws IOException, Exception {
        
        Configuration checkConfig = builder.getCheckConfig("WhitespaceAround");
        String msgPreceded = "ws.notPreceded";
        String msgFollowed = "ws.notFollowed";

        final String[] expected = {
            "10:22: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "="),
            "10:23: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "="),
            "12:24: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "="),
            "20:14: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "="),
            "21:10: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "="),
            "21:11: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "="),
            "22:10: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "+="),
            "22:12: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "+="),
            "23:13: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "-="),
            "31:21: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "synchronized"),
            "33:12: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "try"),
            "33:12: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "{"),
            "35:14: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "catch"),
            "35:34: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "{"),
            "52:11: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "if"),
            "70:19: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "return"),
            "91:29: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "?"),
            "91:30: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "?"),
            "91:34: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ":"),
            "91:35: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, ":"),
            "92:15: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "=="),
            "92:17: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "=="),
            "98:20: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "*"),
            "98:21: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "*"),
            "113:18: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "%"),
            "114:20: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "%"),
            "115:18: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "%"),
            "115:19: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "%"),
            "117:18: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "/"),
            "118:20: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "/"),
            "119:18: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "/"),
            "119:19: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "/"),
            "147:15: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "assert"),
            "150:20: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ":"),
            "150:21: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, ":"),
        };

        String filePath = builder.getFilePath("WhitespaceAroundInput_Basic");

        Integer[] warnList = builder.getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }
    
    @Test
    public void whitespaceAroundGenericsTest() throws IOException, Exception {
        
        String msgPreceded = "ws.preceded";
        String msgFollowed = "ws.followed";
        Configuration checkConfig = builder.getCheckConfig("GenericWhitespace");
        
        final String[] expected = {
            "12:16: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "<"),
            "12:18: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "<"),
            "12:36: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "<"),
            "12:38: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "<"),
            "12:47: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ">"),
            "12:49: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, ">"),
            "12:49: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ">"),
            "14:32: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "<"),
            "14:34: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "<"),
            "14:45: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ">"),
            "15:32: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "<"),
            "15:34: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "<"),
            "15:45: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ">"),
            "20:38: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "<"),
            "20:40: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "<"),
            "20:61: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ">"),
        };

        String filePath = builder.getFilePath("WhitespaceAroundInput_Generics");

        Integer[] warnList = builder.getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }
    @Test
    public void whitespaceAroundEmptyTypesCyclesTest() throws IOException, Exception {
        
        final String[] expected = {};

        Configuration checkConfig = builder.getCheckConfig("WhitespaceAround");
        String filePath = builder.getFilePath("WhitespaceAroundnput_EmptyTypesAndCycles");

        Integer[] warnList = builder.getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }
    
    @Test
    public void genericWhitespaceTest() throws IOException, Exception
    {
        String msgPreceded = "ws.preceded";
        String msgFollowed = "ws.followed";
        String msgNotPreceded = "ws.notPreceded";
        String msgIllegalFollow = "ws.illegalFollow";
        Configuration checkConfig = builder.getCheckConfig("GenericWhitespace");
        
        
        final String[] expected = {
            "16:13: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "<"),
            "16:15: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "<"),
            "16:23: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ">"),
            "16:43: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "<"),
            "16:45: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "<"),
            "16:53: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ">"),
            "17:13: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "<"),
            "17:15: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "<"),
            "17:20: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "<"),
            "17:22: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "<"),
            "17:30: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ">"),
            "17:32: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, ">"),
            "17:32: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ">"),
            "17:52: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "<"),
            "17:54: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "<"),
            "17:59: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "<"),
            "17:61: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, "<"),
            "17:69: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ">"),
            "17:71: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, ">"),
            "17:71: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, ">"),
            "30:17: " + getCheckMessage(checkConfig.getMessages(), msgNotPreceded, "<"),
            "30:21: " + getCheckMessage(checkConfig.getMessages(), msgIllegalFollow, ">"),
            "42:21: " + getCheckMessage(checkConfig.getMessages(), msgPreceded, "<"),
            "42:30: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, ">"),
            "60:60: " + getCheckMessage(checkConfig.getMessages(), msgNotPreceded, "&"),
            "63:60: " + getCheckMessage(checkConfig.getMessages(), msgFollowed, ">"),
        };

        String filePath = builder.getFilePath("GenericWhitespaceInput");

        Integer[] warnList = builder.getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }
}


