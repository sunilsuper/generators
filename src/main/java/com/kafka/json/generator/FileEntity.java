package com.kafka.json.generator;



public class FileEntity {
private String schemaPath;
private String dataColumnDetails;
private String lineSpilter;
private String coloumnSpilter;
private String outputDir;
private String datafilePath;
public String getDatafilePath() {
	return datafilePath;
}
public void setDatafilePath(String datafilePath) {
	this.datafilePath = datafilePath;
}
public String getSchemaPath() {
	return schemaPath;
}
public void setSchemaPath(String schemaPath) {
	this.schemaPath = schemaPath;
}
public String getDataColumnDetails() {
	return dataColumnDetails;
}
public void setDataColumnDetails(String dataColumnDetails) {
	this.dataColumnDetails = dataColumnDetails;
}
public String getLineSpilter() {
	return lineSpilter;
}
public void setLineSpilter(String lineSpilter) {
	this.lineSpilter = lineSpilter;
}
public String getColoumnSpilter() {
	return coloumnSpilter;
}
public void setColoumnSpilter(String coloumnSpilter) {
	this.coloumnSpilter = coloumnSpilter;
}
public String getOutputDir() {
	return outputDir;
}
public void setOutputDir(String outputDir) {
	this.outputDir = outputDir;
}


}
