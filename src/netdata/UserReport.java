package netdata;

import java.io.Serializable;

public class UserReport implements Serializable {
	public int characterId = 0;
	public String playerName;
	public int team = 0;
	public int killNum = 0;
	public int beKillNum = 0;
	public int headKill = 0;
	public int wallKill = 0;
	public int knifeKill = 0;
	public int grenadeKill = 0;
	
	public int hidePackNum = 0; // 埋包次数
	public int openPackNum = 0; // 拆包次数
	
}