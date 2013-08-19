package netdata;

import java.io.Serializable;

public class UserData implements Serializable {
	public String playerName = "";
	public String career = "";
	public int userId = 0;
	public int characterId = 0;
	public int team = 1;
	public boolean inGameServer = false;
	public int roomId = -1;
	public int readyGame = 0;//����״̬(0Ϊδ׼����1Ϊ׼��)
	public int isadult = 0;
	public String username = "";
	public String loginToken = "";
	public String[] bagArray = null;
	public int dId = 0; // 区号
}



