package netdata;

import java.io.Serializable;

public class BattleReport implements Serializable {
	public int roomId = 0;
	public RoomData roomData;

	public int winTeam = 0;
	public int team1Score = 0;
	public int team2Score = 0;
	
	public int totalNum = 0; // 总参加人数 超过3分钟算
	
	public int aceCharacterId;
	public String aceName;
	public int mvpCharacterId;
	public String mvpName;
	public int firstKillCharacterId;
	public String firstKillName;
	public int lastKillCharacterId;
	public String lastKillName;
	
	public int maxHidePackCharacterId;
	public int maxOpenPackCharacterId;
	

	public UserReport[] userReportList;
	
	public int ace2CharacterId;//ace第二名
	public int ace3CharacterId;//ace第三名
}
