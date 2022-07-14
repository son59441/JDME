package jdme.board.com.vo;

public class JDMEBoardComVO {

	private String jbnum;
	private String jmnum;
	private String jbsubject;
	private String jmid;
	private String jbcontent;
	private String jbpw;
	private String jbfile;
	private String jbdyn;
	private String jbidate;
	private String jbudate;
	
	
	

	// 페이징에 필요한 것
	// 페이징 이동 필드
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;

	public JDMEBoardComVO() {
		
	}
	
	
	public JDMEBoardComVO(String jbnum, String jmnum, String jbsubject,String jmid,
						  String jbcontent, String jbpw, String jbfile,
						  String jbdyn, String jbidate, String jbudate) {
		
		
		this.jbnum = jbnum;
		this.jmnum = jmnum;
		this.jbsubject = jbsubject;
		this.jmid = jmid;
		this.jbcontent = jbcontent;
		this.jbpw = jbpw;
		this.jbfile = jbfile;
		this.jbdyn = jbdyn;
		this.jbidate = jbidate;
		this.jbudate = jbudate;
	}

	
	public JDMEBoardComVO(String pageSize, String groupSize, String curPage, String totalCount) {
		
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}

	

	// setter/getter
	
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


	public String getJmid() {
		return jmid;
	}


	public void setJmid(String jmid) {
		this.jmid = jmid;
	}
	
	
	public String getJbnum() {
		return jbnum;
	}


	public String getJmnum() {
		return jmnum;
	}


	public String getJbsubject() {
		return jbsubject;
	}


	public String getJbcontent() {
		return jbcontent;
	}


	public String getJbpw() {
		return jbpw;
	}


	public String getJbfile() {
		return jbfile;
	}


	public String getJbdyn() {
		return jbdyn;
	}


	public String getJbidate() {
		return jbidate;
	}


	public String getJbudate() {
		return jbudate;
	}


	public void setJbnum(String jbnum) {
		this.jbnum = jbnum;
	}


	public void setJmnum(String jmnum) {
		this.jmnum = jmnum;
	}


	public void setJbsubject(String jbsubject) {
		this.jbsubject = jbsubject;
	}


	public void setJbcontent(String jbcontent) {
		this.jbcontent = jbcontent;
	}


	public void setJbpw(String jbpw) {
		this.jbpw = jbpw;
	}


	public void setJbfile(String jbfile) {
		this.jbfile = jbfile;
	}


	public void setJbdyn(String jbdyn) {
		this.jbdyn = jbdyn;
	}


	public void setJbidate(String jbidate) {
		this.jbidate = jbidate;
	}


	public void setJbudate(String jbudate) {
		this.jbudate = jbudate;
	}
	
	
}
