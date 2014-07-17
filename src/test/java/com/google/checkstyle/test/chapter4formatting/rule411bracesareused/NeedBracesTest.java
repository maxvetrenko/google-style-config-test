package com.google.checkstyle.test.chapter4formatting.rule411bracesareused;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.blocks.NeedBracesCheck;

public class NeedBracesTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
        final String[] expected = {
        	"29: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "do"),
        	"41: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "while"),
        	"42: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "while"),
        	"44: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "while"),
        	"45: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "if"),
        	"58: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "for"),
        	"59: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "for"),
        	"61: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "for"),
        	"63: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "if"),
        	"82: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "if"),
        	"83: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "if"),
        	"85: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "if"),
        	"87: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "else"),
        	"89: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "if"),
        	"97: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "else"),
        	"99: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "if"),
        	"100: " + getCheckMessage(NeedBracesCheck.class, "needBraces", "if"),
                };

        Configuration checkConfig = builder.getCheckConfig("NeedBraces");
        String filePath = builder.getFilePath("NeedBracesInput");
        
        verify(checkConfig, filePath, expected);
    }
}
