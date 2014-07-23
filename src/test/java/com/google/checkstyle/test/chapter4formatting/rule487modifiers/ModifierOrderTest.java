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
        
    	Class<ModifierOrderCheck> clazz = ModifierOrderCheck.class;
        String msgMod = "mod.order";
		String msgAnnotation = "annotation.order";

		final String[] expected = {
                "14:10: " + getCheckMessage(clazz, msgMod, "final"),
                "18:12: " + getCheckMessage(clazz, msgMod, "private"),
                "24:14: " + getCheckMessage(clazz, msgMod, "private"),
                "34:13: " + getCheckMessage(clazz, msgAnnotation, "@MyAnnotation2"),
                "39:13: " + getCheckMessage(clazz, msgAnnotation, "@MyAnnotation2"),
                "49:35: " + getCheckMessage(clazz, msgAnnotation, "@MyAnnotation4"),
                };
        
        Configuration checkConfig = builder.getCheckConfig("ModifierOrder");
        String filePath = builder.getFilePath("ModifierOrderInput");
        
        verify(checkConfig, filePath, expected);
    }
}


