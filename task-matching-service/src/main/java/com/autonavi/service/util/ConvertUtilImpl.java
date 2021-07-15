package com.autonavi.service.util;

import com.autonavi.service.ConvertUtil;
import com.autonavi.domain.ExcelTaskDataVO;
import com.autonavi.domain.TaskObjInfoDO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author yc.wzl
 * @date 2021/7/14 - 2:49 下午
 */
@Service
public class ConvertUtilImpl implements ConvertUtil {
    @Override
    public TaskObjInfoDO convertToTaskObjInfoDO(final ExcelTaskDataVO excelTaskDataVO) {
        if (Objects.isNull(excelTaskDataVO)) {
            return null;
        }
        final TaskObjInfoDO taskObjInfoDO = new TaskObjInfoDO();
        taskObjInfoDO.setId(excelTaskDataVO.getId());
        taskObjInfoDO.setCity(excelTaskDataVO.getCity());
        taskObjInfoDO.setCatalog(excelTaskDataVO.getCatalog());
        taskObjInfoDO.setFlagType(excelTaskDataVO.getFlagType());
        taskObjInfoDO.setSkill(excelTaskDataVO.getSkill());
        taskObjInfoDO.setCltTime(excelTaskDataVO.getCltTime());
        taskObjInfoDO.setInfo(excelTaskDataVO.getInfo());
        taskObjInfoDO.setValid(excelTaskDataVO.getValid());
        return taskObjInfoDO;
    }

}
