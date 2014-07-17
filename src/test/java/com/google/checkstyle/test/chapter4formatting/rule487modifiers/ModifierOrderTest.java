package com.google.checkstyle.test.chapter4formatting.rule487modifiers;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.puppycrawl.tools.checkstyle.checks.modifier.ModifierOrderCheck;
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class ModifierOrderTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
    	String msg = getCheckMessage(ModifierOrderCheck.class, "mod.order");

        final String[] expected = {
                "14:10: " + getCheckMessage(ModifierOrderCheck.class, "mod.order", "final"),
                "18:12: " + getCheckMessage(ModifierOrderCheck.class, "mod.order", "private"),
                "24:14: " + getCheckMessage(ModifierOrderCheck.class, "mod.order", "private"),
                "34:13: " + getCheckMessage(ModifierOrderCheck.class, "annotation.order", "@MyAnnotation2"),
                "39:13: " + getCheckMessage(ModifierOrderCheck.class, "annotation.order", "@MyAnnotation2"),
                "49:35: " + getCheckMessage(ModifierOrderCheck.class, "annotation.order", "@MyAnnotation4"),
                };
        
        Configuration checkConfig = builder.getCheckConfig("ModifierOrder");
        String filePath = builder.getFilePath("ModifierOrderInput");
        
        verify(checkConfig, filePath, expected);
    }
}


