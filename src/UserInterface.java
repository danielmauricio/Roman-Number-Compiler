import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserInterface {
	static ArrayList<String> values;
	static ArrayList<String> result = new ArrayList<String>();
	static File inputFile;
	static File outputFile;
	static FileReader fr = null;
	static BufferedReader br = null;
	private static  String[] units = {"one", "two", "three", "four",
		"five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
		"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
		"eighteen", "nineteen" };
	
	private static String numbers = "one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty thirty forty fifty sixty seventy eighty ninety hundred thousand";



	public static void processFile(String path) {
		try {
			values = new ArrayList<String>();
			inputFile = new File(path);
			fr = new FileReader(inputFile);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null)
				values.add(line);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	public static void createResultFile(String path,ArrayList<String> result) throws IOException{
		outputFile = new File(path);
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
		for(int i=0;i<result.size();i++){
			bw.write(result.get(i)+"\r\n");
		}
		bw.close();
	}
	
	public static void processLines(ArrayList<String> values){
		int decimal;
		for(int i=0; i<values.size();i++){
			char letter = values.get(i).charAt(0);
			if(letter=='I' || letter=='V' ||letter=='X'||letter=='L'||letter=='C'|| letter=='M'){
				if(validateRoman(values.get(i))){
					decimal = RomanNumberToDecimalNumber.romanToDecimal(values.get(i));
					result.add(DecimalNumberToWords.convert(decimal));
				}
				else {
					result.add("ERROR,OCURRE EN: "+values.get(i));
				}
			}
			else if(validateWord(values.get(i))){
				if(validateDecimal(values.get(i))){
					decimal =  WordToDecimalNumber.ConvertTextToNumber(values.get(i));
					result.add(DecimalNumberToRomanNumber.processNumber(decimal+""));
				}
				else{
					result.add("ERROR,OCURRE EN: "+values.get(i));
					
				}
			}
			else{
				result.add("ERROR,OCURRE EN: "+values.get(i));
			}
		}
		
	}
	
	public static  boolean validateWord(String value){
			for(int i = 0; i<units.length;i++){
				if(value.contains(units[i]))return true;
			}
			return false;
	}
	public static boolean validateRoman(String value){
		
		if(value.length()>15) return false; //validate max length allowed 
		for(int i=1;i<value.length();i++){ //validate that all digits are valid.
			char current = value.charAt(i);
			if(current!='I' && current !='V' && current !='X'&& current !='L'&&current!='C'&& current!='M'){
				return false;
			}
		}
		
		// validate each digit does not appear 3 times in a row.
		for(int i=0,j=1,k=2,l=3;l<value.length();i++,j++,k++,l++){
			if(value.charAt(i) == value.charAt(j) && value.charAt(j) == value.charAt(k) && value.charAt(k) == value.charAt(l))
				return false;
		}		
		
		return true;
	}
	
	public static boolean validateDecimal(String value){
		String[] words = value.split(" ");
		boolean flag = true;
		for(int i= 0;i<words.length;i++){
			if(!numbers.contains(words[i])){
				flag = false;
				System.out.println(flag);
			}
			
		}
		return flag;
	}

	public static void main(String[] args) throws IOException {
		
		String input ="C:/Users/Daniel/Desktop/Prueba.txt";
		String output ="C:/Users/Daniel/Desktop/Prueba-Resultado.txt";
		processFile(input);
		processLines(values);
		createResultFile(output, result);
		//System.out.println(values);
	}

}
