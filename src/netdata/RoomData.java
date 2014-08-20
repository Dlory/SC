package netdata;

import java.io.Serializable;
import java.util.TreeMap;

public class RoomData implements Serializable {
	public int roomId = 0;
	public int sceneId = 0;//地图ID
	public int winCondition = 0;//比赛规则，回合数、时间、杀人数等
	public int winScore = 0;//比赛规则数值
	public int raceType = 0;//比赛类型，团战、爆破战、特殊战等
	public int subRaceType = 0;//子模式，刀战、手枪战、雷战等;
	public int sectionTime = 0;
	public int reLiveTime = 3;//复活时间(秒数)
	public int createTime = 0;
	public boolean changeTeam = false;//爆破模式 半场换边
	public int playerNum = 0;//人数，当前模型下满人个数
	public boolean isPromise = false;
	public TreeMap<Integer/*team*/,TeamData> battleTeamList = new  TreeMap<Integer/*team*/,TeamData>();//对战战队
}
