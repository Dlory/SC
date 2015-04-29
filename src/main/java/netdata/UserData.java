package netdata;

import java.io.Serializable;

public class UserData implements Serializable {
	
	public UserData(int userId,long cid,String[] bagArray,String team1Career,String team2Career) {
		this.userId = userId;
		this.characterId = cid;
		this.bagArray = bagArray;
		this.team1Career = team1Career;
		this.team2Career = team2Career;
	}
	
	public UserData() {
		//do nonthing
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -7084372677894693475L;
	public String playerName = "ThisNameIsNotSoGood";
	public String team1Career = "";
	public String team2Career = "";
	public int userId = 0;
	public long characterId = 0;
	public int team = 1;
	public boolean inGameServer = false;
	public int roomId = -1;
	public int readyGame = 0;//
	public int isadult = 0;
	public String username = "";
	public String loginToken = "";
	public String[] bagArray = null;
	public int avatarId = 1;//角色ID
	public int avatarSH = 0;//生化的角色ID
	public int dId = 0; // 区号
	public String dname = "";//区名称
	public boolean armorBody = false; // 避弹衣
	public boolean armorHead = false; // 避弹头盔
	public boolean c4Flag = false; // C4工具钳
	public boolean enterBattleFlag = false;//是否进入过战斗
	
	public double killEfficiency = 0;//击杀效率,战斗力
	public double aliveEfficiency = 0;//生存效率,生存力
	public double kd = 0;//k/d
	public double headKillEfficiency = 0;//爆头率
	
	public boolean biochemicalSerum = false;//生化血清
	public int sprayPaintingCodeName = 0;//喷漆道具对应游戏资源ID
	public boolean virusFlag = false;//强化病毒
	public int biochemicalAvatarCodeName = 0;//变异角色对应游戏资源ID
	public boolean biochemicalMagazineFlag = false;//变异弹匣
	public boolean detectorFlag = false;//探测仪
	public boolean pistolMagazineFlag = false;//手枪弹匣
	public boolean rifleMagazineFlag = false;//步枪弹匣
	public boolean submachineMagazineFlag = false;//冲锋枪弹匣
	public boolean machineMagazineFlag = false;//机枪弹匣
	public boolean sniperMagazineFlag = false;//狙击枪弹匣
	public boolean shotgunMagazineFlag = false;//霰弹枪弹匣
	
	/**
	 * 自由竞技等级
	 */
	public int lv = 1;
	/**
	 * 个人联赛段位
	 * 1-青铜，2-白银，3-黄金，4-铂金，5钻石，6王者
	 */
	public int raceRankSect = 0;
	/**
	 * 个人联赛段位等级
	 */
	public int raceRankLv = 1;
	/**
	 * 新手引导 -1 表示完成引导
	 */
	public int newbieGuide = -1;
	/**
	 * 战队名字
	 */
	public String teamName = "";
	
	public int teamId = 0;
	/**
	 * 白水晶没有掉落保持时间(单位：秒)
	 */
	public int whiteCrystalStayTime = 0;
	/**
	 * 还可以获取到的白水晶数目
	 */
	public int whiteCrystalNumCurrentDay = 0;
	/**
	 * 每天是否已经获取到白水晶的标志,true表示已经获取过首杀,false表示还没获取过
	 */
	public boolean addWhiteCrystalFromBattlePerDayFlag = false;
	public boolean observerFlag = false;//是否观察者
	/**
	 * 背部装饰名
	 */
	public String backDecorationCodeName = "";
	
}



