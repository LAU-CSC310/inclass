package hashtable;
import java.util.*;
import java.io.*;
import java.lang.*;

public class HashMapDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String,Double> map=new HashMap<String,Double>();
		map.put("Huey", 90.5);
		map.put("Dewey",80.0);
		map.put("Louie", 89.0);
		map.put("null",null);
		
		try {
		File file=new File("C:\\Users\\hikma\\Downloads\\words_alpha.txt");
		Scanner input=new Scanner(file);
		int count=20;
		while(input.hasNextLine()) {
			String line=input.nextLine();
			for(int i=0;i<count;i++) {
			   map.put(line+Integer.toString(i), null);
			}
		}
		input.close();
		
		}
		catch(Exception e) {
			System.out.println("Exception"+e.getMessage());
		}
		System.out.println("map size= "+map.size());
		boolean result=false;
		long start=System.nanoTime();
		for(int i=0;i<1000000;++i)
		 result=map.containsKey("parvenue0");
		long end=System.nanoTime();
		
		System.out.println((float)(end-start)/10e6+"milliseconds");
		
		System.out.println(result);
		
	}

}
