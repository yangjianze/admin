package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测试对象 safe_test
 * 
 * @author ruoyi
 * @date 2022-03-11
 */
@Data
@TableName("safe_test")
public class SafeTest extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 审核内容名称 */
    @Excel(name = "审核内容名称")
    private String name;

    /** 分值 */
    @Excel(name = "分值")
    private BigDecimal score;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String status;
}
