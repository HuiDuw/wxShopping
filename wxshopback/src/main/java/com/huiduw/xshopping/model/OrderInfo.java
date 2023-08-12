package com.huiduw.xshopping.model;

import java.io.Serializable;

public class OrderInfo implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 订单id
     *
     * @mbg.generated
     */
    private Long orderid;

    /**
     * 总价
     *
     * @mbg.generated
     */
    private Double totalprice;

    /**
     * 所属用户
     *
     * @mbg.generated
     */
    private Long userid;

    /**
     * 用户等级
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     * 联系地址
     *
     * @mbg.generated
     */
    private String linkaddress;

    /**
     * 联系电话
     *
     * @mbg.generated
     */
    private String linkphone;

    /**
     * 联系人
     *
     * @mbg.generated
     */
    private String linkman;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private String createtime;

    /**
     * 订单状态
     *
     * @mbg.generated
     */
    private String state;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLinkaddress() {
        return linkaddress;
    }

    public void setLinkaddress(String linkaddress) {
        this.linkaddress = linkaddress;
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderid=").append(orderid);
        sb.append(", totalprice=").append(totalprice);
        sb.append(", userid=").append(userid);
        sb.append(", level=").append(level);
        sb.append(", linkaddress=").append(linkaddress);
        sb.append(", linkphone=").append(linkphone);
        sb.append(", linkman=").append(linkman);
        sb.append(", createtime=").append(createtime);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}