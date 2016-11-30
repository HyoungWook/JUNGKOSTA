package jungkosta.commons.util;


public class Encryption {
	//문자열 => 이진수 => <<1 비트연산 => 1의보수(0=1, 1=0) => #+16진수변환 => DB저장 
	
	
	//암호화 OK
	public String passEcnript(String pass){
		String shiftResult = "";
		
		String[] bryPass = convertStoB(pass);		//이진수 변환
		char[] bryChr = new char[bryPass.length];
		
		for(int i=0; i<bryPass.length; i++){
			bryChr = bryPass[i].toCharArray();
			
			shiftResult += "#"+refactoring(bryChr);	//password 암호화
		}
		
		return shiftResult;
	}
	
	//password 문자열 => 이진수변환
	private String[] convertStoB(String pass){
		char[] chrPass = pass.toCharArray(); 
		String[] bryPass = new String[chrPass.length];
		char[] bryChr = new char[bryPass.length];
		
		for(int i=0; i<chrPass.length; i++){
			bryPass[i] = Long.toBinaryString(chrPass[i]);	//이진수 변환
		}	
		return bryPass;
	}
	
	
	//비트연산 후 1의보수처리 -> 16진수 변환
	private String refactoring(char[] bryChr){
		//기존 이진수 char배열에서 <<1 연산하면 한 칸씩 밀려서 맨 끝자리는 비게되어 끝자리에도 값을 넣어줘야함 
		char[] temp = new char[bryChr.length+1];
		
		//<<1 연산 후 생성되는 마지막인덱스 처리 (끝이 1이면 끝에 1 아니면 0추가)
		temp[bryChr.length] = (bryChr[bryChr.length-1] == '1') ? '1' : '0';
		
		//마지막인덱스를 제외한 나머지 인덱스값들 비트연산.
		for(int i=0; i<bryChr.length; i++){
			temp[i] = bryChr[i];
		}
		
		//1의 보수 처리
		for(int i=0; i<temp.length; i++){
			temp[i] = (temp[i] == '1') ? '0' : '1';
		}
		
		return Long.toHexString(convertBtoD(temp));
	}
	
	
	//이진수 => 십진수로 변환
	private Long convertBtoD(char[] binary){
		long decimal = 0;
		
		//배열은 왼쪽부터 시작하는 반면 이진수는 오른쪽부터 계산하기 때문에 반대로함.
		for (int i = binary.length - 1; i >= 0; i--) {
			
			//값이 1이면  2의 해당비트 제곱연산
			if (binary[i] == '1') {
				decimal += Math.pow(2, (binary.length-1)-i);
			}
		}
		return decimal;		
	}
}
