package com.google.checkstyle.test.chapter4formatting.rule485annotations;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.puppycrawl.tools.checkstyle.checks.annotation.AnnotationLocationCheck;
import com.puppycrawl.tools.checkstyle.checks.coding.MissingSwitchDefaultCheck;
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
        getCheckMessage(clazz, "annotation.location.alone");
        Configuration checkConfig = builder.getCheckConfig("AnnotationLocation");

        final String[] expected = {
            "3: " + getCheckMessage(clazz, msgLocationAlone, "MyAnnotation1"),
            "20: " + getCheckMessage(clazz, msgLocation, "MyAnnotation1", "8", "4"),
            "23: " + getCheckMessage(clazz, msgLocationAlone, "MyAnnotation2"),
            "23: " + getCheckMessage(clazz, msgLocationAlone, "MyAnnotationWithParam"),
            "3: " + getCheckMessage(clazz, msgLocation),
            "3: " + getCheckMessage(clazz, msgLocation),
            "3: " + getCheckMessage(clazz, msgLocation),
            "3: " + getCheckMessage(clazz, msgLocation),
            "3: " + getCheckMessage(clazz, msgLocation),
            "3: " + getCheckMessage(clazz, msgLocation),
            "3: " + getCheckMessage(clazz, msgLocation),
            "3: " + getCheckMessage(clazz, msgLocation),
        };

        String filePath = builder.getFilePath("AnnotationLocationInput");

        Integer[] warnList = builder.getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }
}


