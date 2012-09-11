package gamelobby.remoteobject;

public class RoomUtils {
	
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
	
	public static final class  RoomStatus{
		public static final int WAIT = 0;
		public static final int ALREADY = 1;
		public static final int START = 2;
	}
}
