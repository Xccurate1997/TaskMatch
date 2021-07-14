package service;

import domain.ExcelTaskDataVO;
import domain.TaskObjInfoDO;

import java.util.Date;

/**
 * 转换数据类型
 *
 * @author yc.wzl
 * @date 2021/7/14 - 2:45 下午
 */
public interface ConvertUtil {
    /**
     * 转换成数据对象
     *
     * @param excelTaskDataVO
     * @return
     */
    TaskObjInfoDO convertToTaskObjInfoDO(ExcelTaskDataVO excelTaskDataVO);

    Date convertToDate(String string);
}
