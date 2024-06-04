package de.lvr.soziales.versionreservation.backend.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "VR_VERSION", schema = "ANLEIAO")
public class VersionEntity implements Serializable {
	@Id
	@GeneratedValue(generator = "version-sequence-generator")
	@SequenceGenerator(name = "version-sequence-generator", sequenceName = "LVR_SEQUENCE", allocationSize = 1, schema = "ANLEIAO")
	private Long oid;
	
	@Column(name = "APPLICATION_OID", nullable = false)
	private Long applicationId;
	
	@Column(name = "LAST_MODIFICATION", nullable = false)
	@LastModifiedDate
	private LocalDateTime lastModification;
	
	@Column(name = "USER_ID", nullable = false)
	private String userId;
	
	@Column(name = "MAJOR", nullable = false)
	private BigInteger majorVersion;
	
	@Column(name = "MINOR", nullable = false)
	private BigInteger minorVersion;
	
	@Column(name = "PATCH", nullable = false)
	private BigInteger patchNumber;
	
	@Column(name = "BUILD", nullable = false)
	private BigInteger buildNumber;
	
	@Column(name = "ADDON", nullable = true)
	private String addOn;
	
	@Column(name = "INFO", nullable = true)
	private String infoText;
	
	@Column(name = "BRANCH_NAME", nullable = true)
	private String branchName;
	
	
	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public Long getApplicationId() {
		return applicationId;
	}
	
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	
	public LocalDateTime getLastModification() {
		return lastModification;
	}
	
	public void setLastModification(LocalDateTime lastModification) {
		this.lastModification = lastModification;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public BigInteger getMajorVersion() {
		return majorVersion;
	}
	
	public void setMajorVersion(BigInteger majorVersion) {
		this.majorVersion = majorVersion;
	}
	
	public BigInteger getMinorVersion() {
		return minorVersion;
	}
	
	public void setMinorVersion(BigInteger minorVersion) {
		this.minorVersion = minorVersion;
	}
	
	public BigInteger getPatchNumber() {
		return patchNumber;
	}
	
	public void setPatchNumber(BigInteger patchNumber) {
		this.patchNumber = patchNumber;
	}
	
	public BigInteger getBuildNumber() {
		return buildNumber;
	}
	
	public void setBuildNumber(BigInteger buildNumber) {
		this.buildNumber = buildNumber;
	}
	
	public String getAddOn() {
		return addOn;
	}
	
	public void setAddOn(String addOn) {
		this.addOn = addOn;
	}
	
	public String getInfoText() {
		return infoText;
	}
	
	public void setInfoText(String infoText) {
		this.infoText = infoText;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
}
