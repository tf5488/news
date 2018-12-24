package entity;

import java.sql.Date;

public class Comment {
	private int cid;
	private int cnid;
	private String cauthor;
	private String content;
	private Date ccreateDate;
	private String ip;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCnid() {
		return cnid;
	}

	public void setCnid(int cnid) {
		this.cnid = cnid;
	}

	public String getCauthor() {
		return cauthor;
	}

	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCcreateDate() {
		return ccreateDate;
	}

	public void setCcreateDate(Date ccreateDate) {
		this.ccreateDate = ccreateDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int cid, int cnid, String cauthor, String content,
			Date ccreateDate, String ip) {
		super();
		this.cid = cid;
		this.cnid = cnid;
		this.cauthor = cauthor;
		this.content = content;
		this.ccreateDate = ccreateDate;
		this.ip = ip;
	}

}
