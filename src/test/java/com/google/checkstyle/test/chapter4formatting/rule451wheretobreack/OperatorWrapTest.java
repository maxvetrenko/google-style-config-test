package com.google.checkstyle.test.chapter4formatting.rule451wheretobreack;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.whitespace.OperatorWrapCheck;

public class OperatorWrapTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
        Class<OperatorWrapCheck> clazz = OperatorWrapCheck.class;
		String messageKey = "line.new";

		final String[] expected = {
        	"15:19: " + getCheckMessage(clazz, messageKey, "+"),
        	"16:15: " + getCheckMessage(clazz, messageKey, "-"),
        	"24:18: " + getCheckMessage(clazz, messageKey, "&&"),
        	"39:30: " + getCheckMessage(clazz, messageKey, "&"),
        };

        Configuration checkConfig = builder.getCheckConfig("OperatorWrap");
        String filePath = builder.getFilePath("OperatorWrapInput");

        verify(checkConfig, filePath, expected);
    }
}


