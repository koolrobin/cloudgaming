import java.io.*;    
import java.util.*;    
class Caching{    
	
	public void cache() throws IOException{
		
		//creating the FileInputStream objects for all the files    
		FileInputStream fin=new FileInputStream("Input/1.csv");    
		FileInputStream fin2=new FileInputStream("Input/2.csv");    
		FileInputStream fin3=new FileInputStream("Input/3.csv");    
		FileInputStream fin4=new FileInputStream("Input/4.csv");  
		
		FileOutputStream fout=new FileOutputStream("Output/abcd.csv");      
		//creating Vector object to all the stream    
		
		
		Vector v=new Vector();    
		v.add(fin);    
		v.add(fin2);    
		v.add(fin3);    
		v.add(fin4);        
		
		//creating enumeration object by calling the elements method    
		Enumeration e=v.elements();      
		
		//passing the enumeration object in the constructor    
		SequenceInputStream bin=new SequenceInputStream(e);    
		
			
		
		int i=0;      
		while((i=bin.read())!=-1){    
			fout.write(i); 
			fout.write('\n');
			
	//	System.out.print((char)i);    
		}    
		bin.close();    
		fin.close();    
		fin2.close(); 
		fout.close();
			
	
	}
public static void main(String args[])throws IOException{ 
	long start = System.nanoTime();
	
	Caching c= new Caching();
	
	for (int j=0;j<=1000;j++)
	{
		
	c.cache();
	
	}
	
	long end = System.nanoTime();
    System.out.println("The Total Time for writing all files is : "+(end - start) / 1000000+ "ms");
	}
		
		
	
	

   
}    

  