package service;

import domain.HumanObjInfoDO;
import domain.TaskObjInfoDO;

import java.util.List;

/**
 * @author yc.wzl
 * @date 2021/7/13 - 8:49 下午
 */
public interface TaskMatchService {
    /**
     * 匹配任务
     * @param humanObjInfoDO
     * @return
     */
    public List<TaskObjInfoDO> match(HumanObjInfoDO humanObjInfoDO);
}
