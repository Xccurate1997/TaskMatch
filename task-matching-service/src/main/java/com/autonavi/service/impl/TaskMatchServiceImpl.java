package com.autonavi.service.impl;


import com.autonavi.domain.HumanObjInfoDO;
import com.autonavi.domain.TaskObjInfoDO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autonavi.service.TaskMatchService;
import com.autonavi.service.TaskObjService;
import com.autonavi.service.TaskStatusModifiedService;
import com.autonavi.service.util.TaskComparator;

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

    private static final Integer VALID_SIGN = 1;

    @Override
    public List<TaskObjInfoDO> match(HumanObjInfoDO humanObjInfoDO) {
        if (Objects.isNull(humanObjInfoDO)) {
            return null;
        }
        if (CollectionUtils.isEmpty(humanObjInfoDO.getSkills())) {
            return new ArrayList<>();
        }
        List<TaskObjInfoDO> taskObjInfoDOList = this.taskObjService.getAllTasks();
        Set<String> skills = getSkills(humanObjInfoDO);
        taskObjInfoDOList = this.filterAll(skills, taskObjInfoDOList);
        synchronized (this.getClass()) {
        taskObjInfoDOList = this.taskStatusModifiedService.setTaskValid(taskObjInfoDOList);
        }
        Map<String, Integer> map = getSkillMap(humanObjInfoDO);
        TaskComparator taskComparator = new TaskComparator(map);
        Collections.sort(taskObjInfoDOList, taskComparator);
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
     * 过滤出所有的有效且能匹配的任务
     *
     * @param skills
     * @param taskObjInfoDOList
     * @return
     */
    private List<TaskObjInfoDO> filterAll(Set<String> skills, List<TaskObjInfoDO> taskObjInfoDOList) {
        if (CollectionUtils.isEmpty(taskObjInfoDOList)) {
            return new ArrayList<>();
        }
        List<TaskObjInfoDO> result = taskObjInfoDOList.parallelStream()
                .filter(taskObjInfoDO -> skills.contains(taskObjInfoDO.getSkill()))
                .filter(taskObjInfoDO -> VALID_SIGN.equals(taskObjInfoDO.getValid()))
                .collect(Collectors.toList());
        return result;
    }

    /**
     * 获取人的技能
     *
     * @param humanObjInfoDO
     * @return
     */
    private Set<String> getSkills(HumanObjInfoDO humanObjInfoDO) {
        if (Objects.isNull(humanObjInfoDO)) {
            return new HashSet<>();
        }
        Set<String> result = new HashSet<>();
        List<HumanObjInfoDO.Skill> list = humanObjInfoDO.getSkills();
        for (HumanObjInfoDO.Skill skill : list) {
           result.add(skill.getSkill());
        }
        return result;
    }
}
