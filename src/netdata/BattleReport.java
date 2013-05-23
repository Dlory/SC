package netdata;

import java.io.Serializable;

public class BattleReport implements Serializable {
	public int roomId = 0;
	/**
	 * ʤ������ 1��ʶ����ʤ�� 2��ʶ����ʤ�� 0 ��ʾ��ʤ��
	 */
	public int winTeam = 0;
	/**
	 * ���˵÷�
	 */
	public int team1Score = 0;
	/**
	 * ����÷�
	 */
	public int team2Score = 0;
	public int mvpCharacterId;
	public int lastKillCharacterId;
	/**
	 * ��Ҹ���ս��
	 */
	public UserReport[] userReportList;
}
