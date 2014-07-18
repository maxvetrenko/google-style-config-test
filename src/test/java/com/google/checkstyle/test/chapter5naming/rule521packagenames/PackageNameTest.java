package com.google.checkstyle.test.chapter5naming.rule521packagenames;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.puppycrawl.tools.checkstyle.checks.naming.PackageNameCheck;
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class PackageNameTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
    	
    	String msg = getCheckMessage(PackageNameCheck.class, "name.invalidPattern");
        
        final String[] expected = {
            };
        
        Configuration checkConfig = builder.getCheckConfig("PackageName");
        String filePath = builder.getFilePath("PackageNameInput");
        
        verify(checkConfig, filePath, expected);
    }
}


