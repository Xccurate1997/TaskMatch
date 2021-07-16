package com.autonavi.service;

import com.autonavi.domain.HumanObjInfoDO;
import com.autonavi.domain.TaskObjInfoDO;

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
    List<TaskObjInfoDO> match(HumanObjInfoDO humanObjInfoDO);
}
