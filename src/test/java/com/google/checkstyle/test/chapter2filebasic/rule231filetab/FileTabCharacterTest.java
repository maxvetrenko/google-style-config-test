package com.google.checkstyle.test.chapter2filebasic.rule231filetab;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.whitespace.FileTabCharacterCheck;

public class FileTabCharacterTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }
    
    @Override
    protected DefaultConfiguration createCheckerConfig(
        Configuration aCheckConfig)
    {
        final DefaultConfiguration dc = new DefaultConfiguration("root");
        dc.addChild(aCheckConfig);
        return dc;
    }

    @Test
    public void emptyTest() throws IOException, Exception {

        final DefaultConfiguration checkConfig = createConfig(false);
        final String[] expected = {
            "19:25: " + getCheckMessage(FileTabCharacterCheck.class, "file.containsTab"),
        };
        verify(createChecker(checkConfig),builder.getFilePath("FileTabCharacterInput"),
            expected);
    } 
    
    /**
     * Creates a configuration that is functionally close to that in the docs.
     */
    private DefaultConfiguration createConfig(boolean verbose)
    {
        final DefaultConfiguration checkConfig =
            createCheckConfig(FileTabCharacterCheck.class);
        checkConfig.addAttribute("eachLine", Boolean.toString(verbose));
        return checkConfig;
    }
}


