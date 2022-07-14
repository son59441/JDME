package jdme.common;

public abstract class ChabunUtil {

	public static final String BIZ_GUBUN_B = "B"; // 커뮤니티 게시판 채번
	public static final String BIZ_GUBUN_R = "R"; // 댓글 채번
	public static final String BIZ_GUBUN_N = "N"; // 공지사항 게시판 채번
	public static final String BIZ_GUBUN_Q = "Q"; // Q&A 게시판 채번
	public static final String BIZ_GUBUN_QR = "QR"; // Q&A 댓글 게시판 채번
	public static final String BIZ_MEMBER_PRODUCT = "M"; // 회원가입 게시판 채번
			
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
	
	public static String BoardNoticeChabun(String type, String sjs) {
		
		return BIZ_GUBUN_N.concat(ChabunUtil.numPad(type, sjs));									
	}
	
	public static String BoardQnaChabun(String type, String sjs) {
		
		return BIZ_GUBUN_Q.concat(ChabunUtil.numPad(type, sjs));									
	}
	
	public static String BoardQnaReplyChabun(String type, String sjs) {
		
		return BIZ_GUBUN_QR.concat(ChabunUtil.numPad(type, sjs));									
	}
	
	//멤버 채번번호
	public static String getMemChabun(String type,String sjs) {
			
		return BIZ_MEMBER_PRODUCT.concat(ChabunUtil.numPad(type, sjs));									
	}	
	
	
	public static void main(String[] args) {
				
		String c = "1";
		System.out.println(">>> : " + ChabunUtil.BoardComChabun("N", c));
	}
}
