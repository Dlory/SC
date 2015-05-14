package battle;

import netdata.BattleReport;
import netdata.UserReport;
import netdata.roomdata.Rule;

public class ExpAndGpCaculator
{
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
}
