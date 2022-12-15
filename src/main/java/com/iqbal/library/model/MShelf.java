package com.iqbal.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "m_shelf")
@Setter @Getter
public class MShelf {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long Id;

	private String shelfCode;

	private int floor;
}