package com.huiduw.xshopping.model;

import java.io.Serializable;

public class CartInfo implements Serializable {
    private Long id;

    /**
     * 所属商品
     *
     * @mbg.generated
     */
    private Long goodsid;

    /**
     * 购买数量
     *
     * @mbg.generated
     */
    private Integer count;

    /**
     * 用户等级
     *
     * @mbg.generated
     */
    private Integer userid;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private String createtime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsid=").append(goodsid);
        sb.append(", count=").append(count);
        sb.append(", userid=").append(userid);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}