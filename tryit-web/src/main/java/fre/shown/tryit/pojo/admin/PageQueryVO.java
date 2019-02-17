package fre.shown.tryit.pojo.admin;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

/**
 * 在{@link fre.shown.tryit.controller.admin.UserMaintainController#pageQuery(Integer, Integer, String)}中使用的VO
 *
 * @author Radon Freedom
 * created at 2019.02.15 19:15
 */

public class PageQueryVO<T> {

    private List <T> dataList;
    private Integer currentPage;
    private Integer totalPageCnt;

    public PageQueryVO() {
    }

    public PageQueryVO(List<T> dataList, Integer currentPage, Integer totalPageCnt) {
        this.dataList = dataList;
        this.currentPage = currentPage;
        this.totalPageCnt = totalPageCnt;
    }

    @Override
    public String toString() {
        return "PageQueryVO{" +
                "dataList=" + dataList +
                ", currentPage=" + currentPage +
                ", totalPageCnt=" + totalPageCnt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PageQueryVO<?> that = (PageQueryVO<?>) o;

        return new EqualsBuilder()
                .append(getDataList(), that.getDataList())
                .append(getCurrentPage(), that.getCurrentPage())
                .append(getTotalPageCnt(), that.getTotalPageCnt())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getDataList())
                .append(getCurrentPage())
                .append(getTotalPageCnt())
                .toHashCode();
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPageCnt() {
        return totalPageCnt;
    }

    public void setTotalPageCnt(Integer totalPageCnt) {
        this.totalPageCnt = totalPageCnt;
    }
}
