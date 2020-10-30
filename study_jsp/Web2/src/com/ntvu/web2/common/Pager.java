package com.ntvu.web2.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页显示类
 * @param <T> 对应的业务对象类型
 */
public class Pager<T> {

    /**
     * 当前页码
     */
    private int index;

    /**
     * 每页显示的条数
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 总记录条数
     */
    private int totalRecord;

    private List<T> data;

    public Pager() {
        this.index = 1;
        this.pageSize = 10;
        this.totalPage = 0;
        this.totalRecord = 0;
        this.data = new ArrayList<T>();
    }

    public Pager(int index, int pageSize, int totalPage, int totalRecord, List<T> data) {
        this.index = index;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalRecord = totalRecord;
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
