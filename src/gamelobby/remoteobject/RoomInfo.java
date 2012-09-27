package gamelobby.remoteobject;

import gamelobby.remoteobject.RoomUtils.RulesPeopleType;
import gamelobby.remoteobject.RoomUtils.RulesTimeType;
import gamelobby.remoteobject.RoomUtils.RulesType;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import common.net.NetSession;


public class RoomInfo {

	public String roomName = "";
	public int roomId = 0;
	public int raceType = RoomUtils.RaceType.TUAN_DUI_JING_JI;//��������
	public int limitNumber = RoomUtils.LimitNumber.NUMBER_2;//�����������
	public int accessNumber = 0;//�ѽ�������
	public String password = "";//��������
	public int status = RoomUtils.RoomStatus.WAIT;//״̬
	private Map<NetSession,UserInfo> userList;
	
	public int mapType = RoomUtils.MapType.SI_WANG_SHI_ZI;//��ͼ����
	public int rules = RulesType.PEOPLE;//ʤ������
	public int rulesPeople = RulesPeopleType.NUMBER_60;//ɱ����(��rules=RulesType.PEOPLEʱ����)
	public int rulesTime = RulesTimeType.NUMBER_5;//��Ϸʱ��(��rules=RulesType.TIMEʱ����)
	public int createCharacterId = 0;//����������û���ɫID
	/**
	 * Ĭ�Ϸ���Ķ���
	 */
	private int allotTeam = 1;
	public RoomInfo() {
		userList = new HashMap<NetSession,UserInfo>();
	}
	
	/**
	 * �������
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
		userInfo.readyGame = 0;
		userList.remove(client);
		accessNumber = userList.size();
	}
	public Map<NetSession,UserInfo> accessUserList() {
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
