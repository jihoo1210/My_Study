package seboard.util;

import java.security.SecureRandom;

public class SecRandom {
	private static final String CODE_CHARS = "ASDZXCQWE";
	private static final SecureRandom SECURE_RANDOM = new SecureRandom(); // 운영체제의 난수 생성원을 사용하여 암호학적으로 안전한 난수를 생성
	
	public static String randomCode(int len) {
		StringBuilder sb = new StringBuilder(len); 
		//String 객체가 불변(immutable)인 것과 달리, StringBuilder는 **가변(mutable)**이므로 문자열을 효율적으로 추가하고 수정하는 데 사용
		for(int i = 0; i < len; i++) {
			 int idx = SECURE_RANDOM.nextInt(CODE_CHARS.length()); // 0부터 CODE_CHARS.length() 미만의 범위에서 무작위 정수를 반환
			sb.append(CODE_CHARS.charAt(idx)); // 매개변수로 받은 문자를 현재 문자열의 끝에 추가
		}
		return sb.toString();
	}
}
