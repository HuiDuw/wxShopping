package com.huiduw.xshopping.model;

import java.io.Serializable;

public class CommentInfo implements Serializable {
    private Long id;

    /**
     * 商品id
     *
     * @mbg.generated
     */
    private Long goodsid;

    /**
     * 评价人id
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
     * 创建时间
     *
     * @mbg.generated
     */
    private String createtime;

    /**
     * 评价内容
     *
     * @mbg.generated
     */
    private String content;

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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsid=").append(goodsid);
        sb.append(", userid=").append(userid);
        sb.append(", level=").append(level);
        sb.append(", createtime=").append(createtime);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}