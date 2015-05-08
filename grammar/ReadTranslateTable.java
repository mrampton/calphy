import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class ReadTranslateTable {
    	
	static HashMap<String,String> transList = new HashMap<String,String>();

	ReadTranslateTable() {
		String filename = "TranslateTable.txt";
		String[] lines;
		String line;

		try {
	    		Scanner scan = new Scanner(new File(filename));

	    		while (scan.hasNextLine()) {
	    			line = scan.nextLine();
	    			lines = line.split("\t");
				transList.put(lines[0], lines[1]);
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
	}
}
