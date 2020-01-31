package com.restApi.gatewayRestApi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tb_gateway")
@EntityListeners(AuditingEntityListener.class)
public class Gateway implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Column(name = "serial_number")
	private String serialNumber;
	
	@NotBlank
	@Column(name = "name")
	private String name;
	
	@NotBlank
	@Column(name = "IPv4")
	private String IPv4;
	 
	@Fetch(FetchMode.JOIN) 
	@OneToMany(mappedBy="gateway",
				targetEntity=PeriferialDevice.class, 
				cascade = CascadeType.DETACH)
	Set<PeriferialDevice> periferialDevices = new HashSet<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIPv4() {
		return IPv4;
	}

	public void setIPv4(String iPv4) {
		IPv4 = iPv4;
	}

	public Set<PeriferialDevice> getPeriferialDevices() {
		return periferialDevices;
	}

	public void setPeriferialDevices(Set<PeriferialDevice> periferialDevices) {
		this.periferialDevices = periferialDevices;
	}

}
