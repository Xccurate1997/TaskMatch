package com.autonavi.service;

import com.autonavi.domain.TaskObjInfoDO;
import com.autonavi.mapper.TaskObjMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yc.wzl
 * @date 2021/7/15 - 1:00 上午
 */
@Service
public class TaskObjService {
    @Autowired
    TaskObjMapper taskObjMapper;

    public List<TaskObjInfoDO> getAllTasks() {
        return taskObjMapper.getAllTasks();
    }

    public TaskObjInfoDO getTaskById(Integer id) {
        return taskObjMapper.getTaskById(id);
    }

    public List<TaskObjInfoDO> getTasksByIdList(List<Integer> idList) {
        return taskObjMapper.getTasksByIdList(idList);
    }

    public int updateTaskById(Integer id) {
        return taskObjMapper.updateTaskById(id);
    }

    public void updateTasksByIdList(List<Integer> idList) {
        taskObjMapper.updateTasksByIdList(idList);
    }

    public void insertTaskById(TaskObjInfoDO taskObjInfoDO) {
        taskObjMapper.insertTaskById(taskObjInfoDO);
    }

    public List<TaskObjInfoDO> getTasksBySkills(List<String> skills) {
        return taskObjMapper.getTasksBySkills(skills);
    }
}
