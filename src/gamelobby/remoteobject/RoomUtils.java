package gamelobby.remoteobject;

public class RoomUtils {
	
	/**
	 * 比赛类型
	 * @author duty
	 *
	 */
	public static final class  RaceType{
		public static final int TUAN_DUI_JING_JI = 0;
		public static final int BAO_PO_MO_SHI = 1;
		
		public static boolean check(int type) {
			boolean t = false;
			switch(type) {
				case RaceType.TUAN_DUI_JING_JI:
					t = true;
					break;
				case RaceType.BAO_PO_MO_SHI:
					t = true;
					break;
			}
			return t;
		}
	}
	/**
	 * 比赛最多人数
	 * @author duty
	 *
	 */
	public static final class  LimitNumber{
		public static final int NUMBER_2 = 2;
		public static final int NUMBER_4 = 4;
		public static final int NUMBER_6 = 6;
		public static final int NUMBER_8 = 8;
		public static final int NUMBER_10 = 10;
		public static final int NUMBER_12 = 12;
		public static final int NUMBER_14 = 14;
		public static final int NUMBER_16 = 16;
		
		public static boolean check(int limit) {
			boolean t = false;
			switch(limit) {
				case LimitNumber.NUMBER_2:
					t = true;
					break;
				case LimitNumber.NUMBER_4:
					t = true;
					break;
				case LimitNumber.NUMBER_6:
					t = true;
					break;
				case LimitNumber.NUMBER_8:
					t = true;
					break;
				case LimitNumber.NUMBER_10:
					t = true;
					break;
				case LimitNumber.NUMBER_12:
					t = true;
					break;
				case LimitNumber.NUMBER_14:
					t = true;
					break;
				case LimitNumber.NUMBER_16:
					t = true;
					break;
			}
			return t;
		}
	}
	/**
	 * 地图类型
	 * @author duty
	 *
	 */
	public static final class MapType{
		public static final int SI_WANG_SHI_ZI = 0;
		
		public static boolean check(int type) {
			boolean t = false;
			switch(type) {
				case MapType.SI_WANG_SHI_ZI:
					t = true;
					break;
			}
			return t;
		}
	}
	/**
	 * 胜利规则
	 * @author duty
	 *
	 */
	public static final class RulesType{
		public static final int PEOPLE = 0;
		public static final int TIME = 1;
		
		public static boolean check(int type) {
			boolean t = false;
			switch(type) {
				case RulesType.PEOPLE:
					t = true;
					break;
				case RulesType.TIME:
					t = true;
					break;
			}
			return t;
		}
	}
	/**
	 * 胜利目标人数
	 * @author duty
	 *
	 */
	public static final class RulesPeopleType{
		public static final int NUMBER_60 = 60;
		public static final int NUMBER_80 = 80;
		public static final int NUMBER_100 = 100;
		public static final int NUMBER_120 = 120;
		
		public static boolean check(int limit) {
			boolean t = false;
			switch(limit) {
				case RulesPeopleType.NUMBER_60:
					t = true;
					break;
				case RulesPeopleType.NUMBER_80:
					t = true;
					break;
				case RulesPeopleType.NUMBER_100:
					t = true;
					break;
				case RulesPeopleType.NUMBER_120:
					t = true;
					break;
			}
			return t;
		}
	}
	/**
	 * 胜利目标时间
	 * @author duty
	 *
	 */
	public static final class RulesTimeType{
		public static final int NUMBER_5 = 5;
		public static final int NUMBER_7 = 7;
		public static final int NUMBER_9 = 9;
		
		public static boolean check(int limit) {
			boolean t = false;
			switch(limit) {
				case RulesTimeType.NUMBER_5:
					t = true;
					break;
				case RulesTimeType.NUMBER_7:
					t = true;
					break;
				case RulesTimeType.NUMBER_9:
					t = true;
					break;
			}
			return t;
		}
	}
	/**
	 * 房间状态
	 * @author duty
	 *
	 */
	public static final class  RoomStatus{
		public static final int WAIT = 0;
		public static final int ALREADY = 1;
		public static final int START = 2;
	}
}
