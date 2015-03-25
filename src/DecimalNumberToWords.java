public class DecimalNumberToWords {

	private static String[] units = { "", "one", "two", "three", "four",
			"five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
			"eighteen", "nineteen" };

	private static String[] tens = { "", "", "twenty", "thirty", "forty",
			"fifty", "sixty", "seventy", "eighty", "ninety" };

	
	
	public static String convert(int n) {
		
		if (n < 0) {
			return "minus " + convert(-n);
		}

		if (n < 20) {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " hundred" + ((n % 100 != 0) ? " " : "")
					+ convert(n % 100);
		}
			return convert(n / 1000) + " thousand"
					+ ((n % 1000 != 0) ? " " : "") + convert(n % 1000);
	}
}
