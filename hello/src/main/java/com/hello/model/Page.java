package com.hello.model;

import java.util.List;

/**
 * Created by xuan on 2015/12/26.
 */
public class Page <T> {

    private List<T> list;

    private int current;
    private int size;
    private  int pageCount;

    private Long totalCount;

    public Page() {
    }
    public Page(List<T> list, Long totalCount, int pageCount, int size, int current) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageCount = pageCount;
        this.size = size;
        this.current = current;
    }


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPageCount() {
        int totalPage = (int) (getTotalCount() / getSize());
        return (totalCount % size == 0 ? totalPage : totalPage + 1);
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
