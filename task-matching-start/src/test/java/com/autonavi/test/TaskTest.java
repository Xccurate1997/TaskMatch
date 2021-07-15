package com.autonavi.test;


import com.alibaba.excel.EasyExcel;
import com.autonavi.Application;
import com.autonavi.domain.TaskObjInfoDO;
import com.autonavi.service.ConvertUtil;
import com.autonavi.service.TaskObjService;
import com.autonavi.service.util.ConvertUtilImpl;
import com.taobao.pandora.boot.test.junit4.DelegateTo;
import com.taobao.pandora.boot.test.junit4.PandoraBootRunner;


import com.autonavi.domain.ExcelTaskDataVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.autonavi.service.util.TaskExcelListener;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author yc.wzl
 * @date 2021/7/14 - 1:07 下午
 */
@SpringBootTest(classes = {Application.class})
@RunWith(PandoraBootRunner.class)
@DelegateTo(SpringJUnit4ClassRunner.class)
public class TaskTest {
    @Autowired
    private ConvertUtil convertUtil;

    @Autowired
    TaskObjService taskObjService;

    @Autowired
    DataSource dataSource;

    @Test
    public void readTest() {
        String fileName = "任务数据样例.xlsx";
        EasyExcel.read(fileName, ExcelTaskDataVO.class, new TaskExcelListener(convertUtil, taskObjService)).sheet().doRead();
    }

    @Test
    public void importTest() throws SQLException {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("数据库："+dataSource.getConnection());
    }

    @Test
    public void insertTest() {
        TaskObjInfoDO t = new TaskObjInfoDO();
        t.setId(200);
        t.setCity("北京");
        taskObjService.insertTaskById(t);
    }

    @Test
    public void selectTest() {
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        List<TaskObjInfoDO> tasksByIdList = taskObjService.getTasksByIdList(idList);
        for (TaskObjInfoDO taskObjInfoDO : tasksByIdList) {
            System.out.println(taskObjInfoDO);
        }
    }

}
