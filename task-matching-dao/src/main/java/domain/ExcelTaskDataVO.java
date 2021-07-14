package domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 读取任务对象
 *
 * @author yc.wzl
 * @date 2021/7/14 - 11:46 上午
 */
@Getter
@Setter
@ToString(callSuper = true)
public class ExcelTaskDataVO {
    @ExcelProperty("城市")
    private String city;

    @ExcelProperty("产线")
    private String catalog;

    @ExcelProperty("任务类型")
    private String flagType;

    @ExcelProperty("技能")
    private String skill;

    @ExcelProperty("资料接收时间")
    private String cltTime;

    @ExcelProperty("资料信息")
    private String info;

    @ExcelProperty("有效")
    private Integer valid;

    @ExcelProperty("id")
    private Integer id;

}
