package service;

import domain.TaskObjInfoDO;

import java.util.List;

/**
 * 修改任务有效性
 *
 * @author yc.wzl
 * @date 2021/7/13 - 10:55 下午
 */
public interface TaskStatusModifiedService {
    /**
     * 修改任务有效性
     *
     * @param taskObjInfoDOList
     * @return
     */
    List<TaskObjInfoDO> setTaskValid(List<TaskObjInfoDO> taskObjInfoDOList);
}
