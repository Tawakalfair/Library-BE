package com.iqbal.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "m_publisher")
@Getter @Setter
public class MPublisher {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long Id;

	private String name;

	private String address;

	private String phone;
}
