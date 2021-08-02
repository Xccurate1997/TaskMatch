package com.autonavi.mapper;

import com.autonavi.domain.TaskObjInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yc.wzl
 * @date 2021/7/14 - 3:36 下午
 */
@Mapper
public interface TaskObjMapper {
    /**
     * 获取所有任务
     * @return List<TaskObjInfoDO>
     */
    List<TaskObjInfoDO> getAllTasks();

    /**
     * 根据id获取任务
     * @param id id
     * @return List<TaskObjInfoDO>
     */
    TaskObjInfoDO getTaskById(Integer id);

    /**
     * 根据id集合获取任务
     * @param idList idList
     * @return List<TaskObjInfoDO>
     */
    List<TaskObjInfoDO> getTasksByIdList(List<Integer> idList);

    /**
     * 通过id修改任务属性
     * @param id id
     * @return 返回匹配上的数目
     */
    int updateTaskById(Integer id);

    /**
     * 通过id集合修改任务属性
     *
     * @param idList idList
     */
    void updateTasksByIdList(List<Integer> idList);

    /**
     * 通过id插入任务数据
     *
     * @param taskObjInfoDO taskObjInfoDO
     */
    void insertTaskById(TaskObjInfoDO taskObjInfoDO);

    /**
     * 通过技能获取任务
     *
     * @param skills skills
     * @return List<TaskObjInfoDO>
     */
    List<TaskObjInfoDO> getTasksBySkills(List<String> skills);
}
