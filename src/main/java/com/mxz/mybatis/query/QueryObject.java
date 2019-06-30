package com.mxz.mybatis.query;

/**
 * @Description: qo公共代码抽取
 * @Auther: mengxiuze
 * @Date: 2019/6/30 11:19
 */
public class QueryObject {
    // 分页查询的当前页以及每页最大条数，默认值分别为1和10
    private int currentPage = 1;
    private int pageSize = 10;

    // 分页查询limit中的start：LIMIT start, pageSize
    public int getStart(){
        return (currentPage - 1) * pageSize;
    }

    // 如果字符串为空串，也应该设置为null，这样SQL中就不用再判断 if test="keyword != ''"
    String empty2null(String str){
        return hasLength(str) ? str : null;
    }

    private boolean hasLength(String str){
        return str != null && !"".equals(str.trim());
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
