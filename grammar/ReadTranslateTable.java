import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class ReadTranslateTable {
    	
	static HashMap<String,String> list = new HashMap<String,String>();

	ReadTranslateTable() {
		String filename = "TranslateTable.txt";
		String[] lines;
		String line;

		try {
	    	Scanner scan = new Scanner(new File(filename));

	    	while (scan.hasNextLine()){
	    		line = scan.nextLine();
	    		lines = line.split("\t");
				list.put(lines[0], lines[1]);
			}

			Iterator it = list.entrySet().iterator();
			while (it.hasNext()) {
	    		Map.Entry pair = (Map.Entry)it.next();
	    		System.out.println(pair.getKey() + " = " + pair.getValue());
				// #Question from: MR; why do we have it.remove()? it seems to destroy the contents of list
	    		// it.remove(); // avoids a ConcurrentModificationException
			}
			
		} catch (FileNotFoundException ex) {
			
		}

	}
}