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
        
        final String[] expected = {
        	"15:19: " + getCheckMessage(OperatorWrapCheck.class, "line.new", "+"),
        	"16:15: " + getCheckMessage(OperatorWrapCheck.class, "line.new", "-"),
        	"24:18: " + getCheckMessage(OperatorWrapCheck.class, "line.new", "&&"),
        	"39:30: " + getCheckMessage(OperatorWrapCheck.class, "line.new", "&"),
        };

        Configuration checkConfig = builder.getCheckConfig("OperatorWrap");
        String filePath = builder.getFilePath("OperatorWrapInput");

        verify(checkConfig, filePath, expected);
    }
}


