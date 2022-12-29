package com.iqbal.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_book_authors")
public class MBookAuthor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@ManyToOne
	@JoinColumn(name = "book_id",referencedColumnName = "id",nullable = false)
	private MBook mBook;

	@ManyToOne
	@JoinColumn(name = "author_id",referencedColumnName = "id",nullable = false)
	private MAuthor mAuthor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MBook getmBook() {
		return mBook;
	}

	public void setmBook(MBook mBook) {
		this.mBook = mBook;
	}

	public MAuthor getmAuthor() {
		return mAuthor;
	}

	public void setmAuthor(MAuthor mAuthor) {
		this.mAuthor = mAuthor;
	}

}
