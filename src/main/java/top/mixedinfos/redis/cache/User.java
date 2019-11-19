package top.mixedinfos.redis.cache;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {
    private Long id;
    private String name = "秦继源";
    private String sex = "男";
    private Integer age;
    private String hobby;
}
