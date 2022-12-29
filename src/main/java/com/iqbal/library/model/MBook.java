package com.iqbal.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "m_book")
@Getter
@Setter
public class MBook {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long Id;

	private String title;

	private int totalCopy;

	@OneToOne
	@JoinColumn(name = "publisher_id",referencedColumnName = "id")
	private MPublisher publisherId;

	@OneToOne
	@JoinColumn(name = "shelf_id",referencedColumnName = "id")
	private MShelf shelfId;

}
