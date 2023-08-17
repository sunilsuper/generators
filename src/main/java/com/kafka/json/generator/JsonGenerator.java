package com.kafka.json.generator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonGenerator {
	private static final Logger log = LoggerFactory.getLogger(JsonGenerator.class);

	public static void run(FileEntity entity) throws IOException {
		entity=LoadProperties.loadProperty(entity);
		String filePath = entity.getDatafilePath() ;
		String schemaPath = entity.getSchemaPath() ;
		Path path = Paths. get(schemaPath);
		String lineSpilter = entity.getLineSpilter();
		String coloumnSpilter = entity.getColoumnSpilter();
		String dataColumnDetails = entity.getDataColumnDetails();
		String outputDir = entity.getOutputDir();
		
		try {
			
		
			String s = Files.readString(path);
			fileDataReader(s, filePath,lineSpilter,coloumnSpilter,dataColumnDetails,outputDir);
			//System.out.println("Json data details:" + jsonObject2.toString(4));

		} catch (Exception e) {
			log.info("Issue while processing files:" + e.getMessage());
		}
	}

	private static void generateJsonFromSchema(String jsonSchema,HashMap<String, String> datamap,String outputDir) throws IOException {
		JSONObject schemaObject = new JSONObject(jsonSchema);
		JSONObject properties = schemaObject.getJSONObject("properties");
		JSONObject jsonObject = new JSONObject();
		String type = null;
		String datatype = null;				
	   
	         
		for (String key : properties.keySet()) {
			JSONObject property = properties.getJSONObject(key);
			try {
				type = property.getString("type");
			} catch (JSONException e) {
				JSONArray types = property.getJSONArray("type");
				datatype = types.getString(0);
				type = datatype;
			}

			switch (type) {
			case "string":
				jsonObject.put(key, datamap.get(key));
				break;
			case "integer":
				if(key.equalsIgnoreCase("zipCode"))
				jsonObject.put(key, datamap.get(key));
				break;
			case "array":

				// JSONObject jo = new JSONObject();
				JSONArray ja = new JSONArray();
				ja.put(datamap.get(key));

				jsonObject.put(key, ja);
				break;
			case "number":
				jsonObject.put(key, datamap.get(key));
				break;
			// Add more cases for different types as needed
			}
		}
log.info("Json String to write in file:"+jsonObject);
JsonFileWriter.fileWriter(jsonObject, outputDir);
	}
private static void fileDataReader(String JsonSchema ,String filePath,String lineSpilter,String coloumnSpilter,String datacolumndetails,String outputDir) throws IOException
{
	 try {
	       
	      
	        final File file = new File(filePath);
	       
	        HashMap<String, String> datamap=new HashMap<String, String>();
	        String[] columnDetailsArr = datacolumndetails.split(",");
	       
	        log.info("Column Details:"+columnDetailsArr);
	        
	        try (final Scanner scan = new Scanner(file)) {
	            scan.useDelimiter(lineSpilter);
	            while(scan.hasNext()) {
	            	String currentLine=scan.next();
	            
	                System.out.println("lines:"+currentLine);
	                String[] strArrcolumn = currentLine.split(coloumnSpilter);
		            int i=0;  
	                for(String str:strArrcolumn){
		                    System.out.println(str);
		                    datamap.put(columnDetailsArr[i], str);
		                    i++;
		                      }
	                log.info("Data Map Details:"+datamap);
	                generateJsonFromSchema(JsonSchema,datamap,outputDir);
	            }
	           }
	        }finally
	    {
	        	 System.out.println("finish");
	    }
	    
	        
	              
}
}
