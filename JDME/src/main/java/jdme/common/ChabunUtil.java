package jdme.common;

public abstract class ChabunUtil {

	public static final String BIZ_GUBUN_B = "B";
	public static final String BIZ_GUBUN_R = "R";
	
			
	public static String numPad(String t, String c){

		for (int i = c.length(); i < 4; i++) {
			c = "0" + c;
		}
		String ymd = DateFormatUtil.ymdFormats(t);
		return ymd.concat(c);
	}
	
	
	
	public static String BoardComChabun(String type, String sjs) {
		
		return BIZ_GUBUN_B.concat(ChabunUtil.numPad(type, sjs));									
	}
	
	public static String BoardReplyChabun(String type, String sjs) {
		
		return BIZ_GUBUN_R.concat(ChabunUtil.numPad(type, sjs));									
	}
	
	
	
	
	
	public static void main(String[] args) {
				
		String c = "1";
		System.out.println(">>> : " + ChabunUtil.BoardComChabun("N", c));
	}
}
