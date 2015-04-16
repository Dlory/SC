package netdata;

import java.io.Serializable;
import java.util.TreeMap;

public class BattleReport implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4219395050069540978L;
	public int roomId = 0;
	public RoomData roomData;

	public int winTeam = 0;
	public int team1Score = 0;
	public int team2Score = 0;

	public int totalNum = 0; // 总参加人数 超过3分钟算

	public long aceCharacterId;
	public long mvpCharacterId;
	public long firstKillCharacterId;
	public long lastKillCharacterId;
	public long ctMvpCharacterId;
	public long tMvpCharacterId;
	public long ctKdKingCharacterId;
	public long tKdKingCharacterId;
	
	/**
	 * 主宰
	 */
	public long bioAceCharacterId;
	/**
	 * 幸存
	 */
	public long maxLiveCharacterId;
	/**
	 * 封魔
	 */
	public long maxInfectionCharacterId;
	/**
	 * 枪王
	 */
	public long kingCharacterId;
	/**
	 * 奶妈
	 */
	public long nurseCharacterId;
	public long ctNurseCharacterId;
	public long tNurseCharacterId;
	
	public long maxHidePackCharacterId;
	public long maxOpenPackCharacterId;

	public UserReport[] userReportList;

	public long ace2CharacterId;// ace第二名
	public long ace3CharacterId;// ace第三名
	
	public TreeMap<Integer/*team*/,TeamData> battleTeamList = new  TreeMap<Integer/*team*/,TeamData>();//对战战队
	public TeamData winbattleTeam = null;//胜利一方的战队ID
}
