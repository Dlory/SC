package battle;

import netdata.BattleReport;
import netdata.UserReport;

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
			case ConstantRace.RACE_BAOPO_ID:
				mf = 1;
				break;
			case ConstantRace.RACE_TUANDUI_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_TESHU_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_GEREN_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_BIANYI_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_YINGXIONG_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_WUXIAN_BAOPO_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_QIANGWANG_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_TUANDUI_QIANGWANG_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_YULE_TUANDUI_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_TUANDUI_ZHENGBA_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_SIWANG_JINGSAI_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_SHENGSI_BAOPO_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_DAOFENG_ZHANSHI_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_SHANGJIN_BAOPO_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_ZHONGJI_BIANYI_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_CHAONENG_BIANYI_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_YOULING_BIANYI_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_TAFANG_ID:
				mf = 0;
				break;
			default:
				mf = 0.75;
				break;
		}
		
		if(br.roomData.raceType == ConstantRace.RACE_BIANYI_ID || br.roomData.raceType == ConstantRace.RACE_YINGXIONG_ID || br.roomData.raceType == ConstantRace.RACE_ZHONGJI_BIANYI_ID || br.roomData.raceType == ConstantRace.RACE_CHAONENG_BIANYI_ID || br.roomData.raceType == ConstantRace.RACE_YOULING_BIANYI_ID) 
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
			case ConstantRace.RACE_BAOPO_ID:
				mf = 1;
				break;
			case ConstantRace.RACE_TUANDUI_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_TESHU_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_GEREN_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_BIANYI_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_YINGXIONG_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_WUXIAN_BAOPO_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_QIANGWANG_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_TUANDUI_QIANGWANG_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_YULE_TUANDUI_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_TUANDUI_ZHENGBA_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_SIWANG_JINGSAI_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_SHENGSI_BAOPO_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_DAOFENG_ZHANSHI_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_SHANGJIN_BAOPO_ID:
				mf = 0.9;
				break;
			case ConstantRace.RACE_ZHONGJI_BIANYI_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_CHAONENG_BIANYI_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_YOULING_BIANYI_ID:
				mf = 0.75;
				break;
			case ConstantRace.RACE_TAFANG_ID:
				mf = 0;
				break;
			default:
				mf = 0.75;
				break;
		}
		
		if(br.roomData.raceType == ConstantRace.RACE_BIANYI_ID || br.roomData.raceType == ConstantRace.RACE_YINGXIONG_ID || br.roomData.raceType == ConstantRace.RACE_ZHONGJI_BIANYI_ID || br.roomData.raceType == ConstantRace.RACE_CHAONENG_BIANYI_ID || br.roomData.raceType == ConstantRace.RACE_YOULING_BIANYI_ID) 
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
