package task.test;


import com.alibaba.excel.EasyExcel;
import com.taobao.pandora.boot.test.junit4.DelegateTo;
import com.taobao.pandora.boot.test.junit4.PandoraBootRunner;


import domain.ExcelTaskDataVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.util.TaskExcelListener;


/**
 * @author yc.wzl
 * @date 2021/7/14 - 1:07 下午
 */
@RunWith(PandoraBootRunner.class)
@DelegateTo(SpringJUnit4ClassRunner.class)
public class TaskTest {

    @Test
    public void readTest() {
        String fileName = "任务数据样例.xlsx";
        EasyExcel.read(fileName, ExcelTaskDataVO.class, new TaskExcelListener()).sheet().doRead();
    }

}
