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
    	
        final String[] expected = {
        		"14:22: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "="),
                "14:23: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "="),
                "16:24: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "="),
                "24:14: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "="),
                "25:10: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "="),
                "25:11: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "="),
                "26:10: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "+="),
                "26:12: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "+="),
                "27:13: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "-="),
                "35:21: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "synchronized"),
                "37:12: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "try"),
                "37:12: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "{"),
                "39:14: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "catch"),
                "39:34: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "{"),
                "56:11: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "if"),
                "74:19: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "return"),
                "95:29: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "?"),
                "95:30: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "?"),
                "95:34: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", ":"),
                "95:35: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", ":"),
                "96:15: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "=="),
                "96:17: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "=="),
                "102:20: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "*"),
                "102:21: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "*"),
                "117:18: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "%"),
                "118:20: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "%"),
                "119:18: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "%"),
                "119:19: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "%"),
                "121:18: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "/"),
                "122:20: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "/"),
                "123:18: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", "/"),
                "123:19: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "/"),
                "151:15: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "assert"),
                "154:20: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notPreceded", ":"),
                "154:21: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", ":"),
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
    	
        final String[] expected = {
        	"153:27: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "="),
            "154:27: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "="),
            "155:27: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "="),
            "156:27: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "="),
            "157:27: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "="),
            "158:27: " + getCheckMessage(WhitespaceAroundCheck.class, "ws.notFollowed", "="),
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


