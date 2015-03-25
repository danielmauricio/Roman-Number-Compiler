
public class DecimalNumberToRomanNumber {

	static String[][] array = {{"I","V","X"},{"X","L","C"},{"C","D","M"},{"M","V","X"}};

	static String processDigit(int level,char digit){
		
		if (digit=='0'){
			return "";
		}
		
		else if(digit=='1'){
			return array[level][0];
		}
		else if(digit=='2'){
			return array[level][0]+array[level][0];
		}
		else if(digit=='3'){
			return array[level][0]+array[level][0]+array[level][0];			
		}
		else if(digit=='4'){
			return array[level][0]+array[level][1];
		}
		else if(digit=='5'){
			return array[level][1];			
		}
		else if(digit=='6'){
			return array[level][1]+array[level][0];
		}
		else if(digit=='7'){
			return array[level][1]+array[level][0]+array[level][0];
		}
		else if(digit=='8'){
			return array[level][1]+array[level][0]+ array[level][0]+array[level][0];
		}
		else{
			return array[level][0]+array[level][2];
		}
	}
	
	public static String processNumber(String valor){
		String result = "";
		for(int i=0,j=valor.length()-1;j>=0;j--,i++){
			result = processDigit(i, valor.charAt(j))+ result;
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(processNumber("5000"));
	}

}
