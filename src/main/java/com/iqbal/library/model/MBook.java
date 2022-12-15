package com.iqbal.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
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
	private long id;

	private String title;

	private int totalCopy;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "publisher_id")
	private MPublisher publisherId;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "shelf_id")
	private MShelf shelfId;

}
