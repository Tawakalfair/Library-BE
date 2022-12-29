package com.iqbal.library.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_book_category")
public class MBookCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long Id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "book_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private MBook mBook;

	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private MCategory mCategory;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public MBook getmBook() {
		return mBook;
	}

	public void setmBook(MBook mBook) {
		this.mBook = mBook;
	}

	public MCategory getmCategory() {
		return mCategory;
	}

	public void setmCategory(MCategory mCategory) {
		this.mCategory = mCategory;
	}
}
