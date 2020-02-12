package com.restApi.gatewayRestApi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_perif_device")
@EntityListeners(AuditingEntityListener.class)
public class PeriferialDevice implements Serializable {
	
	public PeriferialDevice() {
		super();
	}

	public PeriferialDevice(long id, @NotBlank String vendor, 
							@NotNull Date dateCreated, Boolean status) {
		super();
		this.id = id;
		this.vendor = vendor;
		this.dateCreated = dateCreated;
		this.status = status;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Column(name="vendor", length=100)
	private String vendor;
	
	@CreatedDate
	@NotNull
	@Column(name="date_created")
	private Date dateCreated;
	
	@Column(name="status")
	private Boolean status;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="gateway_id", nullable = false)
	private Gateway gateway;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Gateway getGateway() {
		return gateway;
	}

	public void setGateway(Gateway gateway) {
		this.gateway = gateway;
	} 
	 
}
