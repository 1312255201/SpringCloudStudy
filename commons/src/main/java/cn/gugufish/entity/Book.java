package cn.gugufish.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("db_book")
public class Book {
    @TableId(type = IdType.AUTO)
    int bid;
    String title;
    String bDesc;
}