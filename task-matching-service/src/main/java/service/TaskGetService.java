package service;

import damain.TaskObjInfoDO;

import java.util.List;

/**
 * 获取所有任务
 *
 * @author yc.wzl
 * @date 2021/7/13 - 10:26 下午
 */
public interface TaskGetService {
    /**
     * 获取所有有效任务
     * @return
     */
    List<TaskObjInfoDO> getAllTasks();

    /**
     * 根据id获取任务
     * @param idList
     * @return
     */
    List<TaskObjInfoDO> getTasksById(List<Integer> idList);
}
