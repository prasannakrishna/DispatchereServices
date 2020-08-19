package com.by.dispatcherserver.dispatcherService.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.by.dispatcherserver.dispatcherService.library.SelectExpression;

/**
 * The persistent class for the INVENTORY database table.
 * 
 */
@Entity
@Table(name ="Inventory")
public class InventoryDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "\"KEY\"")
	@SelectExpression(Value = "Key")
	private long key;
	
	@SelectExpression(Value = "libconfig.getlowesttrackinglevel(client_id, sku_id)")
	@Column(name = "CONFIG_ID")
	private String configId;
	
	@SelectExpression(Value = "Key")
	@Column(name = "timestamp")
	private Timestamp abLastTransDstamp;
	@SelectExpression(Value = "Key")
	@Column(name = "batch_id")
	private String batchId;
	@SelectExpression(Value = "Key")
	@Column(name = "BEAM_END_UNIT")
	private BigDecimal beamEndUnit;
	@SelectExpression(Value = "Key")
	@Column(name = "BEAM_ID")
	private String beamId;

	@Column(name = "BEAM_START_UNIT")
	private BigDecimal beamStartUnit;

	@Column(name = "BREAKPACK_DONE")
	private String breakpackDone;

	@Column(name = "CE_AVAIL_STATUS")
	private String ceAvailStatus;

	@Column(name = "CE_CONSIGNMENT_ID")
	private String ceConsignmentId;

	@Column(name = "CE_COO")
	private String ceCoo;

	@Column(name = "CE_CWC")
	private String ceCwc;

	@Column(name = "CE_DOCUMENT_DSTAMP")
	private Timestamp ceDocumentDstamp;

	@Column(name = "CE_DUTY_STAMP")
	private String ceDutyStamp;

	@Column(name = "CE_INVOICE_NUMBER")
	@Value(value = "")
	private String ceInvoiceNumber;

	@Column(name = "CE_ORIGINATOR")
	private String ceOriginator;

	@Column(name = "CE_ORIGINATOR_REFERENCE")
	private String ceOriginatorReference;

	@Column(name = "CE_RECEIPT_TYPE")
	private String ceReceiptType;

	@Column(name = "CE_ROTATION_ID")
	private String ceRotationId;

	@Column(name = "CE_UCR")
	private String ceUcr;

	@Column(name = "CE_UNDER_BOND")
	private String ceUnderBond;

	@Column(name = "CLIENT_ID")
	private String clientId;

	@Column(name = "CONDITION_ID")
	private String conditionId;
	

	@Column(name = "CONTAINER_ID")
	private String containerId;

	@Column(name = "COUNT_DSTAMP")
	private Timestamp countDstamp;

	@Column(name = "COUNT_NEEDED")
	private String countNeeded;

	@Column(name = "CREATED_INVENTORY")
	private String createdInventory;

	private String description;

	@Column(name = "DISALLOW_ALLOC")
	private String disallowAlloc;

	@Column(name = "ENTERED_HEIGHT")
	private BigDecimal enteredHeight;

	private String expired;

	@Column(name = "EXPIRY_DSTAMP")
	private Timestamp expiryDstamp;

	@Column(name = "FROM_SITE_ID")
	private String fromSiteId;

	@Column(name = "FULL_PALLET")
	private String fullPallet;

	@Column(name = "LINE_ID")
	private BigDecimal lineId;

	@Column(name = "LOCATION_ID")
	private String locationId;

	@Column(name = "LOCK_CODE")
	private String lockCode;

	@Column(name = "LOCK_STATUS")
	private String lockStatus;

	@Column(name = "MANUF_DSTAMP")
	private Timestamp manufDstamp;

	@Column(name = "MOVE_DSTAMP")
	private Timestamp moveDstamp;

	@Column(name = "NEXT_SAMPLING_ACTION")
	private String nextSamplingAction;

	private String notes;

	@Column(name = "ORIGIN_ID")
	private String originId;

	@Column(name = "\"OUTER\"")
	private String outer;

	@Column(name = "OWNER_ID")
	private String ownerId;

	@Column(name = "PALLET_CONFIG")
	private String palletConfig;

	@Column(name = "PALLET_DEPTH")
	private BigDecimal palletDepth;

	@Column(name = "PALLET_HEIGHT")
	private BigDecimal palletHeight;

	@Column(name = "PALLET_ID")
	private String palletId;

	@Column(name = "PALLET_VOLUME")
	private BigDecimal palletVolume;

	@Column(name = "PALLET_WEIGHT")
	private BigDecimal palletWeight;

	@Column(name = "PALLET_WIDTH")
	private BigDecimal palletWidth;

	@Column(name = "PICK_FACE")
	private String pickFace;

	@Column(name = "PRE_RECEIVED")
	private String preReceived;

	@Column(name = "QC_STATUS")
	private String qcStatus;

	@Column(name = "QTY_ALLOCATED")
	private BigDecimal qtyAllocated;

	@Column(name = "QTY_ON_HAND")
	private BigDecimal qtyOnHand;

	@Column(name = "RECEIPT_DSTAMP")
	private Timestamp receiptDstamp;

	@Column(name = "RECEIPT_ID")
	private String receiptId;

	@Column(name = "RECEIPT_TYPE")
	private String receiptType;

	private String sampled;

	@Column(name = "SAMPLING_TYPE")
	private String samplingType;

	@Column(name = "SITE_ID")
	private String siteId;

	@Column(name = "SKU_ID")
	private String skuId;

	@Column(name = "SPEC_CODE")
	private String specCode;

	@Column(name = "SUPPLIER_ID")
	private String supplierId;

	@Column(name = "TAG_ID")
	private String tagId;

	@Column(name = "TO_SITE_ID")
	private String toSiteId;

	@Column(name = "UNKIT_SEQUENCE")
	private BigDecimal unkitSequence;

	@Column(name = "USER_DEF_CHK_1")
	private String userDefChk1;

	@Column(name = "USER_DEF_CHK_2")
	private String userDefChk2;

	@Column(name = "USER_DEF_CHK_3")
	private String userDefChk3;

	@Column(name = "USER_DEF_CHK_4")
	private String userDefChk4;

	@Column(name = "USER_DEF_DATE_1")
	private Timestamp userDefDate1;

	@Column(name = "USER_DEF_DATE_2")
	private Timestamp userDefDate2;

	@Column(name = "USER_DEF_DATE_3")
	private Timestamp userDefDate3;

	@Column(name = "USER_DEF_DATE_4")
	private Timestamp userDefDate4;

	@Column(name = "USER_DEF_NOTE_1")
	private String userDefNote1;

	@Column(name = "USER_DEF_NOTE_2")
	private String userDefNote2;

	@Column(name = "USER_DEF_NUM_1")
	private BigDecimal userDefNum1;

	@Column(name = "USER_DEF_NUM_2")
	private BigDecimal userDefNum2;

	@Column(name = "USER_DEF_NUM_3")
	private BigDecimal userDefNum3;

	@Column(name = "USER_DEF_NUM_4")
	private BigDecimal userDefNum4;

	@Column(name = "USER_DEF_TYPE_1")
	private String userDefType1;

	@Column(name = "USER_DEF_TYPE_2")
	private String userDefType2;

	@Column(name = "USER_DEF_TYPE_3")
	private String userDefType3;

	@Column(name = "USER_DEF_TYPE_4")
	private String userDefType4;

	@Column(name = "USER_DEF_TYPE_5")
	private String userDefType5;

	@Column(name = "USER_DEF_TYPE_6")
	private String userDefType6;

	@Column(name = "USER_DEF_TYPE_7")
	private String userDefType7;

	@Column(name = "USER_DEF_TYPE_8")
	private String userDefType8;

	@Column(name = "ZONE_1")
	private String zone1;

	public InventoryDO() {
	}

	public long getKey() {
		return this.key;
	}

	public void setKey(long key) {
		this.key = key;
	}

	public Timestamp getAbLastTransDstamp() {
		return this.abLastTransDstamp;
	}

	public void setAbLastTransDstamp(Timestamp abLastTransDstamp) {
		this.abLastTransDstamp = abLastTransDstamp;
	}

	public String getBatchId() {
		return this.batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public BigDecimal getBeamEndUnit() {
		return this.beamEndUnit;
	}

	public void setBeamEndUnit(BigDecimal beamEndUnit) {
		this.beamEndUnit = beamEndUnit;
	}

	public String getBeamId() {
		return this.beamId;
	}

	public void setBeamId(String beamId) {
		this.beamId = beamId;
	}

	public BigDecimal getBeamStartUnit() {
		return this.beamStartUnit;
	}

	public void setBeamStartUnit(BigDecimal beamStartUnit) {
		this.beamStartUnit = beamStartUnit;
	}

	public String getBreakpackDone() {
		return this.breakpackDone;
	}

	public void setBreakpackDone(String breakpackDone) {
		this.breakpackDone = breakpackDone;
	}

	public String getCeAvailStatus() {
		return this.ceAvailStatus;
	}

	public void setCeAvailStatus(String ceAvailStatus) {
		this.ceAvailStatus = ceAvailStatus;
	}

	public String getCeConsignmentId() {
		return this.ceConsignmentId;
	}

	public void setCeConsignmentId(String ceConsignmentId) {
		this.ceConsignmentId = ceConsignmentId;
	}

	public String getCeCoo() {
		return this.ceCoo;
	}

	public void setCeCoo(String ceCoo) {
		this.ceCoo = ceCoo;
	}

	public String getCeCwc() {
		return this.ceCwc;
	}

	public void setCeCwc(String ceCwc) {
		this.ceCwc = ceCwc;
	}

	public Timestamp getCeDocumentDstamp() {
		return this.ceDocumentDstamp;
	}

	public void setCeDocumentDstamp(Timestamp ceDocumentDstamp) {
		this.ceDocumentDstamp = ceDocumentDstamp;
	}

	public String getCeDutyStamp() {
		return this.ceDutyStamp;
	}

	public void setCeDutyStamp(String ceDutyStamp) {
		this.ceDutyStamp = ceDutyStamp;
	}

	public String getCeInvoiceNumber() {
		return this.ceInvoiceNumber;
	}

	public void setCeInvoiceNumber(String ceInvoiceNumber) {
		this.ceInvoiceNumber = ceInvoiceNumber;
	}

	public String getCeOriginator() {
		return this.ceOriginator;
	}

	public void setCeOriginator(String ceOriginator) {
		this.ceOriginator = ceOriginator;
	}

	public String getCeOriginatorReference() {
		return this.ceOriginatorReference;
	}

	public void setCeOriginatorReference(String ceOriginatorReference) {
		this.ceOriginatorReference = ceOriginatorReference;
	}

	public String getCeReceiptType() {
		return this.ceReceiptType;
	}

	public void setCeReceiptType(String ceReceiptType) {
		this.ceReceiptType = ceReceiptType;
	}

	public String getCeRotationId() {
		return this.ceRotationId;
	}

	public void setCeRotationId(String ceRotationId) {
		this.ceRotationId = ceRotationId;
	}

	public String getCeUcr() {
		return this.ceUcr;
	}

	public void setCeUcr(String ceUcr) {
		this.ceUcr = ceUcr;
	}

	public String getCeUnderBond() {
		return this.ceUnderBond;
	}

	public void setCeUnderBond(String ceUnderBond) {
		this.ceUnderBond = ceUnderBond;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getConditionId() {
		return this.conditionId;
	}

	public void setConditionId(String conditionId) {
		this.conditionId = conditionId;
	}

	public String getConfigId() {
		return this.configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public String getContainerId() {
		return this.containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public Timestamp getCountDstamp() {
		return this.countDstamp;
	}

	public void setCountDstamp(Timestamp countDstamp) {
		this.countDstamp = countDstamp;
	}

	public String getCountNeeded() {
		return this.countNeeded;
	}

	public void setCountNeeded(String countNeeded) {
		this.countNeeded = countNeeded;
	}

	public String getCreatedInventory() {
		return this.createdInventory;
	}

	public void setCreatedInventory(String createdInventory) {
		this.createdInventory = createdInventory;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisallowAlloc() {
		return this.disallowAlloc;
	}

	public void setDisallowAlloc(String disallowAlloc) {
		this.disallowAlloc = disallowAlloc;
	}

	public BigDecimal getEnteredHeight() {
		return this.enteredHeight;
	}

	public void setEnteredHeight(BigDecimal enteredHeight) {
		this.enteredHeight = enteredHeight;
	}

	public String getExpired() {
		return this.expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}

	public Timestamp getExpiryDstamp() {
		return this.expiryDstamp;
	}

	public void setExpiryDstamp(Timestamp expiryDstamp) {
		this.expiryDstamp = expiryDstamp;
	}

	public String getFromSiteId() {
		return this.fromSiteId;
	}

	public void setFromSiteId(String fromSiteId) {
		this.fromSiteId = fromSiteId;
	}

	public String getFullPallet() {
		return this.fullPallet;
	}

	public void setFullPallet(String fullPallet) {
		this.fullPallet = fullPallet;
	}

	public BigDecimal getLineId() {
		return this.lineId;
	}

	public void setLineId(BigDecimal lineId) {
		this.lineId = lineId;
	}

	public String getLocationId() {
		return this.locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLockCode() {
		return this.lockCode;
	}

	public void setLockCode(String lockCode) {
		this.lockCode = lockCode;
	}

	public String getLockStatus() {
		return this.lockStatus;
	}

	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}

	public Timestamp getManufDstamp() {
		return this.manufDstamp;
	}

	public void setManufDstamp(Timestamp manufDstamp) {
		this.manufDstamp = manufDstamp;
	}

	public Timestamp getMoveDstamp() {
		return this.moveDstamp;
	}

	public void setMoveDstamp(Timestamp moveDstamp) {
		this.moveDstamp = moveDstamp;
	}

	public String getNextSamplingAction() {
		return this.nextSamplingAction;
	}

	public void setNextSamplingAction(String nextSamplingAction) {
		this.nextSamplingAction = nextSamplingAction;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOriginId() {
		return this.originId;
	}

	public void setOriginId(String originId) {
		this.originId = originId;
	}

	public String getOuter() {
		return this.outer;
	}

	public void setOuter(String outer) {
		this.outer = outer;
	}

	public String getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getPalletConfig() {
		return this.palletConfig;
	}

	public void setPalletConfig(String palletConfig) {
		this.palletConfig = palletConfig;
	}

	public BigDecimal getPalletDepth() {
		return this.palletDepth;
	}

	public void setPalletDepth(BigDecimal palletDepth) {
		this.palletDepth = palletDepth;
	}

	public BigDecimal getPalletHeight() {
		return this.palletHeight;
	}

	public void setPalletHeight(BigDecimal palletHeight) {
		this.palletHeight = palletHeight;
	}

	public String getPalletId() {
		return this.palletId;
	}

	public void setPalletId(String palletId) {
		this.palletId = palletId;
	}

	public BigDecimal getPalletVolume() {
		return this.palletVolume;
	}

	public void setPalletVolume(BigDecimal palletVolume) {
		this.palletVolume = palletVolume;
	}

	public BigDecimal getPalletWeight() {
		return this.palletWeight;
	}

	public void setPalletWeight(BigDecimal palletWeight) {
		this.palletWeight = palletWeight;
	}

	public BigDecimal getPalletWidth() {
		return this.palletWidth;
	}

	public void setPalletWidth(BigDecimal palletWidth) {
		this.palletWidth = palletWidth;
	}

	public String getPickFace() {
		return this.pickFace;
	}

	public void setPickFace(String pickFace) {
		this.pickFace = pickFace;
	}

	public String getPreReceived() {
		return this.preReceived;
	}

	public void setPreReceived(String preReceived) {
		this.preReceived = preReceived;
	}

	public String getQcStatus() {
		return this.qcStatus;
	}

	public void setQcStatus(String qcStatus) {
		this.qcStatus = qcStatus;
	}

	public BigDecimal getQtyAllocated() {
		return this.qtyAllocated;
	}

	public void setQtyAllocated(BigDecimal qtyAllocated) {
		this.qtyAllocated = qtyAllocated;
	}

	public BigDecimal getQtyOnHand() {
		return this.qtyOnHand;
	}

	public void setQtyOnHand(BigDecimal qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
	}

	public Timestamp getReceiptDstamp() {
		return this.receiptDstamp;
	}

	public void setReceiptDstamp(Timestamp receiptDstamp) {
		this.receiptDstamp = receiptDstamp;
	}

	public String getReceiptId() {
		return this.receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	public String getReceiptType() {
		return this.receiptType;
	}

	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}

	public String getSampled() {
		return this.sampled;
	}

	public void setSampled(String sampled) {
		this.sampled = sampled;
	}

	public String getSamplingType() {
		return this.samplingType;
	}

	public void setSamplingType(String samplingType) {
		this.samplingType = samplingType;
	}

	public String getSiteId() {
		return this.siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSkuId() {
		return this.skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getSpecCode() {
		return this.specCode;
	}

	public void setSpecCode(String specCode) {
		this.specCode = specCode;
	}

	public String getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getTagId() {
		return this.tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getToSiteId() {
		return this.toSiteId;
	}

	public void setToSiteId(String toSiteId) {
		this.toSiteId = toSiteId;
	}

	public BigDecimal getUnkitSequence() {
		return this.unkitSequence;
	}

	public void setUnkitSequence(BigDecimal unkitSequence) {
		this.unkitSequence = unkitSequence;
	}

	public String getUserDefChk1() {
		return this.userDefChk1;
	}

	public void setUserDefChk1(String userDefChk1) {
		this.userDefChk1 = userDefChk1;
	}

	public String getUserDefChk2() {
		return this.userDefChk2;
	}

	public void setUserDefChk2(String userDefChk2) {
		this.userDefChk2 = userDefChk2;
	}

	public String getUserDefChk3() {
		return this.userDefChk3;
	}

	public void setUserDefChk3(String userDefChk3) {
		this.userDefChk3 = userDefChk3;
	}

	public String getUserDefChk4() {
		return this.userDefChk4;
	}

	public void setUserDefChk4(String userDefChk4) {
		this.userDefChk4 = userDefChk4;
	}

	public Timestamp getUserDefDate1() {
		return this.userDefDate1;
	}

	public void setUserDefDate1(Timestamp userDefDate1) {
		this.userDefDate1 = userDefDate1;
	}

	public Timestamp getUserDefDate2() {
		return this.userDefDate2;
	}

	public void setUserDefDate2(Timestamp userDefDate2) {
		this.userDefDate2 = userDefDate2;
	}

	public Timestamp getUserDefDate3() {
		return this.userDefDate3;
	}

	public void setUserDefDate3(Timestamp userDefDate3) {
		this.userDefDate3 = userDefDate3;
	}

	public Timestamp getUserDefDate4() {
		return this.userDefDate4;
	}

	public void setUserDefDate4(Timestamp userDefDate4) {
		this.userDefDate4 = userDefDate4;
	}

	public String getUserDefNote1() {
		return this.userDefNote1;
	}

	public void setUserDefNote1(String userDefNote1) {
		this.userDefNote1 = userDefNote1;
	}

	public String getUserDefNote2() {
		return this.userDefNote2;
	}

	public void setUserDefNote2(String userDefNote2) {
		this.userDefNote2 = userDefNote2;
	}

	public BigDecimal getUserDefNum1() {
		return this.userDefNum1;
	}

	public void setUserDefNum1(BigDecimal userDefNum1) {
		this.userDefNum1 = userDefNum1;
	}

	public BigDecimal getUserDefNum2() {
		return this.userDefNum2;
	}

	public void setUserDefNum2(BigDecimal userDefNum2) {
		this.userDefNum2 = userDefNum2;
	}

	public BigDecimal getUserDefNum3() {
		return this.userDefNum3;
	}

	public void setUserDefNum3(BigDecimal userDefNum3) {
		this.userDefNum3 = userDefNum3;
	}

	public BigDecimal getUserDefNum4() {
		return this.userDefNum4;
	}

	public void setUserDefNum4(BigDecimal userDefNum4) {
		this.userDefNum4 = userDefNum4;
	}

	public String getUserDefType1() {
		return this.userDefType1;
	}

	public void setUserDefType1(String userDefType1) {
		this.userDefType1 = userDefType1;
	}

	public String getUserDefType2() {
		return this.userDefType2;
	}

	public void setUserDefType2(String userDefType2) {
		this.userDefType2 = userDefType2;
	}

	public String getUserDefType3() {
		return this.userDefType3;
	}

	public void setUserDefType3(String userDefType3) {
		this.userDefType3 = userDefType3;
	}

	public String getUserDefType4() {
		return this.userDefType4;
	}

	public void setUserDefType4(String userDefType4) {
		this.userDefType4 = userDefType4;
	}

	public String getUserDefType5() {
		return this.userDefType5;
	}

	public void setUserDefType5(String userDefType5) {
		this.userDefType5 = userDefType5;
	}

	public String getUserDefType6() {
		return this.userDefType6;
	}

	public void setUserDefType6(String userDefType6) {
		this.userDefType6 = userDefType6;
	}

	public String getUserDefType7() {
		return this.userDefType7;
	}

	public void setUserDefType7(String userDefType7) {
		this.userDefType7 = userDefType7;
	}

	public String getUserDefType8() {
		return this.userDefType8;
	}

	public void setUserDefType8(String userDefType8) {
		this.userDefType8 = userDefType8;
	}

	public String getZone1() {
		return this.zone1;
	}

	public void setZone1(String zone1) {
		this.zone1 = zone1;
	}

}