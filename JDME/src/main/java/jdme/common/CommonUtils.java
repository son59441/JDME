package jdme.common;

public abstract class CommonUtils {
	
	
	// 게시판 목록 페이징 
	public static final int BOARD_PAGE_SIZE = 5; // 로우의 수를 보여주는 수
	public static final int BOARD_GROUP_SIZE = 5; // 밑에 페이지 수를 보여주기 위함
	public static final int BOARD_CUR_PAGE = 1;   // 1페이지 부터 시작
	public static final int BOARD_TOTAL_COUNT = 0;
	

	// 커뮤니티 게시판
	public static final String BOARD_COM_IMG_UPLOAD_PATH = "C:\\00.KOSMO108\\02.Final\\JDME_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\JDME\\upload\\board";	//
	public static final int BOARD_COM_IMG_FILE_SIZE = 2*1024*1024; // 2MB
	public static final String BOARD_COM_EN_CODE = "UTF-8";

	
	// 공지사항 게시판
	public static final String BOARD_NOTICE_IMG_UPLOAD_PATH = "C:\\00.KOSMO108\\02.Final\\JDME_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\JDME\\upload\\notice";	//
	public static final int BOARD_NOTICE_IMG_FILE_SIZE = 2*1024*1024; // 2MB
	public static final String BOARD_NOTICE_EN_CODE = "UTF-8";
	
	
	// 질문 게시판
	public static final String BOARD_QNA_IMG_UPLOAD_PATH = "C:\\00.KOSMO108\\02.Final\\JDME_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\JDME\\upload\\qna";	//
	public static final int BOARD_QNA_IMG_FILE_SIZE = 2*1024*1024; // 2MB
	public static final String BOARD_QNA_EN_CODE = "UTF-8";
	
	// 회원가입 게시판
	public static final String MEMBER_IMG_UPLOAD_PATH = "C:\\00.KOSMO108\\02.Final\\JDME_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\JDME\\upload\\mem";	//
	public static final int TEST_IMG_FILE_SIZE = 2*1024*1024; // 2MB
	public static final String TEST_IMG_ENCODE = "UTF-8";
	
	
	
	
	
	
}
