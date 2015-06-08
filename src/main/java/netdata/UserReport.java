package netdata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class UserReport implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1196861901870113312L;
	public int dId = 0; // 区号
	public long characterId = 0;
	public String playerName = "";
	public int team = 0;
	public int runNum = 0; // 逃跑次数
	public int killNum = 0;
	public int beKillNum = 0;
	public int headKill = 0;
	public int wallKill = 0;
	public int knifeKill = 0;
	public int grenadeKill = 0;
	public int killHeroKill = 0;//击杀英雄
	public int score = 0;//表现分 战绩
	public int hidePackNum = 0; // 埋包次数
	public int openPackNum = 0; // 拆包次数
	public int duration = 0; // s 游戏时长

	public int[] bagUsed = null; // 每个背包的使用时间 index from 0
	public float lianShaAdded = 0; // 连杀加成
	public int aliveNum = 0; // 总存活次数
	
	public boolean primaryExpCardFlag = false;
	public boolean primaryGpCardFlag = false;
	public boolean advancedExpCardFlag = false;
	public boolean advancedGpCardFlag = false;
	public Collection<Long> friendList = null;

	public float expDecoration;//exp饰品倍率
	public float gpDecoration;//gp饰品倍率
	
	//武器经验和GP加成参数
	public float weaponSelfAddExp = 0;
	public float weaponOtherAddExp = 0;
	public float weaponSelfAddGp = 0;
	public float weaponOtherAddGp = 0;
	public boolean hasHeroWeapon = false;
	public Collection<MultiCampaignData> multiCampaigns = null;//N倍活动加成信息

	// 以下字段占位 房间服务器会赋值
	public int lv = 0;
	// public int title = 0; //位来表示战斗中获得的头衔
	public int baseExp = 0; //基础经验
	public int baseGp = 0; //基础gp
	public boolean result = false;
	
	public int moreLianSha = 0;//最高连杀数
	public int fireNum = 0;//开火次数
	public int hitNum = 0;//命中次数
	public int assistsNum = 0;//助攻次数
	public int hidePackSucNum = 0;//埋包成功次数
	public int openPackSucNum = 0;//拆包成功次数
	public int roundNum = 0;//爆破模式的回合数
	public double personalPerf = 0;// 个人联赛表现分
	public boolean historyReport = false;
	public int teamId = 0;//战队id
	public int whiteCrystalNum = 0;//获得白水晶数量
	public int whiteCrystalStayTime = 0;//白水晶没有掉落保持时间(单位：秒)
	public int reliveTeammateNum = 0;//尝试救活队友次数
	public int reliveTeammateNumSuccess = 0;//成功救活队友次数
	public int rushWinNum = 0;//获得残局1VN胜利次数
	public int rampagNum = 0;//超神的次数
	public int heroKillNum = 0;//英雄状态下的击杀数
	public int killZombieNum = 0;//击杀变异体
	public int infectionNum = 0;//感染人数
	public int killZombieHeroNum = 0;//击杀母体
	public int killQueenNum = 0;//击杀变异女皇
	public int heroMaxKillNum = 0;//英雄最高连杀数
	public int maxInfectionNum = 0;//最高感染数
	public int changeHeroNum = 0;//变身英雄次数
	public boolean[] sectionBestKill = null;//枪王赛各阶段最佳标志
	public boolean isNurse = false;//战地医生
	
	public int battleAddExp = 0; //战斗荣耀经验加成
	public int battleAddGp = 0;//战斗荣耀gp加成
	public int heroWeaponAddExp = 0;//英雄武器经验加成
	public int heroWeaponAddGp = 0;//英雄武器金币加成
	public int teamAndFriendAddExp = 0;//战队加成
	public int primaryExpCardAddExp = 0;//初级经验卡经验加成
	public int primaryGpCardAddGp = 0;//初级GP卡经验加成
	public int advancedExpCardAddExp = 0;//高级经验卡经验加成
	public int advancedGpCardAddGp = 0;//高级GP卡GP加成
	public int decorationAddExp = 0;//饰品经验加成
	public int decorationAddGp = 0;//饰品GP加成
	
	public float battleAddExpRatio = 0; //战斗荣耀经验加成比
	public float battleAddGpRatio = 0;//战斗荣耀gp加成比
	public float heroWeaponAddExpRatio = 0;//英雄武器经验加成比
	public float heroWeaponAddGpRatio = 0;//英雄武器金币加成比
	public float teamAndFriendAddExpRatio = 0;//战队加成比
	public float primaryExpCardAddExpRatio = 0;//初级经验卡经验加成比
	public float primaryGpCardAddGpRatio = 0;//初级GP卡经验加成比
	public float advancedExpCardAddExpRatio = 0;//高级经验卡经验加成比
	public float advancedGpCardAddGpRatio = 0;//高级GP卡GP加成比
	public float decorationAddExpRatio = 0;//饰品经验加成比
	public float decorationAddGpRatio = 0;//饰品GP加成比
	
	public void copyFromUserData(UserData userData)
	{
		primaryExpCardFlag = userData.primaryExpCardFlag;
		primaryGpCardFlag = userData.primaryGpCardFlag;
		advancedExpCardFlag = userData.advancedExpCardFlag;
		advancedGpCardFlag = userData.advancedGpCardFlag;
		friendList = new ArrayList<Long>();
		if(userData.friendList != null)
		{
			for(int id : userData.friendList)
			{
				friendList.add(userData.dId * 100000000L + id);
			}
		}
		expDecoration = userData.expDecoration;
		gpDecoration = userData.gpDecoration;
		
		
		weaponSelfAddExp = userData.weaponSelfAddExp;
		weaponOtherAddExp = userData.weaponOtherAddExp;
		weaponSelfAddGp = userData.weaponSelfAddGp;
		weaponOtherAddGp = userData.weaponOtherAddGp;
		hasHeroWeapon = userData.hasHeroWeapon;
		multiCampaigns = userData.multiCampaigns;

	}
}