package netdata;

import java.io.Serializable;

public class BattleReport implements Serializable {
	public int roomId = 0;
	public RoomData roomData;

	public int winTeam = 0;
	public int team1Score = 0;
	public int team2Score = 0;

	public int totalNum = 0; // 总参加人数 超过3分钟算

	public long aceCharacterId;
	public String aceName;
	public long mvpCharacterId;
	public String mvpName;
	public long firstKillCharacterId;
	public String firstKillName;
	public long lastKillCharacterId;
	public String lastKillName;

	public long maxHidePackCharacterId;
	public long maxOpenPackCharacterId;

	public UserReport[] userReportList;

	public long ace2CharacterId;// ace第二名
	public long ace3CharacterId;// ace第三名
}
