package jdme.common;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptSHA {
	/*
	암호화 할 때 복호화가 불가능한 단방향 방식 암호화
	SHA-2 Secure Hash Algorithm 2
	해시 함수가 출력하는 아축하는 문장 다이제스트 Digest 라고 한다.
	SHA-2가 생성하는 다이제스트는 224,256,384,512bit 등 다양
	256bit : SHA-2를 SHA-256이라고 한다
	*/
	public static String encryptSHA256(String s) {
		
		String ss= "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			
			md.update(s.getBytes());
			byte byteData[] = md.digest();
			
			
			StringBuffer sb = new StringBuffer();
			
			for(int i=0; i<byteData.length;i++) {
				
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));				
				int tmp = byteData[i]&0xff;
				
				int tmp_1 = 0x100;
				
				int tmp_sum = tmp + tmp_1;
				
				String tmp_s = Integer.toString(tmp_sum,16);
			
				String tmp_s_1 = tmp_s.substring(1);
			
						
			}
			ss=sb.toString();
		}catch(NoSuchAlgorithmException e) {
		
		}
		return ss;
	}
	public static void main(String[] args) {
	
		String s = EncryptSHA.encryptSHA256("hg74111#");
		
	}
}
