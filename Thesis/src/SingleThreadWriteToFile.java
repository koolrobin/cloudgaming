import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class SingleThreadWriteToFile {
 
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        for (int j=0;j<=50000;j++)
		{
			
        
        File dir = new File("Input\\");
        File destination = new File("Output\\Destination.csv");
        File[] files = dir.listFiles();
        String content;
        for (File file : files) {
        content = readFromFile(file.getAbsolutePath());
        writeToFile(destination,content);
        }}
        long stopTime = System.nanoTime();
		
        System.out.println("The Total Time for writing all files is : "+(stopTime - startTime) / 1000000+ "ms");    
    }
    
    private static void writeToFile(File file,String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
            writer.write(content);
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