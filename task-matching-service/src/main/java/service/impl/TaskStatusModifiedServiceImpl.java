package service.impl;

import domain.TaskObjInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.mapper.TaskObjMapper;
import service.TaskStatusModifiedService;

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
    private TaskObjMapper taskObjMapper;

    private static final Integer VALID_SIGN = 1;

    @Override
    public List<TaskObjInfoDO> setTaskValid(List<TaskObjInfoDO> taskObjInfoDOList) {
        List<Integer> idList = new ArrayList<>();
        for (TaskObjInfoDO r : taskObjInfoDOList) {
            idList.add(r.getId());
        }
        taskObjInfoDOList = taskObjMapper.getTasksByIdList(idList);
        taskObjMapper.updateTasksByIdList(idList);
        List<TaskObjInfoDO> result = taskObjInfoDOList.parallelStream()
                .filter(taskObjInfoDO -> VALID_SIGN.equals(taskObjInfoDO.getValid()))
                .collect(Collectors.toList());
        return result;
    }
}
