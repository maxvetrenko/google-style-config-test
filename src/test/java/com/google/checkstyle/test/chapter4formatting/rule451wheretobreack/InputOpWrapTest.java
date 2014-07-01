package com.google.checkstyle.test.chapter4formatting.rule451wheretobreack;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.puppycrawl.tools.checkstyle.checks.coding.FallThroughCheck;
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class InputOpWrapTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
//    	String msg = getCheckMessage("fall.through", "whitespace");

        final String[] expected = {
        	"sdfdsfsdf" + getCheckMessage(FallThroughCheck.class, "line.new")
            };

        Configuration checkConfig = builder.getCheckConfig("OperatorWrap");
        String filePath = builder.getFilePath("InputOpWra");

        verify(checkConfig, filePath, expected);
    }
}


