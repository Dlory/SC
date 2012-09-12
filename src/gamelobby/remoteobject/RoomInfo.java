package gamelobby.remoteobject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import common.net.NetSession;


public class RoomInfo {

	public String roomName = "";
	public int roomId = 0;
	public int raceType = RoomUtils.RaceType.TUAN_DUI_JING_JI;//比赛类型
	public int limitNumber = RoomUtils.LimitNumber.NUMBER_2;//比赛最多人数
	public int accessNumber = 0;//已进入人数
	public String password = "";//进入密码
	public int status = RoomUtils.RoomStatus.WAIT;//状态
	private Map<NetSession,UserInfo> userList;;
	
	/**
	 * 默认分配的队伍
	 */
	private int allotTeam = 1;
	public RoomInfo() {
		userList = new HashMap<NetSession,UserInfo>();
	}
	
	/**
	 * 分配队伍
	 * @return
	 */
	public int getTeam(){
		if(allotTeam == 1) {
			allotTeam = 2;
		} else {
			allotTeam = 1;
		}
		return allotTeam;
	}
	public boolean addUser(NetSession client, UserInfo userInfo) {
		if(userInfo.roomId == -1) {
			userInfo.roomId = roomId;
			userList.put(client, userInfo);
			accessNumber = userList.size();
			return true;
		}
		return false;
	}
	public void removeUser(NetSession client) {
		UserInfo userInfo = userList.get(client);
		userInfo.roomId = -1;
		userList.remove(client);
		accessNumber = userList.size();
	}
	public Map<NetSession,UserInfo> accessUserList() {
		return userList;
	}
	
	/**
	 * 广播信息给房间内玩家
	 * @param funcName
	 * @param params
	 */
	public void broadcast(String funcName, Object...params) {
		Set<NetSession> key = userList.keySet();
		for(Iterator<NetSession> it = key.iterator();it.hasNext();) {
			NetSession session = it.next();
			session.call(funcName, params);
		}
	}
}
