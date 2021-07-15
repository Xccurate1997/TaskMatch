package com.autonavi.test;


import com.alibaba.excel.EasyExcel;
import com.autonavi.Application;
import com.autonavi.domain.HumanObjInfoDO;
import com.autonavi.domain.TaskObjInfoDO;
import com.autonavi.service.ConvertUtil;
import com.autonavi.service.TaskMatchService;
import com.autonavi.service.TaskObjService;
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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


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

    @Autowired
    TaskMatchService taskMatchService;

    @Test
    public void multiHumanTest() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        new Thread(() -> {
            try {
                HumanObjInfoDO h1 = new HumanObjInfoDO();
                h1.setName("张三");
                HumanObjInfoDO.Skill h1Skill = new HumanObjInfoDO.Skill();
                h1Skill.setSkill("电子眼冗余清洗校正内检");
                h1Skill.setLevel(0);
                HumanObjInfoDO.Skill h1Skill1 = new HumanObjInfoDO.Skill();
                h1Skill1.setSkill("电子眼校正（特殊场景）");
                h1Skill1.setLevel(1);


                List<HumanObjInfoDO.Skill> skillList = new ArrayList<>();
                skillList.add(h1Skill);
                skillList.add(h1Skill1);
                h1.setSkills(skillList);

                cyclicBarrier.await();
                List<TaskObjInfoDO> result = taskMatchService.match(h1);
                System.out.println(h1.getName()+" : "+result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }

        }).start();
        new Thread(() -> {
            try {
                HumanObjInfoDO h2 = new HumanObjInfoDO();
                h2.setName("李四");
                HumanObjInfoDO.Skill h2Skill = new HumanObjInfoDO.Skill();
                h2Skill.setSkill("电子眼冗余清洗校正内检");
                h2Skill.setLevel(0);
                HumanObjInfoDO.Skill h2Skill1 = new HumanObjInfoDO.Skill();
                h2Skill1.setSkill("电子眼校正（特殊场景）");
                h2Skill1.setLevel(1);
                HumanObjInfoDO.Skill h2Skill2 = new HumanObjInfoDO.Skill();
                h2Skill2.setSkill("电子眼校正（综合决策）");
                h2Skill2.setLevel(2);

                List<HumanObjInfoDO.Skill> skillList = new ArrayList<>();
                skillList.add(h2Skill);
                skillList.add(h2Skill1);
                skillList.add(h2Skill2);
                h2.setSkills(skillList);

                cyclicBarrier.await();
                List<TaskObjInfoDO> result = taskMatchService.match(h2);
                System.out.println(h2.getName()+" : "+result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }).start();
        new Thread(() -> {
            try {
                HumanObjInfoDO h3 = new HumanObjInfoDO();
                h3.setName("王五");
                HumanObjInfoDO.Skill h1Skill = new HumanObjInfoDO.Skill();
                h1Skill.setSkill("电子眼冗余清洗校正内检");
                h1Skill.setLevel(0);
                HumanObjInfoDO.Skill h1Skill1 = new HumanObjInfoDO.Skill();
                h1Skill1.setSkill("电子眼校正内检");
                h1Skill1.setLevel(1);
                HumanObjInfoDO.Skill h1Skill2 = new HumanObjInfoDO.Skill();
                h1Skill2.setSkill("电子眼校正（特殊场景）-内检");
                h1Skill2.setLevel(1);

                List<HumanObjInfoDO.Skill> skillList = new ArrayList<>();
                skillList.add(h1Skill);
                skillList.add(h1Skill1);
                skillList.add(h1Skill2);
                h3.setSkills(skillList);

                cyclicBarrier.await();
                List<TaskObjInfoDO> result = taskMatchService.match(h3);
                System.out.println(h3.getName()+" : "+result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }

        }).start();
        new Thread(() -> {
            try {
                HumanObjInfoDO h4 = new HumanObjInfoDO();
                h4.setName("赵六");
                HumanObjInfoDO.Skill h1Skill = new HumanObjInfoDO.Skill();
                h1Skill.setSkill("电子眼冗余清洗校正内检");
                h1Skill.setLevel(2);
                HumanObjInfoDO.Skill h1Skill1 = new HumanObjInfoDO.Skill();
                h1Skill1.setSkill("任务不需要的技能");
                h1Skill1.setLevel(2);

                List<HumanObjInfoDO.Skill> skillList = new ArrayList<>();
                skillList.add(h1Skill);
                h4.setSkills(skillList);

                cyclicBarrier.await();
                List<TaskObjInfoDO> result = taskMatchService.match(h4);
                System.out.println(h4.getName()+" : "+result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }

        }).start();
        new Thread(() -> {
            try {
                HumanObjInfoDO h5 = new HumanObjInfoDO();
                h5.setName("朱七");

                cyclicBarrier.await();
                List<TaskObjInfoDO> result = taskMatchService.match(h5);
                System.out.println(h5.getName()+" : "+result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }

        }).start();
        latch.await();
        System.out.println("领取完成！");
    }

    @Test
    public void singleHumanTest() {
        HumanObjInfoDO h1 = new HumanObjInfoDO();
        h1.setName("张三");
        HumanObjInfoDO.Skill h1Skill = new HumanObjInfoDO.Skill();
        h1Skill.setSkill("电子眼校正（特殊场景）");
        h1Skill.setLevel(1);
        List<HumanObjInfoDO.Skill> skillList = new ArrayList<>();
        skillList.add(h1Skill);
        h1.setSkills(skillList);
        List<TaskObjInfoDO> result = taskMatchService.match(h1);
        for (TaskObjInfoDO r : result) {
            System.out.println(r);
        }
    }

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

    @Test
    public void selectAllTest() {
        List<TaskObjInfoDO> result = taskObjService.getAllTasks();
        for (TaskObjInfoDO r : result) {
            System.out.println(r);
        }
    }

    @Test
    public void updateTest() {
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        taskObjService.updateTasksByIdList(idList);
    }
}
