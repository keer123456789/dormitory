package com.keer.dormitory.core.model;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据对象
 * @author Bob
 * @since 2021-01-22
 */
public class PageData<T> implements Serializable {
    /** 列表数据 */
    private List<T> rows;
    /** 总记录数 */
    private long total;
    /** 当前页 */
    private long current;

    public PageData(){}

    public PageData(List<T> rows, long total, long current) {
        this.rows = rows;
        this.total = total;
        this.current = current;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "PageData{" +
                "rows=" + rows +
                ", total=" + total +
                ", current=" + current +
                '}';
    }
}
