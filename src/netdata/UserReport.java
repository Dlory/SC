package netdata;

import java.io.Serializable;

public class UserReport implements Serializable {
	public int characterId = 0;
	public String playerName = "";
	public int team = 0;
	public int killNum = 0;
	public int beKillNum = 0;
	public int headKill = 0;
	public int wallKill = 0;
	public int knifeKill = 0;
	public int grenadeKill = 0;

	public int hidePackNum = 0; // 埋包次数
	public int openPackNum = 0; // 拆包次数
	public int duration = 0; // s 游戏时长
	
	public int[] bagUsed = null; // 每个背包的使用时间 index from 0

	// 以下字段占位 房间服务器会赋值
	public int lv = 0;
//	public int title = 0; // 位来表示战斗中获得的头衔
	public long baseExp = 0; // 基础经验
	public long addExp = 0; // 经验加成
	public int gp = 0;
	public boolean result = false;

}