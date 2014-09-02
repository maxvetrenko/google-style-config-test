package com.google.checkstyle.test.chapter4formatting.rule485annotations;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.puppycrawl.tools.checkstyle.checks.javadoc.AnnotationLocationCheck;
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class AnnotationLocationTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException, IOException {
        builder = new ConfigurationBuilder(new File("src/"));
    }

    @Test
    public void modifierOrderTest() throws IOException, Exception {
        
        Class<AnnotationLocationCheck> clazz = AnnotationLocationCheck.class;
        String msgLocation = "annotation.location";
        String msgLocationAlone = "annotation.location.alone";

        final String[] expected = {
        };
        
        Configuration checkConfig = builder.getCheckConfig("AnnotationLocation");
        String filePath = builder.getFilePath("AnnotationLocationInput");

        Integer[] warnList = builder.getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }
}


