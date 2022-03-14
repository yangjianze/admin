package com.ruoyi.system.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SafeTestMapper;
import com.ruoyi.system.domain.SafeTest;
import com.ruoyi.system.service.ISafeTestService;

/**
 * 测试Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-11
 */
@Service
public class SafeTestServiceImpl extends ServiceImpl<SafeTestMapper,SafeTest> implements ISafeTestService
{
    @Autowired
    private SafeTestMapper safeTestMapper;

    /**
     * 查询测试
     * 
     * @param name 测试主键
     * @return 测试
     */
    @Override
    public SafeTest selectSafeTestByName(String name)
    {
        return safeTestMapper.selectSafeTestByName(name);
    }

    /**
     * 查询测试列表
     * 
     * @param safeTest 测试
     * @return 测试
     */
    @Override
    public List<SafeTest> selectSafeTestList(SafeTest safeTest)
    {
        return safeTestMapper.selectSafeTestList(safeTest);
    }

    /**
     * 新增测试
     * 
     * @param safeTest 测试
     * @return 结果
     */
    @Override
    public int insertSafeTest(SafeTest safeTest)
    {
        return safeTestMapper.insertSafeTest(safeTest);
    }

    /**
     * 修改测试
     * 
     * @param safeTest 测试
     * @return 结果
     */
    @Override
    public int updateSafeTest(SafeTest safeTest)
    {
        return safeTestMapper.updateSafeTest(safeTest);
    }

    /**
     * 批量删除测试
     * 
     * @param names 需要删除的测试主键
     * @return 结果
     */
    @Override
    public int deleteSafeTestByNames(String[] names)
    {
        return safeTestMapper.deleteSafeTestByNames(names);
    }

    /**
     * 删除测试信息
     * 
     * @param name 测试主键
     * @return 结果
     */
    @Override
    public int deleteSafeTestByName(String name)
    {
        return safeTestMapper.deleteSafeTestByName(name);
    }
}
