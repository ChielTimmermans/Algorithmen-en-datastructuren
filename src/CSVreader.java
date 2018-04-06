import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVreader {
	
	public static boolean isInteger(String s) {
		try {
			int i = Integer.parseInt(s);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static String removeFirstLast(String s) {
		s = s.substring(1);
		s = s.substring(0, s.length()-1);
		return s;
	}
	
	public static ArrayList<Integer> readCSV(String path) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		String csvFile = path;
	    String line = "";
	    String cvsSplitBy = ",";

	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){

	    	while((line = br.readLine()) != null) {

	    		String[] number = line.split(cvsSplitBy);
	    		
	    		String next = removeFirstLast(number[0]);
	    		if(isInteger(next)) {
	    			ret.add(Integer.parseInt(next));
	    		}
	                
	    	}
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    return ret;
	}
}
