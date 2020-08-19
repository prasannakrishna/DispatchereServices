package com.by.dispatcherserver.dispatcherService.model;

import java.io.Serializable;
import javax.persistence.*;

import com.by.dispatcherserver.dispatcherService.library.SelectExpression;

import java.math.BigDecimal;

/**
 * The persistent class for the SKU_TUC database table.
 * 
 */
@Table(name = "SKU_TUC st")
public class SKUTucDO implements Serializable {

	@SelectExpression(Value ="tuc")
	@Column(name = "TUC")
	private String tuc;

	@Column(name = "client_id")
	@SelectExpression(Value ="Client_id")
	private String clientId;

	@Column(name = "CONFIG_ID")
	@SelectExpression(Value ="config_id")
	private String configId;

	@SelectExpression(Value ="quantity")
	private BigDecimal quantity;

	@Column(name = "SKU_ID")
	@SelectExpression(Value ="sku_id")
	private String skuId;

	@Column(name = "TRACKING_LEVEL")
	@SelectExpression(Value ="tracking_level")
	private String trackingLevel;

	@Column(name = "TUC_DESCRIPTION")
	@SelectExpression(Value ="TUC_DESCRIPTION")
	private String tucDescription;
	
	@SelectExpression(Value ="libsku.getuserlangskudesc(st.client_id,st.sku_id)")
	private String SkuDescription;
	public SKUTucDO() {
	}

	public String getTuc() {
		return this.tuc;
	}

	public void setTuc(String tuc) {
		this.tuc = tuc;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getConfigId() {
		return this.configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getSkuId() {
		return this.skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getTrackingLevel() {
		return this.trackingLevel;
	}

	public void setTrackingLevel(String trackingLevel) {
		this.trackingLevel = trackingLevel;
	}

	public String getTucDescription() {
		return this.tucDescription;
	}

	public void setTucDescription(String tucDescription) {
		this.tucDescription = tucDescription;
	}

	public String getSkuDescription() {
		return SkuDescription;
	}

	public void setSkuDescription(String skuDescription) {
		SkuDescription = skuDescription;
	}

}