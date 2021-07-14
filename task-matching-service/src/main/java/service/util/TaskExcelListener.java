package service.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.taobao.unifiedsession.core.json.JSON;
import domain.ExcelTaskDataVO;
import domain.TaskObjInfoDO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import service.ConvertUtil;
import service.mapper.TaskObjMapper;

/**
 * @author yc.wzl
 * @date 2021/7/14 - 12:58 下午
 */
@Log4j2
public class TaskExcelListener extends AnalysisEventListener<ExcelTaskDataVO> {
    @Autowired
    private ConvertUtil convertUtil;

    @Autowired
    private TaskObjMapper taskObjMapper;

    @Override
    public void invoke(ExcelTaskDataVO excelTaskDataVO, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(excelTaskDataVO));
        TaskObjInfoDO taskObjInfoDO = convertUtil.convertToTaskObjInfoDO(excelTaskDataVO);
        taskObjMapper.insertTaskById(taskObjInfoDO);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("解析完成！");
    }
}
