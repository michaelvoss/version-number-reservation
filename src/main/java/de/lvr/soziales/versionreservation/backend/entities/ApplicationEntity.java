package de.lvr.soziales.versionreservation.backend.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "VR_APPLICATION", schema = "ANLEIAO")
public class ApplicationEntity implements Serializable {
	@Id
	@GeneratedValue(generator = "application-sequence-generator")
	@SequenceGenerator(name = "application-sequence-generator", sequenceName = "LVR_SEQUENCE", allocationSize = 1, schema = "ANLEIAO")
	private Long oid;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "LAST_MODIFICATION", nullable = false)
	@LastModifiedDate
	private LocalDateTime lastModification;
	
	@Column(name = "USER_ID", nullable = false)
	private String userId;
	
	@Transient
	public Boolean isDisabled() {
		return false;
	}
	
	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
}
