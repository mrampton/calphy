import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class readTranslateTable {
    	
	static HashMap<String,String> list = new HashMap<String,String>();

	public static void main(String args[]) throws FileNotFoundException {
		String filename = "TranslateTable.txt";
		String[] lines;
		String line;
    
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
        		it.remove(); // avoids a ConcurrentModificationException
    		}
	}
}
