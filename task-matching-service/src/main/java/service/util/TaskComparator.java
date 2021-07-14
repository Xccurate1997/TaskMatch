package service.util;


import damain.TaskObjInfoDO;
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
    private Map<Integer, Integer> map;

    public TaskComparator(Map<Integer, Integer> map) {
        this.map = map;
    }
    @Override
    public int compare(TaskObjInfoDO t1, TaskObjInfoDO t2) {
        if (map.get(t1.getSkill()) > map.get(t2.getSkill())) {
            return -1;
        } else if (map.get(t1.getSkill()) < map.get(t2.getSkill())) {
            return 1;
        } else {
            if (this.getPriorityValue(t1) < this.getPriorityValue(t2)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private long getPriorityValue(TaskObjInfoDO taskObjInfoDO) {
        return taskObjInfoDO.getCltTime().getTime();
    }
}
