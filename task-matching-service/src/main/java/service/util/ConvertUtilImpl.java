package service.util;

import domain.ExcelTaskDataVO;
import domain.TaskObjInfoDO;
import service.ConvertUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author yc.wzl
 * @date 2021/7/14 - 2:49 下午
 */
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

    @Override
    public Date convertToDate(String string) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        try {
            Date date = format.parse(string);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
