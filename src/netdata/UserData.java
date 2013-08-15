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
	public int readyGame = 0;//ï¿½ï¿½ï¿½ï¿½×´Ì¬(0ÎªÎ´×¼ï¿½ï¿½ï¿½ï¿½1Îª×¼ï¿½ï¿½)
	public int isadult = 0;
	public String username = "";
	public String loginToken = "";
	public String[] bagArray = null;
	public int avatarId = 1;//½ÇÉ«ID
	public int avatarSH = 0;//Éú»¯µÄ½ÇÉ«ID
}



