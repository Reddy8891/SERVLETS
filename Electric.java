package week7.jsf.bean;

public class Electric {
	private String meterId;
	private String crntMtrRd;
	private String prevMtrRd;
	private String zone;
	public Electric() {
		
	}
	public Electric(String meterId, String crntMtrRd, String prevMtrRd, String zone) {
		super();
		this.meterId = meterId;
		this.crntMtrRd = crntMtrRd;
		this.prevMtrRd = prevMtrRd;
		this.zone = zone;
	}
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public String getCrntMtrRd() {
		return crntMtrRd;
	}
	public void setCrntMtrRd(String crntMtrRd) {
		this.crntMtrRd = crntMtrRd;
	}
	public String getPrevMtrRd() {
		return prevMtrRd;
	}
	public void setPrevMtrRd(String prevMtrRd) {
		this.prevMtrRd = prevMtrRd;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	
}
