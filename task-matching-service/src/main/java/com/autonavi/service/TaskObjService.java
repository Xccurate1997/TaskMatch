package com.autonavi.service;

import com.autonavi.service.mapper.TaskObjMapper;
import com.autonavi.domain.TaskObjInfoDO;
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

    public List<TaskObjInfoDO> getTasksByIdList(List<Integer> idList) {
        return taskObjMapper.getTasksByIdList(idList);
    }

    public void updateTasksByIdList(List<Integer> idList) {
        taskObjMapper.updateTasksByIdList(idList);
    }

    public void insertTaskById(TaskObjInfoDO taskObjInfoDO) {
        taskObjMapper.insertTaskById(taskObjInfoDO);
    }
}
