package battle;

import netdata.BattleReport;
import netdata.MultiCampaignData;
import netdata.UserReport;
import netdata.roomdata.Rule;

import java.util.*;

public class ExpAndGpCaculator
{
	private static final float PRIMARY_EXP_CARD_ADDITION = 0.3f;    //初级经验卡加成
	private static final float PRIMARY_GP_CARD_ADDITION = 0.3f;     //初级GP卡加成
	private static final float ADVANCED_EXP_CARD_ADDITION = 0.6f;   //高级经验卡加成
	private static final float ADVANCED_GP_CARD_ADDITION = 0.6f;         //高级GP卡加成

	public static void calculate(BattleReport battleReport)
	{
		if (battleReport.userReportList.length > 0)
		{
			//在个人联赛中，战斗会将中途掉线玩家的战报传回，但这些玩家不能进行经验和GP计算，且增加的经验和GP为0
			Vector<UserReport> vUserReport = new Vector<UserReport>();
			for (UserReport userReport : battleReport.userReportList)
			{
				if (userReport.historyReport)
				{
					userReport.baseExp = 0;
					userReport.baseGp = 0;
					userReport.battleAddExp = 0;
					userReport.battleAddGp = 0;
					userReport.heroWeaponAddExp = 0;
					userReport.heroWeaponAddGp = 0;
					userReport.teamAndFriendAddExp = 0;
					userReport.primaryExpCardAddExp = 0;
					userReport.primaryGpCardAddGp = 0;
					userReport.advancedExpCardAddExp = 0;
					userReport.advancedGpCardAddGp = 0;
					userReport.decorationAddExp = 0;
					userReport.decorationAddGp = 0;
				}
				else
				{
					vUserReport.add(userReport);
				}
			}

			if (vUserReport.size() > 0)
			{
				UserReport[] originUserReportList = battleReport.userReportList;
				//重新赋值战报
				battleReport.userReportList = vUserReport.toArray(new UserReport[vUserReport.size()]);

				//计算基础GP、EXP
				for (int i = 0; i < battleReport.userReportList.length; i++)
				{
					UserReport u = battleReport.userReportList[i];
					u.baseExp = getBaseExp(battleReport, u);
					u.baseGp = getBaseGp(battleReport, u);
				}

				//计算战斗荣耀加成
				addGpOrExpForAward(battleReport);
				//计算多倍活动加成
				addGpOrExpForMultiCampaign(battleReport);
				//计算道具加成
				addExtraGpOrExpForItem(battleReport);
				//计算好友和队友加成
				addExpForTeamAndFriend(battleReport);
				//计算武器加成
				addGpAndExpForWeapon(battleReport);
				
				battleReport.userReportList = originUserReportList;
			}
		}
	}
	
	public static int getBaseExp(BattleReport br, UserReport ur)
	{
		double baseExp = ur.duration / 60 * 20;
		
		double bf = 0;
		if (br.totalNum <= 2) 
		{
			bf = 0.4;
		} 
		else if (br.totalNum <= 5) 
		{
			bf = 0.8;
		} 
		else if (br.totalNum <= 8) 
		{
			bf = 1;
		} 
		else if (br.totalNum <= 12) 
		{
			bf = 1.4;
		} 
		else if (br.totalNum <= 16) 
		{
			bf = 1.6;
		} 
		else 
		{
			bf = 1.8;
		}
		
		double mf = 0;
		switch (br.roomData.raceType) 
		{
			case Rule.EXPLODE:
				mf = 1;
				break;
			case Rule.GROUP:
				mf = 0.75;
				break;
			case Rule.SPECIAL_GROUP:
				mf = 0.75;
				break;
			case Rule.PERSONAL:
				mf = 0.75;
				break;
			case Rule.BIOCHEMICAL:
				mf = 0.75;
				break;
			case Rule.HEROCRAFT:
				mf = 0.75;
				break;
			case Rule.RECREATION_EXPLODE:
				mf = 0.9;
				break;
			case Rule.KING_OF_GUN:
				mf = 0.9;
				break;
			case Rule.GROUP_KING_OF_GUN:
				mf = 0.9;
				break;
			case Rule.GROUP_RECHARGE:
				mf = 0.9;
				break;
			case Rule.RECREATION_GROUP:
				mf = 0.9;
				break;
			case Rule.DEATH_MATCH:
				mf = 0.9;
				break;
			case Rule.DEATH_EXPLODE:
				mf = 0.9;
				break;
			case Rule.BLADE:
				mf = 0.9;
				break;
			case Rule.FINAL_BIOCHEMICAL:
				mf = 0.75;
				break;
			case Rule.SUPER_BIOCHEMICAL:
				mf = 0.75;
				break;
			case Rule.GHOST_BIOCHEMICAL:
				mf = 0.75;
				break;
			case Rule.TD:
				mf = 0;
				break;
			case Rule.BIG_HEAD:
				mf = 0.75;
				break;
			default:
				mf = 0.75;
				break;
		}
		
		if(br.roomData.raceType == Rule.BIOCHEMICAL || br.roomData.raceType == Rule.HEROCRAFT || br.roomData.raceType == Rule.FINAL_BIOCHEMICAL || br.roomData.raceType == Rule.SUPER_BIOCHEMICAL || br.roomData.raceType == Rule.GHOST_BIOCHEMICAL) 
		{
			baseExp = (baseExp + Math.min(2000, ur.score) / 3.5 ) * bf * mf;
		}
		else
		{
			double kdf = 0;
			double kd = 0;
			if (ur.killNum > 0) {
				kd = (double) ur.killNum / ur.beKillNum;
			}
			if (ur.beKillNum == 0) {
				kd = (double) ur.killNum;
			}

			if (kd < 1) {
				kdf = 0.9;
			} else if (kd < 1.4) {
				kdf = 1;
			} else if (kd < 1.8) {
				kdf = 1.1;
			} else if (kd < 2) {
				kdf = 1.15;
			} else {
				kdf = 1.2;
			}
			
			baseExp += Math.min(100.0, (ur.headKill * 1.5 + (ur.killNum - ur.headKill) * 1));
			baseExp = baseExp * bf * kdf * mf;
		}
		
		return (int)Math.round(baseExp);
	}

	public static int getBaseGp(BattleReport br, UserReport ur) 
	{
		double baseGp = ur.duration / 60 * 18;
		
		double bf = 0;
		if (br.totalNum <= 2) 
		{
			bf = 0.4;
		} 
		else if (br.totalNum <= 5) 
		{
			bf = 0.8;
		} 
		else if (br.totalNum <= 8) 
		{
			bf = 1;
		} 
		else if (br.totalNum <= 12) 
		{
			bf = 1.4;
		} 
		else if (br.totalNum <= 16) 
		{
			bf = 1.6;
		} 
		else 
		{
			bf = 1.8;
		}
		
		double mf = 0;
		switch (br.roomData.raceType) 
		{
			case Rule.EXPLODE:
				mf = 1;
				break;
			case Rule.GROUP:
				mf = 0.75;
				break;
			case Rule.SPECIAL_GROUP:
				mf = 0.75;
				break;
			case Rule.PERSONAL:
				mf = 0.75;
				break;
			case Rule.BIOCHEMICAL:
				mf = 0.75;
				break;
			case Rule.HEROCRAFT:
				mf = 0.75;
				break;
			case Rule.RECREATION_EXPLODE:
				mf = 0.9;
				break;
			case Rule.KING_OF_GUN:
				mf = 0.9;
				break;
			case Rule.GROUP_KING_OF_GUN:
				mf = 0.9;
				break;
			case Rule.GROUP_RECHARGE:
				mf = 0.9;
				break;
			case Rule.RECREATION_GROUP:
				mf = 0.9;
				break;
			case Rule.DEATH_MATCH:
				mf = 0.9;
				break;
			case Rule.DEATH_EXPLODE:
				mf = 0.9;
				break;
			case Rule.BLADE:
				mf = 0.9;
				break;
			case Rule.FINAL_BIOCHEMICAL:
				mf = 0.75;
				break;
			case Rule.SUPER_BIOCHEMICAL:
				mf = 0.75;
				break;
			case Rule.GHOST_BIOCHEMICAL:
				mf = 0.75;
				break;
			case Rule.TD:
				mf = 0;
				break;
			case Rule.BIG_HEAD:
				mf = 0.75;
				break;
			default:
				mf = 0.75;
				break;
		}
		
		if(br.roomData.raceType == Rule.BIOCHEMICAL || br.roomData.raceType == Rule.HEROCRAFT || br.roomData.raceType == Rule.FINAL_BIOCHEMICAL || br.roomData.raceType == Rule.SUPER_BIOCHEMICAL || br.roomData.raceType == Rule.GHOST_BIOCHEMICAL) 
		{
			baseGp = (baseGp + Math.min(2000, ur.score) / 3.5 ) * bf * mf;
		}
		else
		{
			double kdf = 0;
			double kd = 0;
			if (ur.killNum > 0) {
				kd = (double) ur.killNum / ur.beKillNum;
			}
			if (ur.beKillNum == 0) {
				kd = (double) ur.killNum;
			}

			if (kd < 1) {
				kdf = 0.9;
			} else if (kd < 1.4) {
				kdf = 1;
			} else if (kd < 1.8) {
				kdf = 1.1;
			} else if (kd < 2) {
				kdf = 1.15;
			} else {
				kdf = 1.2;
			}
			
			baseGp += Math.min(100, (int)(ur.headKill * 1.5 + (ur.killNum - ur.headKill) * 1));
			baseGp = baseGp * bf * kdf * mf;
		}
		
		return (int)Math.round(baseGp);
	}


	private static void addGpOrExpForAward(BattleReport battleReport)
	{
		for (int i = 0; i < battleReport.userReportList.length; i++)
		{
			UserReport userReport = battleReport.userReportList[i];

			userReport.battleAddExpRatio = 0;
			userReport.battleAddGpRatio = 0;

			//变异战、主宰、幸存、封魔经验加成
			if(Rule.isBioRule(battleReport.roomData.raceType))
			{
				if(userReport.characterId == battleReport.bioAceCharacterId)
				{
					userReport.battleAddExpRatio += 0.25;
				}
				if(userReport.characterId == battleReport.maxInfectionCharacterId)
				{
					userReport.battleAddExpRatio += 0.05;
				}
				if(userReport.characterId == battleReport.maxLiveCharacterId)
				{
					userReport.battleAddExpRatio += 0.05;
				}
			}
			else
			{
				//MVP - 爆破战
				if ((userReport.characterId == battleReport.ctMvpCharacterId || userReport.characterId == battleReport.tMvpCharacterId) &&
					battleReport.roomData.raceType == Rule.EXPLODE)
				{
					userReport.battleAddExpRatio += 0.1;
				}

				//爆破手 - 爆破战、无限爆破、生死爆破
				if ((userReport.characterId == battleReport.maxHidePackCharacterId || userReport.characterId == battleReport.maxOpenPackCharacterId) &&
					(battleReport.roomData.raceType == Rule.EXPLODE || battleReport.roomData.raceType == Rule.RECREATION_EXPLODE || battleReport.roomData.raceType == Rule.DEATH_EXPLODE))
				{
					userReport.battleAddExpRatio += 0.05;
				}

				//救助者 - 生死爆破、刀锋战士、死亡竞赛
				if ((userReport.isNurse) &&
					(battleReport.roomData.raceType == Rule.BLADE || battleReport.roomData.raceType == Rule.DEATH_EXPLODE || battleReport.roomData.raceType == Rule.DEATH_MATCH))
				{
					userReport.battleAddExpRatio += 0.1;
				}
				
				//没有阵营的KD王 - 枪王之王、个人战
				if((userReport.characterId == battleReport.kdKingCharacterId) &&
				   (battleReport.roomData.raceType == Rule.KING_OF_GUN || battleReport.roomData.raceType == Rule.PERSONAL))
				{
					userReport.battleAddExpRatio += 0.05;
				}
				
				//有阵营的KD王 - 爆破战、无限爆破、生死爆破、刀锋战士、死亡竞赛、经典团战、娱乐团战、团队争霸、特殊战、团队枪王
				if ((userReport.characterId == battleReport.ctKdKingCharacterId || userReport.characterId == battleReport.tKdKingCharacterId) &&
					(battleReport.roomData.raceType == Rule.EXPLODE ||battleReport.roomData.raceType == Rule.RECREATION_EXPLODE ||battleReport.roomData.raceType == Rule.DEATH_EXPLODE ||
					 battleReport.roomData.raceType == Rule.BLADE ||battleReport.roomData.raceType == Rule.DEATH_MATCH ||battleReport.roomData.raceType == Rule.GROUP ||
					 battleReport.roomData.raceType == Rule.GROUP_RECHARGE ||battleReport.roomData.raceType == Rule.RECREATION_GROUP ||battleReport.roomData.raceType == Rule.SPECIAL_GROUP ||
					 battleReport.roomData.raceType == Rule.GROUP_KING_OF_GUN))
				{
					userReport.battleAddExpRatio += 0.05;
				}
				
				//大头终结者 - 大头争霸
				if ((userReport.characterId == battleReport.terminatorCharacterId) &&
					battleReport.roomData.raceType == Rule.BIG_HEAD)
				{
					userReport.battleAddExpRatio += 0.05;
				}
				
				//大头霸者 - 大头争霸
				if ((userReport.characterId == battleReport.overloadCharacterId) &&
					battleReport.roomData.raceType == Rule.BIG_HEAD)
				{
					userReport.battleAddExpRatio += 0.05;
				}
				
				//战地医生 - 大头争霸
				if((userReport.isNurse) && 
				    battleReport.roomData.raceType == Rule.BIG_HEAD)
				{
					userReport.battleAddExpRatio += 0.05;
				}
				
				//枪王 - 个人枪王、团队枪王
				if(userReport.characterId == battleReport.kingCharacterId && 
				   (battleReport.roomData.raceType == Rule.KING_OF_GUN || battleReport.roomData.raceType == Rule.GROUP_KING_OF_GUN))
				{
					userReport.battleAddExpRatio += 0.25;
				}

				//ACE - 爆破战、无限爆破、生死爆破、刀锋战士、死亡竞赛、经典团战、娱乐团战、团队争霸、特殊战、个人、大头
				if (userReport.characterId == battleReport.aceCharacterId &&
					(battleReport.roomData.raceType == Rule.EXPLODE ||battleReport.roomData.raceType == Rule.RECREATION_EXPLODE ||battleReport.roomData.raceType == Rule.DEATH_EXPLODE ||
					 battleReport.roomData.raceType == Rule.BLADE ||battleReport.roomData.raceType == Rule.DEATH_MATCH ||battleReport.roomData.raceType == Rule.GROUP ||
					 battleReport.roomData.raceType == Rule.GROUP_RECHARGE ||battleReport.roomData.raceType == Rule.RECREATION_GROUP ||battleReport.roomData.raceType == Rule.SPECIAL_GROUP ||
					 battleReport.roomData.raceType == Rule.PERSONAL || battleReport.roomData.raceType == Rule.BIG_HEAD))
				{
					userReport.battleAddExpRatio += 0.25;
					userReport.battleAddGpRatio += 0.1;
				}
			}
			
			userReport.battleAddExp = Math.round(userReport.battleAddExpRatio * userReport.baseExp);
			userReport.battleAddGp = Math.round(userReport.battleAddGpRatio * userReport.baseGp);
		}
	}

	private static void addGpOrExpForMultiCampaign(BattleReport battleReport)
	{
		for (UserReport userReport : battleReport.userReportList)
		{
			if(userReport.multiCampaigns != null)
			{
				for(MultiCampaignData e : userReport.multiCampaigns)
				{
					e.addExp = userReport.baseExp * e.expMuti;
					e.addGp = userReport.baseExp * e.gpMuti;
				}
			}
		}
	}

	private static void addExtraGpOrExpForItem(BattleReport battleReport)
	{
		for (UserReport userReport : battleReport.userReportList)
		{
			//初级经验卡
			if(userReport.primaryExpCardFlag)
			{
				userReport.primaryExpCardAddExpRatio = PRIMARY_EXP_CARD_ADDITION;
				userReport.primaryExpCardAddExp =  Math.round(userReport.baseExp * PRIMARY_EXP_CARD_ADDITION);
			}

			//初级GP卡
			if(userReport.primaryGpCardFlag)
			{
				userReport.primaryGpCardAddGpRatio = PRIMARY_GP_CARD_ADDITION;
				userReport.primaryGpCardAddGp =  Math.round(userReport.baseGp * PRIMARY_GP_CARD_ADDITION);
			}

			//高级经验卡
			if(userReport.advancedExpCardFlag)
			{
				userReport.advancedExpCardAddExpRatio = ADVANCED_EXP_CARD_ADDITION;
				userReport.advancedExpCardAddExp =  Math.round(userReport.baseExp * ADVANCED_EXP_CARD_ADDITION);
			}

			//高级GP卡
			if(userReport.advancedGpCardFlag)
			{
				userReport.advancedGpCardAddGpRatio = ADVANCED_GP_CARD_ADDITION;
				userReport.advancedGpCardAddGp =  Math.round(userReport.baseGp * ADVANCED_GP_CARD_ADDITION);
			}

			//饰品
			userReport.decorationAddExpRatio = userReport.expDecoration;
			userReport.decorationAddExp = Math.round(userReport.baseExp * userReport.expDecoration);
			userReport.decorationAddGpRatio = userReport.gpDecoration;
			userReport.decorationAddGp = Math.round(userReport.baseGp * userReport.gpDecoration);
		}
	}

	private static void addExpForTeamAndFriend(BattleReport battleReport)
	{
		for (UserReport userReport : battleReport.userReportList)
		{
			userReport.teamAndFriendAddExpRatio = 0;

			for (UserReport otherUserReport : battleReport.userReportList)
			{
				if(userReport != otherUserReport && userReport.dId == otherUserReport.dId && ((userReport.teamId > 0 && userReport.teamId == otherUserReport.teamId) || (userReport.friendList != null && userReport.friendList.contains(otherUserReport.characterId))))
				{
					userReport.teamAndFriendAddExpRatio += 0.1;

					if(userReport.teamAndFriendAddExpRatio >= 0.5)
					{
						break;
					}
				}
			}

			userReport.teamAndFriendAddExp = Math.round(userReport.baseExp * userReport.teamAndFriendAddExpRatio);
		}
	}

	private static  void addGpAndExpForWeapon(BattleReport battleReport)
	{
		float maxAddExp = 0;
		float maxAddGp = 0;

		for (UserReport userReport : battleReport.userReportList)
		{
			maxAddExp = Math.max(maxAddExp, userReport.weaponOtherAddExp);
			maxAddGp = Math.max(maxAddGp, userReport.weaponOtherAddGp);
		}

		for (UserReport userReport : battleReport.userReportList)
		{
			if (maxAddExp < userReport.weaponSelfAddExp)
			{
				userReport.heroWeaponAddExpRatio = userReport.weaponSelfAddExp;
				userReport.heroWeaponAddExp = Math.round(userReport.baseExp * userReport.weaponSelfAddExp);
				
			}
			else
			{
				userReport.heroWeaponAddExpRatio = maxAddExp;
				userReport.heroWeaponAddExp = Math.round(userReport.baseExp * maxAddExp);
			}
			
			if(maxAddGp < userReport.weaponSelfAddGp)
			{
				userReport.heroWeaponAddGpRatio = userReport.weaponSelfAddGp;
				userReport.heroWeaponAddGp = Math.round(userReport.baseGp * userReport.weaponSelfAddGp);
			}
			else
			{
				userReport.heroWeaponAddGpRatio = maxAddGp;
				userReport.heroWeaponAddGp = Math.round(userReport.baseGp * maxAddGp);
			}
		}
	}
}
