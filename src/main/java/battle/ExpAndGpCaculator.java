package battle;

import netdata.BattleReport;
import netdata.MultiCampaignData;
import netdata.UserReport;
import netdata.roomdata.Rule;

import java.util.*;

public class ExpAndGpCaculator
{
	private static final double PRIMARY_EXP_CARD_ADDITION = 0.3;    //初级经验卡加成
	private static final double PRIMARY_GP_CARD_ADDITION = 0.3;     //初级GP卡加成
	private static final double ADVANCED_EXP_CARD_ADDITION = 0.6;   //高级经验卡加成
	private static final double ADVANCED_GP_CARD_ADDITION = 0.6;         //高级GP卡加成

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

	public static void calculate(BattleReport battleReport)
	{
		if (battleReport.userReportList.length > 0)
		{
			//过滤掉掉线的用户
			Vector<UserReport> vUserReport = new Vector<UserReport>();
			for (int i = 0; i < battleReport.userReportList.length; i++)
			{
				UserReport u = battleReport.userReportList[i];
				if (!u.historyReport)
				{
					vUserReport.add(u);
				}
			}

			if (vUserReport.size() > 0)
			{
				UserReport[] newUserReport = new UserReport[vUserReport.size()];
				for (int i = 0; i < vUserReport.size(); i++)
				{
					newUserReport[i] = vUserReport.get(i);
				}

				//重新赋值战报
				battleReport.userReportList = newUserReport;

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
			}
		}
	}

	private static void addGpOrExpForAward(BattleReport battleReport)
	{
		for (int i = 0; i < battleReport.userReportList.length; i++)
		{
			UserReport userReport = battleReport.userReportList[i];

			userReport.battleAddExp = 0;
			userReport.battleAddGp = 0;

			//变异战、主宰、幸存、封魔经验加成
			if(Rule.isBioRule(battleReport.roomData.raceType))
			{
				if(userReport.characterId == battleReport.bioAceCharacterId)
				{
					userReport.battleAddExp += 0.25*userReport.baseExp;
				}
				if(userReport.characterId == battleReport.maxInfectionCharacterId)
				{
					userReport.battleAddExp += 0.05*userReport.baseExp;
				}
				if(userReport.characterId == battleReport.maxLiveCharacterId)
				{
					userReport.battleAddExp += 0.05*userReport.baseExp;
				}
			}
			else
			{
				//MVP - 爆破战
				if ((userReport.characterId == battleReport.ctMvpCharacterId || userReport.characterId == battleReport.tMvpCharacterId) &&
					battleReport.roomData.raceType == Rule.EXPLODE)
				{
					userReport.battleAddExp += 0.1 * userReport.baseExp;
				}

				//爆破手 - 爆破战、无限爆破、生死爆破
				if ((userReport.characterId == battleReport.maxHidePackCharacterId || userReport.characterId == battleReport.maxOpenPackCharacterId) &&
					(battleReport.roomData.raceType == Rule.EXPLODE || battleReport.roomData.raceType == Rule.RECREATION_EXPLODE || battleReport.roomData.raceType == Rule.DEATH_EXPLODE))
				{
					userReport.battleAddExp += 0.05 * userReport.baseExp;
				}

				//救助者 - 生死爆破、刀锋战士、死亡竞赛、大头争霸
				if ((userReport.characterId == battleReport.ctNurseCharacterId || userReport.characterId == battleReport.tNurseCharacterId) &&
					(battleReport.roomData.raceType == Rule.BLADE || battleReport.roomData.raceType == Rule.RECREATION_EXPLODE || battleReport.roomData.raceType == Rule.DEATH_MATCH || battleReport.roomData.raceType == Rule.BIG_HEAD))
				{
					userReport.battleAddExp += 0.1 * userReport.baseExp;
				}
				
				//没有阵营的KD王 - 枪王之王、个人战
				if((userReport.characterId == battleReport.kdKingCharacterId) &&
				   (battleReport.roomData.raceType == Rule.KING_OF_GUN || battleReport.roomData.raceType == Rule.PERSONAL))
				{
					userReport.battleAddExp += 0.05 * userReport.baseExp;
				}
				
				//有阵营的KD王 - 爆破战、无限爆破、生死爆破、刀锋战士、死亡竞赛、经典团战、娱乐团战、团队争霸、特殊战、团队枪王
				if ((userReport.characterId == battleReport.ctKdKingCharacterId || userReport.characterId == battleReport.tKdKingCharacterId) &&
					(battleReport.roomData.raceType == Rule.EXPLODE ||battleReport.roomData.raceType == Rule.RECREATION_EXPLODE ||battleReport.roomData.raceType == Rule.DEATH_EXPLODE ||
					 battleReport.roomData.raceType == Rule.BLADE ||battleReport.roomData.raceType == Rule.DEATH_MATCH ||battleReport.roomData.raceType == Rule.GROUP ||
					 battleReport.roomData.raceType == Rule.GROUP_RECHARGE ||battleReport.roomData.raceType == Rule.RECREATION_GROUP ||battleReport.roomData.raceType == Rule.SPECIAL_GROUP ||
					 battleReport.roomData.raceType == Rule.GROUP_KING_OF_GUN))
				{
					userReport.battleAddExp += 0.05 * userReport.baseExp;
				}
				
				//大头终结者 - 大头争霸
				if ((userReport.characterId == battleReport.terminatorCharacterId) &&
					battleReport.roomData.raceType == Rule.BIG_HEAD)
				{
					userReport.battleAddExp += 0.05 * userReport.baseExp;
				}
				
				//大头霸者 - 大头争霸
				if ((userReport.characterId == battleReport.overloadCharacterId) &&
					battleReport.roomData.raceType == Rule.BIG_HEAD)
				{
					userReport.battleAddExp += 0.05 * userReport.baseExp;
				}
				
				//战地医生 - 大头争霸
				if((userReport.characterId == battleReport.ctNurseCharacterId || userReport.characterId == battleReport.tNurseCharacterId) && 
				    battleReport.roomData.raceType == Rule.BIG_HEAD)
				{
					userReport.battleAddExp += 0.05 * userReport.baseExp;
				}

				//ACE - 除变异模式外的所有模式
				if (userReport.characterId == battleReport.aceCharacterId) {
					userReport.battleAddExp += 0.25 * userReport.baseExp;
					userReport.battleAddGp += 0.1 * userReport.baseGp;
				}
			}
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
		for (int i = 0; i < battleReport.userReportList.length; i++)
		{
			UserReport userReport = battleReport.userReportList[i];

			//初级经验卡
			if(userReport.primaryExpCardFlag)
			{
				userReport.primaryExpCardAddExp =  (int)Math.round(userReport.baseExp * PRIMARY_EXP_CARD_ADDITION);
			}

			//初级GP卡
			if(userReport.primaryGpCardFlag)
			{
				userReport.primaryGpCardAddGp =  (int)Math.round(userReport.baseGp * PRIMARY_GP_CARD_ADDITION);
			}

			//高级经验卡
			if(userReport.advancedExpCardFlag)
			{
				userReport.advancedExpCardAddExp =  (int)Math.round(userReport.baseExp * ADVANCED_EXP_CARD_ADDITION);
			}

			//高级GP卡
			if(userReport.advancedGpCardFlag)
			{
				userReport.advancedGpCardAddGp =  (int)Math.round(userReport.baseGp * ADVANCED_GP_CARD_ADDITION);
			}

			//饰品
			userReport.decorationAddExp =  (int)Math.round(userReport.baseExp * userReport.expDecoration);
			userReport.decorationAddGp =  (int)Math.round(userReport.baseGp * userReport.gpDecoration);
		}
	}

	private static void addExpForTeamAndFriend(BattleReport battleReport)
	{
		for (UserReport userReport : battleReport.userReportList)
		{
			double rate = 0;

			for (UserReport otherUserReport : battleReport.userReportList)
			{
				if(userReport != otherUserReport && userReport.dId == otherUserReport.dId && ((userReport.teamId > 0 && userReport.teamId == otherUserReport.teamId) || (userReport.friendList != null && userReport.friendList.contains(otherUserReport.characterId))))
				{
					rate += 0.1;

					if(rate >= 0.5)
					{
						break;
					}
				}
			}

			userReport.teamAndFriendAddExp = (int)Math.round(userReport.baseExp * rate);
		}
	}

	private static  void addGpAndExpForWeapon(BattleReport battleReport)
	{
		double maxAddExp = 0;
		double maxAddGp = 0;

		for (UserReport userReport : battleReport.userReportList)
		{
			maxAddExp = Math.max(maxAddExp, userReport.weaponOtherAddExp);
			maxAddGp = Math.max(maxAddGp, userReport.weaponOtherAddGp);
		}

		for (UserReport userReport : battleReport.userReportList)
		{
			userReport.heroWeaponAddExp = 0;
			userReport.heroWeaponAddGp = 0;
			
			if (userReport.hasHeroWeapon)
			{
				userReport.heroWeaponAddExp += (int) Math.round(userReport.baseExp * userReport.weaponSelfAddExp);
				userReport.heroWeaponAddGp += (int) Math.round(userReport.baseGp * userReport.weaponSelfAddGp);
			}
			else
			{
				userReport.heroWeaponAddExp = (int) Math.round(userReport.baseExp * maxAddExp);
				userReport.heroWeaponAddGp = (int) Math.round(userReport.baseGp * maxAddGp);
			}
		}
	}
}
