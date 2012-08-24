package gamelobby.remoteobject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import common.net.NetSession;


public class RoomInfo {

	public String roomName = "";
	public int roomId = 0;
	private Map<NetSession,UserInfo> userList;
	public RoomInfo()
	{
		userList = new HashMap<NetSession,UserInfo>();
	}
	
	public boolean addUser(NetSession client, UserInfo userInfo)
	{
		if(userInfo.roomId == -1)
		{
			userInfo.roomId = roomId;
			userList.put(client, userInfo);
			return true;
		}
		return false;
	}
	public void removeUser(NetSession client)
	{
		UserInfo userInfo = userList.get(client);
		userInfo.roomId = -1;
		userList.remove(client);
	}
	public Map<NetSession,UserInfo> accessUserList()
	{
		return userList;
	}
	
	/**
	 * �㲥��Ϣ�����������
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
