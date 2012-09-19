package gamelobby.remoteobject;

import java.io.Serializable;

import common.net.NetSession;

public class UserInfo implements Serializable {

	public String playerName = "";
	public String career = "";
	public int userId = 0;
	public int characterId = 0;
	public int team = 1;
	public boolean inGameServer = false;
	public int roomId = -1;
	public int isadult = 0;
	public String username = "";
	public String loginToken = "";
}
