package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {
	
	public static void main(String[] args) {
		try {
	    	  File inputFile = new File("Other/File/PridePrejuce.txt");
	    	  long start = System.currentTimeMillis();
	    	  Scanner sc = new Scanner(inputFile);
	    	  String s = "";
	    	  while(sc.hasNextLine()) {
	    		  s += sc.nextLine() + "\n";
	    	  }
	    	  System.out.printf("Processing time: %d", System.currentTimeMillis() - start);
	    	  sc.close();
	    	} catch (FileNotFoundException e) {
	    		e.printStackTrace();
	    	}
	}
	
}