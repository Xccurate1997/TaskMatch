package com.autonavi.service.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.autonavi.service.ConvertUtil;
import com.taobao.unifiedsession.core.json.JSON;
import com.autonavi.domain.ExcelTaskDataVO;
import com.autonavi.domain.TaskObjInfoDO;
import lombok.extern.log4j.Log4j2;
import com.autonavi.service.TaskObjService;
import org.springframework.stereotype.Service;


/**
 * @author yc.wzl
 * @date 2021/7/14 - 12:58 下午
 */
@Log4j2
@Service
public class TaskExcelListener extends AnalysisEventListener<ExcelTaskDataVO> {
    private ConvertUtil convertUtil;
    private TaskObjService taskObjService;

    public TaskExcelListener(ConvertUtil convertUtil, TaskObjService taskObjService) {
        this.convertUtil = convertUtil;
        this.taskObjService = taskObjService;
    }

    @Override
    public void invoke(ExcelTaskDataVO excelTaskDataVO, AnalysisContext analysisContext) {

        TaskObjInfoDO taskObjInfoDO = convertUtil.convertToTaskObjInfoDO(excelTaskDataVO);
        taskObjService.insertTaskById(taskObjInfoDO);
        log.info("解析到一条数据:{}", JSON.toJSONString(excelTaskDataVO));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("解析完成！");
    }
}
