package com.ultrapower.alert.alert.core.gather.vo;

import java.util.StringJoiner;

/**
 * @ClassName SearchCondition
 * @Description 前端查询条件
 * @Author wangzhenguang
 * @Date 2020/2/17
 * @Version 1.0
 */
public class SearchCondition {

    private int pageNum;

    private int pageSize;

    private String searchText;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SearchCondition.class.getSimpleName() + "[", "]")
                .add("pageNum=" + pageNum)
                .add("pageSize=" + pageSize)
                .add("searchText='" + searchText + "'")
                .toString();
    }
}
