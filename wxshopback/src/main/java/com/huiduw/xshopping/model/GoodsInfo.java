package com.huiduw.xshopping.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 商品详情表
 */
@Table(name = "goods_info")
public class GoodsInfo implements Serializable {
    /*说明是主键*/
    @Id
    /*定义生成规则 自增*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品名称
     *
     * @mbg.generated
     */
    @Column(name="name")
    private String name;

    /**
     * 商品价格
     *
     * @mbg.generated
     */
    @Column(name="price")
    private Double price;

    /**
     * 商品折扣
     *
     * @mbg.generated
     */
    @Column(name="discount")
    private Double discount;

    /**
     * 商品销量
     *
     * @mbg.generated
     */
    @Column(name="sales")
    private Integer sales;

    /**
     * 商品点赞数
     *
     * @mbg.generated
     */
    @Column(name="hot")
    private Integer hot;

    /**
     * 是否推荐
     *
     * @mbg.generated
     */
    @Column(name="recommend")
    private String recommend;

    /**
     * 库存
     *
     * @mbg.generated
     */
    @Column(name="count")
    private Integer count;

    /**
     * 商品类别
     *
     * @mbg.generated
     */
    @Column(name="typeid")
    private Long typeid;

    /**
     * 商品图片id，用英文逗号隔开
     *
     * @mbg.generated
     */
    @Column(name="fields")
    private String fields;

    /**
     * 所属卖家
     *
     * @mbg.generated
     */
    @Column(name="userid")
    private Long userid;

    /**
     * 所属卖家等级
     *
     * @mbg.generated
     */
    @Column(name="level")
    private Integer level;

    /**
     * 商品描述
     *
     * @mbg.generated
     */
    @Column(name="description")
    private String description;

    /**
     * 所属类别名称
     */
    @Transient
    private String typeName;

    /**
     * 所属卖家姓名
     */
    @Transient
    private String userName;

    /**
     *  商品图片具体地址列表
     */
    @Transient
    private List<Long> fileList;

    /**
     * 已购买某用户是否已评价
     */
    @Transient
    private String commentStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Long> getFileList() {
        return fileList;
    }

    public void setFileList(List<Long> fileList) {
        this.fileList = fileList;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", discount=").append(discount);
        sb.append(", sales=").append(sales);
        sb.append(", hot=").append(hot);
        sb.append(", recommend=").append(recommend);
        sb.append(", count=").append(count);
        sb.append(", typeid=").append(typeid);
        sb.append(", fields=").append(fields);
        sb.append(", userid=").append(userid);
        sb.append(", level=").append(level);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}