package com.ruoyi.system.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.SafeTest;

/**
 * 测试Service接口
 * 
 * @author ruoyi
 * @date 2022-03-11
 */
public interface ISafeTestService extends IService<SafeTest>
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
     * 批量删除测试
     * 
     * @param names 需要删除的测试主键集合
     * @return 结果
     */
    public int deleteSafeTestByNames(String[] names);

    /**
     * 删除测试信息
     * 
     * @param name 测试主键
     * @return 结果
     */
    public int deleteSafeTestByName(String name);
}
