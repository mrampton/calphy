import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.io.InputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class ReadTranslateTable {
    	
	static HashMap<String,String> transList = new HashMap<String,String>();

	ReadTranslateTable() {
		String[] lines;
		String line;
		String filename = "TranslateTable.txt";
		InputStream is = getClass().getResourceAsStream(filename);
		
		// removing try:catch because using InputStream in this manner does
		// not seem to throw either FileException or IOException
		Scanner scan = new Scanner(is);

		while (scan.hasNextLine()) {
			line = scan.nextLine();
			lines = line.split("\t");
			transList.put(lines[0], lines[1]);
		}
	}
}
