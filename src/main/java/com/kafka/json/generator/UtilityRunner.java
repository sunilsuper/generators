package com.kafka.json.generator;

import java.io.IOException;

public class UtilityRunner {
public static void main(String arg[]) throws IOException
{
	FileEntity fl=new FileEntity();
	JsonGenerator.run(fl);	
}
}
