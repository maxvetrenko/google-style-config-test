package com.google.checkstyle.test.base;


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
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
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
    	Configuration defConfig = conf.getChildren()[1].getChildren()[5];
    	
    	List files = new ArrayList();
        listFiles(files, ROOT, "java");
        System.out.println("Found " + files.size() + " Java source files.");

//    	ByteArrayOutputStream sos = new ByteArrayOutputStream();
//    	AuditListener listener = new DefaultLogger(sos, false);
    	
//        Checker checker = createChecker(conf);
        
//        int errors = checker.process(files);
//        System.out.println("Found " + errors + " check style errors.");
//        System.out.println(sos.toString());
//        assertTrue(errors + " check style errors found. " + sos.toString(), errors == 0);
        
        final String[] expected = {
                "4:1: '{' should be on the previous line.",
                "13:5: Variable access definition in wrong order.",
                "18:5: Variable access definition in wrong order.",
                "21:5: Variable access definition in wrong order.",
                "27:5: Static variable definition in wrong order.",
                "27:5: Variable access definition in wrong order.",
                "34:9: Variable access definition in wrong order.",
                "45:9: Static variable definition in wrong order.",
                "45:9: Variable access definition in wrong order.",
                "54:5: Constructor definition in wrong order.",
                "80:5: Instance variable definition in wrong order.",

                "92:9: Variable access definition in wrong order.",
                "100:9: Static variable definition in wrong order.",
                "100:9: Variable access definition in wrong order.",
                "106:5: Variable access definition in wrong order.",
                "111:5: Variable access definition in wrong order.",
                "116:5: Variable access definition in wrong order.",
                "119:5: Variable access definition in wrong order.",
                "125:5: Static variable definition in wrong order.",
                "125:5: Variable access definition in wrong order.",
                "132:9: Variable access definition in wrong order.",
                "143:9: Static variable definition in wrong order.",
                "143:9: Variable access definition in wrong order.",
                "152:5: Constructor definition in wrong order.",
                "178:5: Instance variable definition in wrong order.",
            };
            String path = files.get(1).toString();
			verify(defConfig, path, expected);
        
    }

	private Checker createChecker(final Configuration conf, final AuditListener listener)
			throws CheckstyleException {
		final Checker checker = new Checker();
        checker.setModuleClassLoader(Checker.class.getClassLoader());
        checker.configure(conf);
        checker.addListener(listener);
		return checker;
	}
    
    private static void listFiles(final List files, final File folder, final String extension) {
        if (folder.canRead()) {
            if (folder.isDirectory()) {
                for (final File f : folder.listFiles()) {
                    listFiles(files, f, extension);
                }
            } else if (folder.toString().endsWith("." + extension)) {
                files.add(folder);
            }
        }
    }
}


