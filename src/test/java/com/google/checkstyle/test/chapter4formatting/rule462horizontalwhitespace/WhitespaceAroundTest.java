package com.google.checkstyle.test.chapter4formatting.rule462horizontalwhitespace;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.whitespace.EmptyLineSeparatorCheck;
import com.puppycrawl.tools.checkstyle.checks.whitespace.WhitespaceAroundCheck;

public class WhitespaceAroundTest extends BaseCheckTestSupport{

    static ConfigurationBuilder builder;

    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void WhitespaceAroundBasicTest() throws IOException, Exception {
    	
        Class<WhitespaceAroundCheck> clazz = WhitespaceAroundCheck.class;
		String masgPreceded = "ws.notPreceded";
		String msgFollowed = "ws.notFollowed";

		final String[] expected = {
        		"14:22: " + getCheckMessage(clazz, masgPreceded, "="),
                "14:23: " + getCheckMessage(clazz, msgFollowed, "="),
                "16:24: " + getCheckMessage(clazz, msgFollowed, "="),
                "24:14: " + getCheckMessage(clazz, masgPreceded, "="),
                "25:10: " + getCheckMessage(clazz, masgPreceded, "="),
                "25:11: " + getCheckMessage(clazz, msgFollowed, "="),
                "26:10: " + getCheckMessage(clazz, masgPreceded, "+="),
                "26:12: " + getCheckMessage(clazz, msgFollowed, "+="),
                "27:13: " + getCheckMessage(clazz, msgFollowed, "-="),
                "35:21: " + getCheckMessage(clazz, msgFollowed, "synchronized"),
                "37:12: " + getCheckMessage(clazz, msgFollowed, "try"),
                "37:12: " + getCheckMessage(clazz, masgPreceded, "{"),
                "39:14: " + getCheckMessage(clazz, msgFollowed, "catch"),
                "39:34: " + getCheckMessage(clazz, masgPreceded, "{"),
                "56:11: " + getCheckMessage(clazz, msgFollowed, "if"),
                "74:19: " + getCheckMessage(clazz, msgFollowed, "return"),
                "95:29: " + getCheckMessage(clazz, masgPreceded, "?"),
                "95:30: " + getCheckMessage(clazz, msgFollowed, "?"),
                "95:34: " + getCheckMessage(clazz, masgPreceded, ":"),
                "95:35: " + getCheckMessage(clazz, msgFollowed, ":"),
                "96:15: " + getCheckMessage(clazz, masgPreceded, "=="),
                "96:17: " + getCheckMessage(clazz, msgFollowed, "=="),
                "102:20: " + getCheckMessage(clazz, msgFollowed, "*"),
                "102:21: " + getCheckMessage(clazz, masgPreceded, "*"),
                "117:18: " + getCheckMessage(clazz, masgPreceded, "%"),
                "118:20: " + getCheckMessage(clazz, msgFollowed, "%"),
                "119:18: " + getCheckMessage(clazz, masgPreceded, "%"),
                "119:19: " + getCheckMessage(clazz, msgFollowed, "%"),
                "121:18: " + getCheckMessage(clazz, masgPreceded, "/"),
                "122:20: " + getCheckMessage(clazz, msgFollowed, "/"),
                "123:18: " + getCheckMessage(clazz, masgPreceded, "/"),
                "123:19: " + getCheckMessage(clazz, msgFollowed, "/"),
                "151:15: " + getCheckMessage(clazz, msgFollowed, "assert"),
                "154:20: " + getCheckMessage(clazz, masgPreceded, ":"),
                "154:21: " + getCheckMessage(clazz, msgFollowed, ":"),
        };

        Configuration checkConfig = builder.getCheckConfig("WhitespaceAround");
        String filePath = builder.getFilePath("WhitespaceAroundInput");

        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void WhitespaceAroundGenericsTest() throws IOException, Exception {
    	
        final String[] expected = {
        };

        Configuration checkConfig = builder.getCheckConfig("WhitespaceAround");
        String filePath = builder.getFilePath("WhitespaceAroundInput_Generics");

        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void WhitespaceAroundSimpleTest() throws IOException, Exception {
    	
        String checkMessage = getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "=");

		final String[] expected = {
        	"153:27: " + checkMessage,
            "154:27: " + checkMessage,
            "155:27: " + checkMessage,
            "156:27: " + checkMessage,
            "157:27: " + checkMessage,
            "158:27: " + checkMessage,
        };

        Configuration checkConfig = builder.getCheckConfig("WhitespaceAround");
        String filePath = builder.getFilePath("WhitespaceAroundInput_Simple");

        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void WhitespaceAroundEmptyTypesCyclesTest() throws IOException, Exception {
    	
        final String[] expected = {
        };

        Configuration checkConfig = builder.getCheckConfig("WhitespaceAround");
        String filePath = builder.getFilePath("WhitespaceAroundnput_EmptyTypesAndCycles");

        verify(checkConfig, filePath, expected);
    }
}


