package netdata;

import java.io.Serializable;

public class UserReport implements Serializable {
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

	public int hidePackNum = 0; // 埋包次数
	public int openPackNum = 0; // 拆包次数
	public int duration = 0; // s 游戏时长

	public int[] bagUsed = null; // 每个背包的使用时间 index from 0
	public float lianShaAdded = 0; // 连杀加成
	public int aliveNum = 0; // 总存活次数
//	public RankUserBean rankBean = null;

	// 以下字段占位 房间服务器会赋值
	public int lv = 0;
	// public int title = 0; // 位来表示战斗中获得的头衔
	public long baseExp = 0; // 基础经验
	public long addExp = 0; // 经验加成
	public int baseGp = 0; // 基础gp
	public int addGp = 0;//gp加成
	public boolean result = false;

	
	public int moreLianSha = 0;//最高连杀数
	public int fireNum = 0;//开火次数
	public int hitNum = 0;//命中次数
	public int assistsNum = 0;//助攻次数
	public int hidePackSucNum = 0;//埋包成功次数
	public int openPackSucNum = 0;//拆包成功次数
	public int roundNum = 0;//爆破模式的回合数
	public double personalPerf = 0;// 个人表现
	public boolean historyReport = false;
	public int teamId = 0;//战队id
	public int whiteCrystalNum = 0;//获得白水晶数量
	public int whiteCrystalStayTime = 0;//白水晶没有掉落保持时间(单位：秒)
	public int reliveTeammateNum = 0;//尝试救活队友次数
	public int reliveTeammateNumSuccess = 0;//成功救活队友次数
}