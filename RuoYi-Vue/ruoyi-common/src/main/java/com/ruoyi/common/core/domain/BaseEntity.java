package com.ruoyi.common.core.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.SnowFlakeUtil;
import com.sun.org.apache.xerces.internal.impl.dtd.models.DFAContentModel;
import lombok.Data;

/**
 * Entity基类
 * 
 * @author ruoyi
 */
@Data
public class BaseEntity implements Serializable
{

    private static final long serialVersionUID = 1L;

    @TableId
    private String id = SnowFlakeUtil.nextId().toString();
    /** 搜索值 */
    @TableField(exist = false)
    private String searchValue;

    /** 创建者 */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** 更新者 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /** 备注 */
    private String remark;

    /** 逻辑删除 */
//    private Integer delFlag = CommonConstant.STATUS_NORMAL;
    /** 请求参数 */
    @TableField(exist = false)
    private Map<String, Object> params;

    public Map<String, Object> getParams()
    {
        if (params == null)
        {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }
}
