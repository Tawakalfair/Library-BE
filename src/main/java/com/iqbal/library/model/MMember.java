package com.iqbal.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "m_member")
@Getter @Setter
public class MMember {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;

	private String nik;

	private String address;

	private String phone;

	@Column(name = "identification_file_id")
	private String identificationFileId;

	private String memberStatus;

}
