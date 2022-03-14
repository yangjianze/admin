package com.ruoyi.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.SafeTest;

/**
 * 测试Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-11
 */
public interface SafeTestMapper extends BaseMapper<SafeTest>
{
    /**
     * 查询测试
     * 
     * @param name 测试主键
     * @return 测试
     */
    public SafeTest selectSafeTestByName(String name);

    /**
     * 查询测试列表
     * 
     * @param safeTest 测试
     * @return 测试集合
     */
    public List<SafeTest> selectSafeTestList(SafeTest safeTest);

    /**
     * 新增测试
     * 
     * @param safeTest 测试
     * @return 结果
     */
    public int insertSafeTest(SafeTest safeTest);

    /**
     * 修改测试
     * 
     * @param safeTest 测试
     * @return 结果
     */
    public int updateSafeTest(SafeTest safeTest);

    /**
     * 删除测试
     * 
     * @param name 测试主键
     * @return 结果
     */
    public int deleteSafeTestByName(String name);

    /**
     * 批量删除测试
     * 
     * @param names 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSafeTestByNames(String[] names);
}
