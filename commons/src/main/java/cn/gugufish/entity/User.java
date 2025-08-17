package cn.gugufish.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("db_user")
@AllArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    Integer uid;
    String name;
    String sex;
}