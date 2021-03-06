

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MultithreadingWriteToFile {
	
	public static void main(String[] args) {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		long startTime = System.nanoTime();
		
		for (int j=0;j<=10000;j++)
		{
			
		
		File dir = new File("Input\\");
		File destination = new File("DestinationMultiThread.csv");
		File[] files = dir.listFiles();
		for (File file : files) {
			Writer w1 = new Writer(file, destination);
			Thread t = new Thread(w1);
			System.out.println(t);
			t.setPriority(Thread.MAX_PRIORITY);
			t.start();
			
		}}
		long stopTime = System.nanoTime();
		
	

System.out.println("The Total Time for writing all files is : "+(stopTime - startTime) / 1000000+ "ms");
	}

}

class Writer implements Runnable{
File source;
File destination;
	public Writer(File source,File destination) {
this.source = source;
this.destination = destination;
	}
	@Override
	public void run() {
		String content;
		content = 	readFromFile(source.getAbsolutePath());
		writeToFile(destination,content);		
	}
	
	private static void writeToFile(File file,String content) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(content);
			writer.write("file content written");
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	static String readFromFile(String filename){
		StringBuffer content = new StringBuffer();
		try {
			String text;
			BufferedReader reader = new BufferedReader(new FileReader(filename));
				while((text = reader.readLine())!=null){
					content.append(text);
					content.append("\n");
					
				}
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return content.toString();	
	}

	
}