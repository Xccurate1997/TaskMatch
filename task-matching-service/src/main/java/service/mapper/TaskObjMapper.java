package service.mapper;

import domain.TaskObjInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yc.wzl
 * @date 2021/7/14 - 3:36 下午
 */

public interface TaskObjMapper {
    /**
     * 获取所有任务
     * @return
     */
    List<TaskObjInfoDO> getAllTasks();

    /**
     * 根据id集合获取任务
     * @param idList
     * @return
     */
    List<TaskObjInfoDO> getTasksByIdList(List<Integer> idList);

    /**
     * 通过id集合修改任务属性
     *
     * @param idList
     */
    void updateTasksByIdList(List<Integer> idList);

    /**
     * 通过id插入任务数据
     *
     * @param taskObjInfoDO
     */
    void insertTaskById(TaskObjInfoDO taskObjInfoDO);
}
