package entity;

//import java.sql.Timestamp;
import java.util.Date;

public class News {
	private int nid;
	private int ntid;
	private String ntitle;
	private String nauthor;
	private Date ncreateDate;
	private String nsummary;

	//Timestamp time = new Timestamp(System.currentTimeMillis());
	
	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public int getNtid() {
		return ntid;
	}

	public void setNtid(int ntid) {
		this.ntid = ntid;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNauthor() {
		return nauthor;
	}

	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}

	public Date getNcreateDate() {
		return ncreateDate;
	}

	public void setNcreateDate(Date ncreateDate) {
		this.ncreateDate = ncreateDate;
	}

	public String getNsummary() {
		return nsummary;
	}

	public void setNsummary(String nsummary) {
		this.nsummary = nsummary;
	}

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(int nid, int ntid, String ntitle, String nauthor,
			Date ncreateDate, String nsummary) {
		super();
		this.nid = nid;
		this.ntid = ntid;
		this.ntitle = ntitle;
		this.nauthor = nauthor;
		this.ncreateDate = ncreateDate;
		this.nsummary = nsummary;
	}
}
