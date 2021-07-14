package service;

import java.util.List;

/**
 * 更新任务数据
 *
 * @author yc.wzl
 * @date 2021/7/14 - 12:58 上午
 */
public interface TaskUpdateService {
    /**
     * 通过id集合修改任务属性
     *
     * @param idList
     */
    void updateTasksByIdList(List<Integer> idList);
}
