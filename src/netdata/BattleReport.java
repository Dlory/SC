package netdata;

import java.io.Serializable;

public class BattleReport implements Serializable {
	public int roomId = 0;
	/**
	 * 胜利队伍 1标识土匪胜利 2标识警察胜利 0 表示无胜负
	 */
	public int winTeam = 0;
	/**
	 * 土匪得分
	 */
	public int team1Score = 0;
	/**
	 * 警察得分
	 */
	public int team2Score = 0;
	public int mvpCharacterId;
	public int lastKillCharacterId;
	/**
	 * 玩家个人战报
	 */
	public UserReport[] userReportList;
}
