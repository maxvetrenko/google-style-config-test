package com.google.checkstyle.test.chapter5naming.rule522typenames;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.naming.TypeNameCheck;

public class TypeNameTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
    	
    	String msg = getCheckMessage(TypeNameCheck.class, "name.invalidPattern");
        
        final String[] expected = {
        	"3:7: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "inputHeaderClass", "^[A-Z][a-zA-Z0-9]*$"),
        	"5:22: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "inputHeaderInterface", "^[A-Z][a-zA-Z0-9]*$"),
        	"7:17: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "inputHeaderEnum", "^[A-Z][a-zA-Z0-9]*$"),
            };
        
        Configuration checkConfig = builder.getCheckConfig("TypeName");
        String filePath = builder.getFilePath("TypeNameInput");
        
        verify(checkConfig, filePath, expected);
    }
}


