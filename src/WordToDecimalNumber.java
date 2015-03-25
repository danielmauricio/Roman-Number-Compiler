import java.util.HashMap;
import java.util.Map;


public class WordToDecimalNumber {
	
	
	
	public static int ConvertTextToNumber(String input)
	{
	    String[] units = new String[] {
	        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
	        "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
	        "sixteen", "seventeen", "eighteen", "nineteen",
	    };

	    String[] tens = new String[] {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	    String[] scales = new String[] { "hundred", "thousand"};

	    Map<String, Number> dictionary = new HashMap<String, Number>();
	    dictionary.put("and", new Number(1, 0));
	    for (int i = 0; i < units.length; i++)
	    {
	        dictionary.put(units[i], new Number(1, i));
	    }

	    for (int i = 1; i < tens.length; i++)
	    {
	        dictionary.put(tens[i], new Number(1, i * 10));                
	    }

	    for (int i = 0; i < scales.length; i++)
	    {
	        if(i == 0)
	            dictionary.put(scales[i], new Number(100, 0));
	        else
	            dictionary.put(scales[i], new Number((int)Math.pow(10, (i*3)), 0));
	    }

	    int current = 0;
	    int result = 0;

	    String[] words = input.split(" ");

	    for (int i = 0; i < words.length; i++) {
	        Number number = dictionary.get(words[i]);
	        current = current * number.escale + number.increment;
	        if (number.escale > 100)
	        {
	            result += current;
	            current = 0;
	        }
	    }
	    return result + current;
	    };
	    
	    
	    public static void main(String[] args) {
			System.out.println(ConvertTextToNumber("five thousand nine hundred ninety nine"));
		}
}
