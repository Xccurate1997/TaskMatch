package com.autonavi.service.impl;

import com.autonavi.domain.TaskObjInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autonavi.service.TaskObjService;
import com.autonavi.service.TaskStatusModifiedService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yc.wzl
 * @date 2021/7/13 - 10:58 下午
 */
@Service
public class TaskStatusModifiedServiceImpl implements TaskStatusModifiedService {

    @Autowired
    private TaskObjService taskObjService;

    private static final Integer VALID_SIGN = 1;

    @Override
    public List<TaskObjInfoDO> setTaskValid(List<TaskObjInfoDO> taskObjInfoDOList) {
        List<Integer> idList = new ArrayList<>();
        for (TaskObjInfoDO r : taskObjInfoDOList) {
            idList.add(r.getId());
        }
        List<TaskObjInfoDO> result = new ArrayList<>();
        for (Integer id : idList) {
            synchronized (this.getClass()) {
                TaskObjInfoDO task = taskObjService.getTaskById(id);
                if (VALID_SIGN.equals(task.getValid())) {
                    result.add(task);
                    taskObjService.updateTaskById(id);
                    //为了展示效果！
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }
}
