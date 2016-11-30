package jungkosta.commons.util;


public class Decryption {
	//DB비번 => 이진수변환 => 1의보수 => >>1 연산 => 십진수 => 문자열
	
	//DB에 저장된 비번 이진수배열로 변환
	public String[] covertHtoOne(String dbpass){
		
		String[] brypass = dbpass.split("=");
		String dbpassOne = "";

		for(int i=1; i<brypass.length; i++){
			dbpassOne = brypass[i];
			
			brypass[i] = convertBtoD(dbpassOne);
		}	

		return brypass;
	}
	
	//이진수 변환
	private String convertBtoD(String dbpassOne){
		long decimal[] = new long[2];
		char[] chrpass = dbpassOne.toCharArray();
		
		String binary = "";
		String result_Value ="";
		
		for (int i=chrpass.length-1; i>=0; i--) {			
			if(chrpass[i] >= 'a' && chrpass[i] <= 'z'){
				
				decimal[i] = chrpass[i] - 87;
				
				binary = Long.toBinaryString(decimal[i]);
				
				result_Value = fixNumber(binary,result_Value);	//이진수 자리수 맞추기위함
				
			}
			
			if (chrpass[i] >= '0' && chrpass[i] <= '9') {
				decimal[i] = chrpass[i] - 48;
				
				binary = Long.toBinaryString(decimal[i]);
				
				if(i != 0){
					result_Value = fixNumber(binary,result_Value);
				}
				else{
					result_Value = binary+result_Value;
				}
			}
		}
		//System.out.println(result_Value);
		
		return result_Value;
	}
	
	//이진수 -> 1의 보수 -> >>1 연산 -> 십진수변환
	public Long refactoring(String dbpass){
		char[] chrdbpass = dbpass.toCharArray();
		char[] temp = new char[chrdbpass.length-1];
		
		long decimal = 0;
				
		for(int i=1; i<chrdbpass.length; i++){
			chrdbpass[i] = (chrdbpass[i] == '1') ? '0' : '1';
		
		}

		for(int i=0; i<temp.length; i++){
			temp[i] = chrdbpass[i];
		}
		
		for(int i=temp.length-1; i>=0; i--){
			
			if(temp[i] == '1'){
				decimal += Math.pow(2, (temp.length-1)-i);
			}
			
		}
		
		return decimal;
		
	}
	
	private String fixNumber(String binary,String result_Value){ 
		
		if(binary.length() == 3){
			result_Value = "0" + binary + result_Value;
		}
		else if(binary.length() == 2){
			result_Value = "00" + binary + result_Value;
		}
		else if(binary.length() == 1){
			result_Value = "000" + binary + result_Value;
		}
		else if(binary.length() == 0){
			result_Value = "0000" + result_Value;
		}else{
			result_Value = binary + result_Value;
		}
		
		return result_Value;
	}
	
	public String decriptOk(long decimal){
		char [] dtoc = new char[1];		
		dtoc[0] = (char)decimal;
		
		return new String(dtoc);
	}
	
}
