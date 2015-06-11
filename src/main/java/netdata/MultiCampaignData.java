package netdata;

import java.io.Serializable;

public class MultiCampaignData implements Serializable
{
	private static final long serialVersionUID = -1188344209863971049L;
	
	public MultiCampaignData(boolean isAvailable, long startTime, long endTime, int expMuti, int gpMuti, int addExp, int addGp)
	{
		this.isAvailable = isAvailable;
		this.startTime = startTime;
		this.endTime = endTime;
		this.expMuti = expMuti;
		this.gpMuti = gpMuti;
		this.addExp = addExp;
		this.addGp = addGp;
	}
	
	public boolean isAvailable = false;
	public long startTime = 0;
	public long endTime = 0;
	public int expMuti = 0;
	public int gpMuti = 0;
	public int addExp = 0;
	public int addGp = 0;
}
