package com.kafka.json.generator;

import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	public static FileEntity loadProperty(FileEntity entity) {
		Properties prop;
		try {
			prop = ReadProducerProperties.readPropertiesFile("generator.properties");
			if(entity==null)
			{
				entity=new FileEntity();
			}
			if(entity==null||entity.getSchemaPath()==null)
			{
			entity.setSchemaPath(prop.getProperty("schemaPath"));
			}
			if(entity==null||entity.getDatafilePath()==null)
			{
			entity.setDatafilePath(prop.getProperty("dataFilePath"));
			}
			if(entity==null||entity.getLineSpilter()==null)
			{
			entity.setLineSpilter(prop.getProperty("lineSpilter"));
			}
			if(entity==null||entity.getColoumnSpilter()==null)
			{
			entity.setColoumnSpilter(prop.getProperty("coloumnSpilter"));
			}
			if(entity==null||entity.getDataColumnDetails()==null)
			{
			entity.setDataColumnDetails(prop.getProperty("dataColumnDetails"));
			}
			if(entity==null||entity.getOutputDir()==null)
			{
			entity.setOutputDir(prop.getProperty("outputDir"));
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return entity;
	}
}
