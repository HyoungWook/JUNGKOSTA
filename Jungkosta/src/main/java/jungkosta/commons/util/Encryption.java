package jungkosta.commons.util;


public class Encryption {
	
	public String refactoring(char[] bryChr){
		char[] temp = new char[bryChr.length+1];
		
		temp[bryChr.length] = (bryChr[bryChr.length-1] == '1') ? '1' : '0';
		
		for(int i=0; i<bryChr.length; i++){
			temp[i] = bryChr[i];
		}
		
		for(int i=0; i<temp.length; i++){
			temp[i] = (temp[i] == '1') ? '0' : '1';
		}
		
		return Long.toHexString(convertBtoD(temp));
	}
	
	private Long convertBtoD(char[] binary){
		long decimal = 0;

		for (int i = binary.length - 1; i >= 0; i--) {

			if (binary[i] == '1') {
				decimal += Math.pow(2, (binary.length-1)-i);
			}
		}
		return decimal;
		
	}
}
