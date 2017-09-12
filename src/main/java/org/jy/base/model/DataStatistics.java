package org.jy.base.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "data_statistics")
public class DataStatistics {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 统计日期
     */
    @Column(name = "count_date")
    private String countDate;

    /**
     * 统计类型 1用户 2学员 3教练 4车辆 5 约课
     */
    @Column(name = "count_type")
    private Integer countType;

    /**
     * 总记录数
     */
    @Column(name = "total_count")
    private Long totalCount;

    /**
     * 当天记录数
     */
    @Column(name = "intraday_count")
    private Long intradayCount;

    /**
     * 备注
     */
    private String remark;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取统计日期
     *
     * @return count_date - 统计日期
     */
    public String getCountDate() {
        return countDate;
    }

    /**
     * 设置统计日期
     *
     * @param countDate 统计日期
     */
    public void setCountDate(String countDate) {
        this.countDate = countDate == null ? null : countDate.trim();
    }

    /**
     * 获取统计类型 1用户 2学员 3教练 4车辆 5 约课
     *
     * @return count_type - 统计类型 1用户 2学员 3教练 4车辆 5 约课
     */
    public Integer getCountType() {
        return countType;
    }

    /**
     * 设置统计类型 1用户 2学员 3教练 4车辆 5 约课
     *
     * @param countType 统计类型 1用户 2学员 3教练 4车辆 5 约课
     */
    public void setCountType(Integer countType) {
        this.countType = countType;
    }

    /**
     * 获取总记录数
     *
     * @return total_count - 总记录数
     */
    public Long getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总记录数
     *
     * @param totalCount 总记录数
     */
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取当天记录数
     *
     * @return intraday_count - 当天记录数
     */
    public Long getIntradayCount() {
        return intradayCount;
    }

    /**
     * 设置当天记录数
     *
     * @param intradayCount 当天记录数
     */
    public void setIntradayCount(Long intradayCount) {
        this.intradayCount = intradayCount;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return created_at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return updated_at
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", countDate=").append(countDate);
        sb.append(", countType=").append(countType);
        sb.append(", totalCount=").append(totalCount);
        sb.append(", intradayCount=").append(intradayCount);
        sb.append(", remark=").append(remark);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append("]");
        return sb.toString();
    }
}