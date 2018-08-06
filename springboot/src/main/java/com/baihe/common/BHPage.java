package com.baihe.common;

import java.util.List;

/**
 * Created by qk on 2018/8/3.
 */
public class BHPage<T> {
    private List<T> rows;
    private Integer total;

    public List<T> getRows() {
        return rows;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public BHPage() {
        super();
    }
    public BHPage(List<T> rows, Integer total) {
        super();
        this.rows = rows;
        this.total = total;
    }
    @Override
    public String toString() {
        return "BhPage [rows=" + rows + ", total=" + total + "]";
    }
}
