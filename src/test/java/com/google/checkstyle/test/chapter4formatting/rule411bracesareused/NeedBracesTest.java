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
        
        Class<NeedBracesCheck> clazz = NeedBracesCheck.class;
		String messageKey = "needBraces";

		final String[] expected = {
        	"29: " + getCheckMessage(clazz, messageKey, "do"),
        	"41: " + getCheckMessage(clazz, messageKey, "while"),
        	"42: " + getCheckMessage(clazz, messageKey, "while"),
        	"44: " + getCheckMessage(clazz, messageKey, "while"),
        	"45: " + getCheckMessage(clazz, messageKey, "if"),
        	"58: " + getCheckMessage(clazz, messageKey, "for"),
        	"59: " + getCheckMessage(clazz, messageKey, "for"),
        	"61: " + getCheckMessage(clazz, messageKey, "for"),
        	"63: " + getCheckMessage(clazz, messageKey, "if"),
        	"82: " + getCheckMessage(clazz, messageKey, "if"),
        	"83: " + getCheckMessage(clazz, messageKey, "if"),
        	"85: " + getCheckMessage(clazz, messageKey, "if"),
        	"87: " + getCheckMessage(clazz, messageKey, "else"),
        	"89: " + getCheckMessage(clazz, messageKey, "if"),
        	"97: " + getCheckMessage(clazz, messageKey, "else"),
        	"99: " + getCheckMessage(clazz, messageKey, "if"),
        	"100: " + getCheckMessage(clazz, messageKey, "if"),
                };

        Configuration checkConfig = builder.getCheckConfig("NeedBraces");
        String filePath = builder.getFilePath("NeedBracesInput");
        
        verify(checkConfig, filePath, expected);
    }
}
