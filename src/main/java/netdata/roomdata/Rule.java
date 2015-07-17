package netdata.roomdata;

public class Rule {
	/**
	 * 爆破
	 */
	public static final int EXPLODE = 2;
	/**
	 * 经典团队
	 */
	public static final int GROUP = 3;
	/**
	 * 特殊模式
	 */
	public static final int SPECIAL_GROUP = 4;
	/**
	 * 个人模式
	 */
	public static final int PERSONAL = 5;
	/**
	 * 变异战
	 */
	public static final int BIOCHEMICAL = 6;
	/**
	 * 英雄对决
	 */
	public static final int HEROCRAFT = 7;
	/**
	 * 无限爆破
	 */
	public static final int RECREATION_EXPLODE = 8;
	/**
	 * 枪王之王
	 */
	public static final int KING_OF_GUN = 9;
	/**
	 * 团队枪王
	 */
	public static final int GROUP_KING_OF_GUN = 10;
	/**
	 * 娱乐团队 有大杀器
	 */
	public static final int GROUP_RECHARGE = 32;
	/**
	 * 团队争霸
	 */
	public static final int RECREATION_GROUP = 11;
	/**
	 * 死亡竞赛
	 */
	public static final int DEATH_MATCH = 12;
	/**
	 * 生死爆破
	 */
	public static final int DEATH_EXPLODE = 13;
	/**
	 * 终极变异
	 */
	public static final int FINAL_BIOCHEMICAL= 14;
	/**
	 * 刀锋战士
	 */
	public static final int BLADE= 15;
	/**
	 * 超能变异
	 */
	public static final int SUPER_BIOCHEMICAL = 16;
	/**
	 * 幽灵变异
	 */
	public static final int GHOST_BIOCHEMICAL = 17;
	/**
	 * 塔防模式
	 * 
	 */
	public static final int TD=18;
	/**
	 * 大头模式
	 */
	public static final int BIG_HEAD = 19;
	/**
	 * 编译觉醒
	 */
	public static final int BIO_AWAKE = 20;
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
				|| raceType == BIO_AWAKE
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
