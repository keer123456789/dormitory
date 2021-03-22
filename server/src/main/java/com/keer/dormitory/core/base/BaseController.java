package com.keer.dormitory.core.base;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keer.dormitory.core.model.PageData;
import com.keer.dormitory.core.model.PageResult;
import com.keer.dormitory.util.ServletUtils;


public class BaseController {

    /**
     * 获取请求分页对象
     *
     * @param <T>
     * @return
     */
    protected <T> Page<T> getPage() {
        int pageNum = ServletUtils.getParameterToInt("pageNum", 1);
        int pageSize = ServletUtils.getParameterToInt("pageSize", 20);
        return new Page<T>(pageNum, pageSize);
    }

    /**
     * 获取请求分页对象
     *
     * @param pageSize 每页大小
     * @param <T>
     * @return
     */
    protected <T> Page<T> getPage(int pageSize) {
        int pageNum = ServletUtils.getParameterToInt("pageNum", 1);
        return new Page<T>(pageNum, pageSize);
    }

    /**
     * 响应返回分页数据结果
     *
     * @param page
     * @return
     */
    protected <T> PageResult<T> pageResult(IPage<?> page) {
        PageData data = new PageData(page.getRecords(), page.getTotal(), page.getCurrent());
        return PageResult.ok(data);
    }
}
