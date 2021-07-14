package damain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 人的属性
 *
 * @author yc.wzl
 * @date 2021/7/13 - 8:43 下午
 */
@Getter
@Setter
@ToString(callSuper = true)
public class HumanObjInfoDO {
    /**
     * 姓名
     */
    private String name;

    /**
     * 具备技能
     */
    private List<Skill> skills;

    @Getter
    @Setter
    @ToString(callSuper = true)
    public static class Skill {
        /**
         * 技能类型
         */
        private String skill;

        /**
         * 掌握程度
         * 0:勉强可做 1:熟练 2:非常熟练
         */
        private Integer level;
    }

}