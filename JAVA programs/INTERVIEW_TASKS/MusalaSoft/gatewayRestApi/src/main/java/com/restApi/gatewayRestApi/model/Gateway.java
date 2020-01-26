package com.restApi.gatewayRestApi.model;

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

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tb_gateway")
@EntityListeners(AuditingEntityListener.class)
public class Gateway {
	
	 private long id;
	 private String serialNumber;
	 private String name;
	 private String IPv4;
	 
	@OneToMany(mappedBy="gateway", cascade = CascadeType.ALL)
	Set<PeriferialDevice> periferialDevices = new HashSet<>(); 
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "serialNumber", nullable = false)
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "IPv4", nullable = false)
	public String getIPv4() {
		return IPv4;
	}
	public void setIPv4(String iPv4) {
		IPv4 = iPv4;
	}
	 
}
