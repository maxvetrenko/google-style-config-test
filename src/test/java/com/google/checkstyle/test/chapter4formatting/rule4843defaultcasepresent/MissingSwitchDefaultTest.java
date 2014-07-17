package com.google.checkstyle.test.chapter4formatting.rule4843defaultcasepresent;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.puppycrawl.tools.checkstyle.checks.coding.MissingSwitchDefaultCheck;
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class MissingSwitchDefaultTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
    	String msg = getCheckMessage(MissingSwitchDefaultCheck.class, "missing.switch.default");

        final String[] expected = {
                "17:9: " + msg,
                };
        
        Configuration checkConfig = builder.getCheckConfig("MissingSwitchDefault");
        String filePath = builder.getFilePath("MissingSwitchDefaultInput");
        
        verify(checkConfig, filePath, expected);
    }
}


