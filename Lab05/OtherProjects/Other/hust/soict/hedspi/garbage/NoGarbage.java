package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class NoGarbage {
	public static void main(String[] args) throws IOException {
		try {
	    	  File inputFile = new File("Other/File/PridePrejuce.txt");
	    	  long start = System.currentTimeMillis();
	    	  Scanner sc = new Scanner(inputFile);
	    	  StringBuffer s = new StringBuffer();
	    	  while(sc.hasNextLine()) {
	    		  s.append(sc.nextLine() + "\n");
	    	  }

	    	  System.out.printf("Processing time: %d", System.currentTimeMillis() - start);

	    	  sc.close();
	    	} catch (FileNotFoundException e) {
	    		e.printStackTrace();
	    	}
	}
}