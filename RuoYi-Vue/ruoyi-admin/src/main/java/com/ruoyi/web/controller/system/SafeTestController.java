package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SafeTest;
import com.ruoyi.system.service.ISafeTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 测试Controller
 * 
 * @author ruoyi
 * @date 2022-03-11
 */
@RestController
@RequestMapping("/system/test")
public class SafeTestController extends BaseController
{
    @Autowired
    private ISafeTestService safeTestService;

    /**
     * 查询测试列表
     */
    @PreAuthorize("@ss.hasPermi('system:test:list')")
    @GetMapping("/list")
    public TableDataInfo list(SafeTest safeTest)
    {
        startPage();
        List<SafeTest> list = safeTestService.selectSafeTestList(safeTest);

        return getDataTable(list);
    }

    /**
     * 导出测试列表
     */
    @PreAuthorize("@ss.hasPermi('system:test:export')")
    @Log(title = "测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SafeTest safeTest)
    {
        List<SafeTest> list = safeTestService.selectSafeTestList(safeTest);
        ExcelUtil<SafeTest> util = new ExcelUtil<SafeTest>(SafeTest.class);
        util.exportExcel(response, list, "测试数据");
    }

    /**
     * 获取测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:test:query')")
    @GetMapping(value = "/{name}")
    public AjaxResult getInfo(@PathVariable("name") String name)
    {
        return AjaxResult.success(safeTestService.selectSafeTestByName(name));
    }

    /**
     * 新增测试
     */
    @PreAuthorize("@ss.hasPermi('system:test:add')")
    @Log(title = "测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SafeTest safeTest)
    {
//        return toAjax(safeTestService.insertSafeTest(safeTest));
        if (safeTestService.saveOrUpdate(safeTest)){
            return toAjax(safeTest);
        }
        return toAjax(false);
    }

    /**
     * 修改测试
     */
    @PreAuthorize("@ss.hasPermi('system:test:edit')")
    @Log(title = "测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SafeTest safeTest)
    {
        return toAjax(safeTestService.updateSafeTest(safeTest));
    }

    /**
     * 删除测试
     */
    @PreAuthorize("@ss.hasPermi('system:test:remove')")
    @Log(title = "测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{names}")
    public AjaxResult remove(@PathVariable String[] names)
    {
        return toAjax(safeTestService.deleteSafeTestByNames(names));
    }
}
