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
    public void goodTest() throws IOException, Exception {
        
        
        final String[] expected = {};
        
        Configuration checkConfig = builder.getCheckConfig("PackageName");
        String filePath = builder.getFilePath("PackageNameInputGood");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void badTest() throws IOException, Exception {
        
        Class<PackageNameCheck> clazz = PackageNameCheck.class;
        String msgKey = "name.invalidPattern";
        String packagePath = "com.google.checkstyle.test.chapter5naming.rule521packageNames";
        String format = "^[a-z]+(\\.[a-z][a-z0-9]*)*$";
        String msg = getCheckMessage(clazz, msgKey, packagePath, format);

        final String[] expected = {
            "1:9: " + msg,
        };
        
        Configuration checkConfig = builder.getCheckConfig("PackageName");
        String filePath = builder.getFilePath("PackageNameInputBad");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void bad2Test() throws IOException, Exception {
        
        
        Class<PackageNameCheck> clazz = PackageNameCheck.class;
        String msgKey = "name.invalidPattern";
        String packagePath = "com.google.checkstyle.test.chapter5naming.rule521_packagenames";
        String format = "^[a-z]+(\\.[a-z][a-z0-9]*)*$";
        String msg = getCheckMessage(clazz, msgKey, packagePath, format);

        final String[] expected = {
            "1:9: " + msg,
        };
        
        Configuration checkConfig = builder.getCheckConfig("PackageName");
        String filePath = builder.getFilePath("PackageNameInputBad2");
        
        verify(checkConfig, filePath, expected);
    }
}


