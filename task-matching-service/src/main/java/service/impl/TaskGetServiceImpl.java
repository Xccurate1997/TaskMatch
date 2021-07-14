package service.impl;

import damain.TaskObjInfoDO;
import org.springframework.stereotype.Service;
import service.TaskGetService;

import java.util.List;

/**
 * @author yc.wzl
 * @date 2021/7/13 - 10:35 下午
 */
@Service
public class TaskGetServiceImpl implements TaskGetService {

    @Override
    public List<TaskObjInfoDO> getAllTasks() {
        return null;
    }

    @Override
    public List<TaskObjInfoDO> getTasksById(List<Integer> idList) {
        return null;
    }
}
