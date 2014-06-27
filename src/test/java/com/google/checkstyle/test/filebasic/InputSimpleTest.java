package com.google.checkstyle.test.filebasic;


import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.puppycrawl.tools.checkstyle.Checker;
import com.puppycrawl.tools.checkstyle.ConfigurationLoader;
import com.puppycrawl.tools.checkstyle.DefaultLogger;
import com.puppycrawl.tools.checkstyle.PropertiesExpander;
import com.puppycrawl.tools.checkstyle.api.AuditListener;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;

public class InputSimpleTest extends BaseCheckTestSupport{
	
	 /** the underlying Properties object. */
	Properties mProperties;
	
    public Configuration getConfigurationFromXML(String aConfigName, Properties aProps) throws CheckstyleException {
    	try {
            return ConfigurationLoader.loadConfiguration(
            		aConfigName, new PropertiesExpander(aProps));
        }
        catch (final CheckstyleException e) {
            System.out.println("Error loading configuration file");
            e.printStackTrace(System.out);
            System.exit(1);
            return null;
        }
    }

    @Test
    public void emptyTest() throws IOException, Exception {
    	
    	File ROOT = new File("src/");
        System.out.println("Root is set to \"" + ROOT.getAbsolutePath() + "\".");
        
    	Configuration conf = getConfigurationFromXML("checkstyle_google_style.xml", System.getProperties());
    	Configuration[] defaultConfigurations = conf.getChildren();
    	
    
    	List files = new ArrayList();
        listFiles(files, ROOT, "java");
        System.out.println("Found " + files.size() + " Java source files.");
        
    	ByteArrayOutputStream sos = new ByteArrayOutputStream();
    	AuditListener listener = new DefaultLogger(sos, false);
    	
        Checker checker = new Checker();
        checker.setModuleClassLoader(Checker.class.getClassLoader());
        checker.configure(conf);
        checker.addListener(listener);
        
        int errors = checker.process(files);
        System.out.println("Found " + errors + " check style errors.");
        System.out.println(sos.toString());
        assertTrue(errors + " check style errors found. " + sos.toString(), errors == 0);
        
        checker.destroy();
    }
    
    private static void listFiles(List files, File folder, String extension) {
        if (folder.canRead()) {
            if (folder.isDirectory()) {
                for (File f : folder.listFiles()) {
                    listFiles(files, f, extension);
                }
            } else if (folder.toString().endsWith("." + extension)) {
                files.add(folder);
            }
        }
    }
}


