package com.autonavi.service.impl;

import com.autonavi.domain.TaskObjInfoDO;
import com.autonavi.service.TaskObjService;
import com.autonavi.service.TaskStatusModifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yc.wzl
 * @date 2021/7/13 - 10:58 下午
 */
@Service
public class TaskStatusModifiedServiceImpl implements TaskStatusModifiedService {

    @Autowired
    private TaskObjService taskObjService;

    private static final int VALID_SIGN = 1;

    @Override
    public List<TaskObjInfoDO> setTaskValid(List<TaskObjInfoDO> taskObjInfoDOList) {
        List<Integer> idList = new ArrayList<>();
        for (TaskObjInfoDO r : taskObjInfoDOList) {
            idList.add(r.getId());
        }
        List<TaskObjInfoDO> result = new ArrayList<>();
        for (Integer id : idList) {
            int matchRows = taskObjService.updateTaskById(id);
            if (matchRows == VALID_SIGN) {
                TaskObjInfoDO taskObjInfoDO = taskObjService.getTaskById(id);
                result.add(taskObjInfoDO);
            }
        }
        return result;
    }
}
