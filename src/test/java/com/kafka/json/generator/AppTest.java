package com.kafka.json.generator;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

   
    public void testUtility() throws IOException 
    {
    	FileEntity fl;
    	
    		 fl=new FileEntity();
    		// fl.setOutputDir("C:\\Users\\sunil.gopalghare\\eclipse-workspace_kafka\\generator\\output_json\\");
    		JsonGenerator.run(fl);
    	     assertTrue( true );
    
    }
}
