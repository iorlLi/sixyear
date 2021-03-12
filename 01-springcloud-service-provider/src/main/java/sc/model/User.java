package sc.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {
    @TableField(exist = false)
    private String name;
    /*
    所有部署表字段的属性，使用mybais plus时候都要加 上此注解
     */
    @TableField(exist = false)
    private String addr;

    private Long id;
    private Integer age;
    private String email;
    private String mz;
}
