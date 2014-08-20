/*
 * (C) 2012-2013 Wooduan Group.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation.
 * Authors:
 * duty <huahuai009@163.com>
 */
package netdata;

import java.io.Serializable;

/**
 * 战队实体
 * @author duty <huahuai009@163.com>
 */
public class TeamData implements Serializable {
	private static final long serialVersionUID = 1L;
	public int dId = 0; // 区号
	public int teamId = 0;//战队ID
	
	public TeamData(int dId, int teamId) {
		this.dId = dId;
		this.teamId = teamId;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dId;
        result = prime * result + teamId;
        return result;
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TeamData other = (TeamData) obj;
        if (dId != other.dId)
            return false;
        if (teamId != other.teamId)
            return false;
        return true;
    }
}
