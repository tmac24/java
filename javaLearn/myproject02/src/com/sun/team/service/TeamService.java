package com.sun.team.service;

import com.sun.team.domain.Architect;
import com.sun.team.domain.Designer;
import com.sun.team.domain.Employee;
import com.sun.team.domain.Programer;

/**
 * @program: basic-code
 * @description: 开发团队成员的管理：添加，删除
 * @author: tmac24
 * @create: 2021-01-25 10:35
 */
public class TeamService {

    private static int counter = 1;//给memberID赋值
    private final int MAX_MENBER = 5;
    private Programer[] team = new Programer[MAX_MENBER];
    private int total;//记录开发团队中实际的人数

    public TeamService() {
        super();
    }

    public Programer[] getTeam() {
        Programer[] team = new Programer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        //成员已满，无法添加
        if (total >= MAX_MENBER) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if (isExist(e)) {
            throw new TeamException("该成员已在本开发团队中");
        }

        Programer p = (Programer) e;//一定不会出现类型异常
        if ("BUSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("该成员已是某团队成员");
        } else if ("VOCATION".equals(p.getStatus().getNAME())) {
            throw new TeamException("该成员正在休假，无法添加");
        }

        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Programer) {
                numOfPro++;
            }
        }

        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        //将p(e)添加到现有的team中
        team[total++] = p;
        //p属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberID) {
//p398
    }
}
