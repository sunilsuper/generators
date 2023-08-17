package com.kafka.json.generator;

import java.io.FileWriter;
import java.util.Date;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonFileWriter {
	private static final Logger log = LoggerFactory.getLogger(JsonFileWriter.class);
   public static void fileWriter (JSONObject jsonObject,String outputDir) {
	   String fileName = null;
      try {
    	
    	  Date date = new Date();
          long msec = date.getTime();
    	   fileName=msec+".json";
         FileWriter file = new FileWriter(outputDir+fileName);
         file.write(jsonObject.toString());
         file.close();
         System.out.println("JSON file created: "+fileName);
      } catch (Exception e) {
         // TODO Auto-generated catch block
        log.info("Error while Json file generation"+e.getMessage());
      }
    
   }
}