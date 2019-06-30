package com.mxz.mybatis.query;

import java.util.List;

/**
 * @Description: 分页结果集
 * @Auther: mengxiuze
 * @Date: 2019/6/30 10:49
 */
public class PageResult {

    private List<?> result;// 每一页的结果集
    private int totalCount;// 结果总数

    private int currentPage = 1;// 当前页
    private int pageSize = 10;// 每页最多多少条数据

    private int prevPage;// 上一页
    private int nextPage;// 下一页
    private int totalPage;// 总页数

    public PageResult(List<?> result, int totalCount, int currentPage, int pageSize) {
        this.result = result;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        // 计算出：总页数、上一页、下一页
        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        this.prevPage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
        this.nextPage = currentPage + 1 <= totalPage ? currentPage + 1 : totalPage;

        // 做一个判断，如果当前页大于最后一页
        currentPage = currentPage > totalPage ? totalPage : currentPage;
    }

    public List<?> getResult() {
        return result;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getTotalPage() {
        return totalPage;
    }
}
