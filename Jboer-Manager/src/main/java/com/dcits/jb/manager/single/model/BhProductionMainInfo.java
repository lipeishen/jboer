package com.dcits.jb.manager.single.model;

import java.util.Date;

public class BhProductionMainInfo {
    private String productionId;

    private String productionName;

    private String productionType;

    private String productionPicUrl;

    private Double productionPrice;

    private String productionSize;

    private String productionColor;

    private String prodctionUsage;

    private String productionMaterial;

    private Long productionStockTotal;

    private Long productionStockRemain;

    private Date productionCreateTime;

    private String productionIsself;

    private String productionSource;

    private Date productionInvalidTime;

    private String productionIssale;

    private String productionIsvalid;

    private String productionDesc;

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId == null ? null : productionId.trim();
    }

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName == null ? null : productionName.trim();
    }

    public String getProductionType() {
        return productionType;
    }

    public void setProductionType(String productionType) {
        this.productionType = productionType == null ? null : productionType.trim();
    }

    public String getProductionPicUrl() {
        return productionPicUrl;
    }

    public void setProductionPicUrl(String productionPicUrl) {
        this.productionPicUrl = productionPicUrl == null ? null : productionPicUrl.trim();
    }

    public Double getProductionPrice() {
        return productionPrice;
    }

    public void setProductionPrice(Double productionPrice) {
        this.productionPrice = productionPrice;
    }

    public String getProductionSize() {
        return productionSize;
    }

    public void setProductionSize(String productionSize) {
        this.productionSize = productionSize == null ? null : productionSize.trim();
    }

    public String getProductionColor() {
        return productionColor;
    }

    public void setProductionColor(String productionColor) {
        this.productionColor = productionColor == null ? null : productionColor.trim();
    }

    public String getProdctionUsage() {
        return prodctionUsage;
    }

    public void setProdctionUsage(String prodctionUsage) {
        this.prodctionUsage = prodctionUsage == null ? null : prodctionUsage.trim();
    }

    public String getProductionMaterial() {
        return productionMaterial;
    }

    public void setProductionMaterial(String productionMaterial) {
        this.productionMaterial = productionMaterial == null ? null : productionMaterial.trim();
    }

    public Long getProductionStockTotal() {
        return productionStockTotal;
    }

    public void setProductionStockTotal(Long productionStockTotal) {
        this.productionStockTotal = productionStockTotal;
    }

    public Long getProductionStockRemain() {
        return productionStockRemain;
    }

    public void setProductionStockRemain(Long productionStockRemain) {
        this.productionStockRemain = productionStockRemain;
    }

    public Date getProductionCreateTime() {
        return productionCreateTime;
    }

    public void setProductionCreateTime(Date productionCreateTime) {
        this.productionCreateTime = productionCreateTime;
    }

    public String getProductionIsself() {
        return productionIsself;
    }

    public void setProductionIsself(String productionIsself) {
        this.productionIsself = productionIsself == null ? null : productionIsself.trim();
    }

    public String getProductionSource() {
        return productionSource;
    }

    public void setProductionSource(String productionSource) {
        this.productionSource = productionSource == null ? null : productionSource.trim();
    }

    public Date getProductionInvalidTime() {
        return productionInvalidTime;
    }

    public void setProductionInvalidTime(Date productionInvalidTime) {
        this.productionInvalidTime = productionInvalidTime;
    }

    public String getProductionIssale() {
        return productionIssale;
    }

    public void setProductionIssale(String productionIssale) {
        this.productionIssale = productionIssale == null ? null : productionIssale.trim();
    }

    public String getProductionIsvalid() {
        return productionIsvalid;
    }

    public void setProductionIsvalid(String productionIsvalid) {
        this.productionIsvalid = productionIsvalid == null ? null : productionIsvalid.trim();
    }

    public String getProductionDesc() {
        return productionDesc;
    }

    public void setProductionDesc(String productionDesc) {
        this.productionDesc = productionDesc == null ? null : productionDesc.trim();
    }
}