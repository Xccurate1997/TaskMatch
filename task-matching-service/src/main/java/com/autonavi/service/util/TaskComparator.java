package com.autonavi.service.util;


import com.autonavi.service.ConvertUtil;
import com.autonavi.domain.TaskObjInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Map;

/**
 * 自定义任务排序
 *
 * @author yc.wzl
 * @date 2021/7/13 - 11:52 下午
 */
@Service
public class TaskComparator implements Comparator<TaskObjInfoDO> {
    @Autowired
    private ConvertUtil convertUtil;

    private Map<String, Integer> map;

    public TaskComparator(Map<String, Integer> map) {
        this.map = map;
    }
    @Override
    public int compare(TaskObjInfoDO t1, TaskObjInfoDO t2) {
        if (map.get(t1.getSkill()) > map.get(t2.getSkill())) {
            return -1;
        } else if (map.get(t1.getSkill()) < map.get(t2.getSkill())) {
            return 1;
        } else {
            if (t1.getId() > t2.getId()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
