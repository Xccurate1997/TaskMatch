package com.autonavi.service.impl;


import com.autonavi.domain.HumanObjInfoDO;
import com.autonavi.domain.TaskObjInfoDO;
import com.autonavi.service.TaskMatchService;
import com.autonavi.service.TaskObjService;
import com.autonavi.service.TaskStatusModifiedService;
import com.autonavi.service.util.TaskComparator;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yc.wzl
 * @date 2021/7/13 - 8:50 下午
 */
@Service
public class TaskMatchServiceImpl implements TaskMatchService {

    @Autowired
    private TaskObjService taskObjService;

    @Autowired
    private TaskStatusModifiedService taskStatusModifiedService;


    @Override
    public List<TaskObjInfoDO> match(HumanObjInfoDO humanObjInfoDO) {
        if (Objects.isNull(humanObjInfoDO)) {
            return null;
        }
        if (Objects.isNull(humanObjInfoDO.getSkills()) || CollectionUtils.isEmpty(humanObjInfoDO.getSkills())) {
            return new ArrayList<>();
        }
        List<String> skills = getSkills(humanObjInfoDO);
        List<TaskObjInfoDO> taskObjInfoDOList = this.taskObjService.getTasksBySkills(skills);
        Map<String, Integer> map = getSkillMap(humanObjInfoDO);
        TaskComparator taskComparator = new TaskComparator(map);
        taskObjInfoDOList.sort(taskComparator);
        taskObjInfoDOList = this.taskStatusModifiedService.setTaskValid(taskObjInfoDOList);
        return taskObjInfoDOList;
    }

    /**
     * 获得技能熟练度map
     *
     * @param humanObjInfoDO
     * @return
     */
    private Map<String, Integer> getSkillMap(HumanObjInfoDO humanObjInfoDO) {
        Map<String, Integer> result = new HashMap<>(32);
        for (HumanObjInfoDO.Skill skill : humanObjInfoDO.getSkills()) {
            result.put(skill.getSkill(), skill.getLevel());
        }
        return result;
    }


    /**
     * 获取人的技能
     *
     * @param humanObjInfoDO
     * @return
     */
    private List<String> getSkills(HumanObjInfoDO humanObjInfoDO) {
        if (Objects.isNull(humanObjInfoDO)) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        List<HumanObjInfoDO.Skill> list = humanObjInfoDO.getSkills();
        for (HumanObjInfoDO.Skill skill : list) {
           result.add(skill.getSkill());
        }
        return result;
    }
}
