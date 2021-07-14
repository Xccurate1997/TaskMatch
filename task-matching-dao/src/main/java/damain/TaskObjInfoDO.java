package damain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 任务属性
 *
 * @author yc.wzl
 * @date 2021/7/13 - 8:42 下午
 */
@Getter
@Setter
@ToString(callSuper = true)
public class TaskObjInfoDO {
    /**
     * 任务id
     */
    private Integer id;

    /**
     * 任务城市
     */
    private String city;

    /**
     * 任务产线
     */
    private String catalog;

    /**
     * 任务类型
     */
    private String flagType;

    /**
     * 需要技能
     */
    private String skill;

    /**
     * 资料接收时间
     */
    private String cltTime;

    /**
     * 资料信息
     */
    private String info;

    /**
     * 是否有效标识
     * 0:无效 1:有效
     */
    private Integer valid;

}