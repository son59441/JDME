package jdme.board.qna.vo;

public class JDMEBoardQnaVO {

	private String jqnum;
	private String jmnum;
	private String jqsubject;
	private String jmid;
	private String jqcontent;
	private String jqpw;
	private String jqfile;
	private String jqdyn;
	private String jqidate;
	private String jqudate;
	
	
	// 페이징에 필요한 것
	// 페이징 이동 필드
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;

	
	
	public JDMEBoardQnaVO() {
		
	}
	
	
	
	public JDMEBoardQnaVO(String jqnum, String jmnum, String jqsubject,String jmid, 
						  String jqcontent, String jqfile, String jqdyn, String jqpw,
						  String jqidate, String jqudate) {
		
		this.jqnum = jqnum;
		this.jmnum = jmnum;
		this.jqsubject = jqsubject;
		this.jmid = jmid;
		this.jqcontent = jqcontent;
		this.jqpw = jqpw;
		this.jqfile = jqfile;
		this.jqdyn = jqdyn;
		this.jqidate = jqidate;
		this.jqudate = jqudate;
	}

	public JDMEBoardQnaVO(String pageSize, String groupSize, String curPage, String totalCount) {
		
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}



	// setter / getter
	
	public String getJqpw() {
		return jqpw;
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



	public void setJqpw(String jqpw) {
		this.jqpw = jqpw;
	}



	public String getJmid() {
		return jmid;
	}



	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	
	public String getJqnum() {
		return jqnum;
	}



	public String getJmnum() {
		return jmnum;
	}



	public String getJqsubject() {
		return jqsubject;
	}



	public String getJqcontent() {
		return jqcontent;
	}



	public String getJqfile() {
		return jqfile;
	}



	public String getJqdyn() {
		return jqdyn;
	}



	public String getJqidate() {
		return jqidate;
	}



	public String getJqudate() {
		return jqudate;
	}



	public void setJqnum(String jqnum) {
		this.jqnum = jqnum;
	}



	public void setJmnum(String jmnum) {
		this.jmnum = jmnum;
	}



	public void setJqsubject(String jqsubject) {
		this.jqsubject = jqsubject;
	}



	public void setJqcontent(String jqcontent) {
		this.jqcontent = jqcontent;
	}



	public void setJqfile(String jqfile) {
		this.jqfile = jqfile;
	}



	public void setJqdyn(String jqdyn) {
		this.jqdyn = jqdyn;
	}



	public void setJqidate(String jqidate) {
		this.jqidate = jqidate;
	}



	public void setJqudate(String jqudate) {
		this.jqudate = jqudate;
	}

	
	
	
	
}
