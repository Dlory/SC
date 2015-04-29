package netdata.roomdata;

public class Rule {
	public static final int EXPLODE = 2;	
	public static final int GROUP = 3;
	/**
	 * 娱乐团队 有大杀器
	 */
	public static final int GROUP_RECHARGE = 32;
	public static final int SPECIAL_GROUP = 4;
	public static final int PERSONAL = 5;
	public static final int BIOCHEMICAL = 6;
	public static final int HEROCRAFT = 7;
	public static final int RECREATION_EXPLODE = 8;
	public static final int KING_OF_GUN = 9;
	public static final int GROUP_KING_OF_GUN = 10;
	/**
	 * 团队争霸
	 */
	public static final int RECREATION_GROUP = 11;
	/**
	 * 死亡竞赛
	 */
	public static final int DEATH_MATCH = 12;
	public static final int DEATH_EXPLODE = 13;
	/**
	 * 终极变异
	 */
	public static final int FINAL_BIOCHEMICAL= 14;
	/**
	 * 刀锋战士
	 */
	public static final int BLADE= 15;
	public static final int SUPER_BIOCHEMICAL = 16;
	public static final int GHOST_BIOCHEMICAL = 17;
	/**
	 * 属于生化模式
	 */
	public static boolean isBioRule(int raceType)
	{
		if(raceType == BIOCHEMICAL
				|| raceType == HEROCRAFT
				|| raceType == FINAL_BIOCHEMICAL
				|| raceType == SUPER_BIOCHEMICAL
				|| raceType == GHOST_BIOCHEMICAL
				)
		{
			return true;
		}
		return false;
	}
	public static boolean isNoTeamRule(int raceType)
	{
		if(raceType == KING_OF_GUN || raceType == PERSONAL)
		{
			return true;
		}
		return false;
	}
}
