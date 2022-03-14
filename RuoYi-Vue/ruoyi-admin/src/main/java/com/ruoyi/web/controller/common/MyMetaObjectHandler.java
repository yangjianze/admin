package com.ruoyi.web.controller.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ruoyi.common.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("插入策略");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("createBy",SecurityUtils.getLoginUser().getUsername(),metaObject);
//        this.strictInsertFill(metaObject, "createTime", LocalDateTime.now(), LocalDateTime.class); // 起始版本 3.3.3(推荐)
//        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.now(), LocalDateTime.class); // 起始版本 3.3.3(推荐)
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("更新策略");
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("updateBy",SecurityUtils.getLoginUser().getUsername(),metaObject);
//        this.strictInsertFill(metaObject, "updateTime", () -> LocalDateTime.now(), LocalDateTime.class); // 起始版本 3.3.3(推荐)
    }
}
