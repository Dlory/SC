package netdata;

import java.io.Serializable;

public class BattleReport implements Serializable {
	public int roomId = 0;
	/**
	 * ʤ������ 1��ʶ����ʤ�� 2��ʶ����ʤ�� 0 ��ʾ��ʤ��
	 */
	public int winTeam = 0;
	/**
	 * ����ɱ����
	 */
	public int team1killNum = 0;
	/**
	 * ����ɱ����
	 */
	public int team2killNum = 0;
	/**
	 * ��Ҹ���ս��
	 */
	public UserReport[] userReportList;
}
