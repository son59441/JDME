package jdme.board.notice.vo;

public class JDMEBoardNoticeVO {

	private String jnnum;
	private String admin;
	private String jnsubject;
	private String jncontent;
	private String jnfile;
	private String jndyn;
	private String jnidate;
	private String jnudate;
	
	// 페이징에 필요한 것
	// 페이징 이동 필드
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;

	
	public JDMEBoardNoticeVO() {
		
	}

	
	
	public JDMEBoardNoticeVO(String jnnum, String admin, String jnsubject, 
							 String jncontent, String jnfile,
							 String jndyn, String jnidate, String jnudate) {
		
		this.jnnum = jnnum;
		this.admin = admin;
		this.jnsubject = jnsubject;
		this.jncontent = jncontent;
		this.jnfile = jnfile;
		this.jndyn = jndyn;
		this.jnidate = jnidate;
		this.jnudate = jnudate;
	}

	
	public JDMEBoardNoticeVO(String pageSize, String groupSize, String curPage, String totalCount) {
		
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}

	
	
	// setter/getter
	public String getJnnum() {
		return jnnum;
	}



	public String getAdmin() {
		return admin;
	}



	public String getJnsubject() {
		return jnsubject;
	}



	public String getJncontent() {
		return jncontent;
	}



	public String getJnfile() {
		return jnfile;
	}



	public String getJndyn() {
		return jndyn;
	}



	public String getJnidate() {
		return jnidate;
	}



	public String getJnudate() {
		return jnudate;
	}



	public void setJnnum(String jnnum) {
		this.jnnum = jnnum;
	}



	public void setAdmin(String admin) {
		this.admin = admin;
	}



	public void setJnsubject(String jnsubject) {
		this.jnsubject = jnsubject;
	}



	public void setJncontent(String jncontent) {
		this.jncontent = jncontent;
	}



	public void setJnfile(String jnfile) {
		this.jnfile = jnfile;
	}



	public void setJndyn(String jndyn) {
		this.jndyn = jndyn;
	}



	public void setJnidate(String jnidate) {
		this.jnidate = jnidate;
	}



	public void setJnudate(String jnudate) {
		this.jnudate = jnudate;
	}

		
	public String getPageSize() {
		return pageSize;
	}



	public String getGroupSize() {
		return groupSize;
	}



	public String getCurPage() {
		return curPage;
	}



	public String getTotalCount() {
		return totalCount;
	}



	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}



	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}



	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}



	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}



		
}
