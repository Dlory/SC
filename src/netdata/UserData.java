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
	public int readyGame = 0;//锟斤拷锟斤拷状态(0为未准锟斤拷锟斤拷1为准锟斤拷)
	public int isadult = 0;
	public String username = "";
	public String loginToken = "";
	public String[] bagArray = null;
	public int avatarId = 1;//角色ID
	public int avatarSH = 0;//生化的角色ID
	public int dId = 0; // 区号
	public boolean armorBody = false; // 避弹衣
	public boolean armorHead = false; // 避弹头盔
}



