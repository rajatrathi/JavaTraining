package com.train;
import static com.train.ConstructFileArray.constructArrayfromfiles;;


public class MainBatch 
{
 public static void main(String[] args)
 { 
	String[] files = constructArrayfromfiles();
	FileProcesssing fileProcess = new FileProcesssing();
	fileProcess.processFiles(files);
 }
}
