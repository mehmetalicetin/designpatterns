package com.i2i.fcbs.builder.ch06;

public class Book {
	private final String isbn;
	private final String title;
	private final String author;
	private final String description;

	private Book(Builder builder) {
		this.isbn = builder.isbn;
		this.title = builder.title;
		this.author = builder.author;
		this.description = builder.description;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getDescription() {
		return description;
	}

	public static class Builder {
		private final String isbn;
		private final String title;
		private  String author;
		private  String description;

		public Builder(String isbn, String title) {
			this.isbn = isbn;
			this.title = title;
		}

		public Builder author(String author) {
			this.author = author;
			return this;
		}
		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Book build() {
			validate();
			return new Book(this);
		}

		private void validate() {
			if (isbn == null || title == null || author == null || description == null) {
				throw new IllegalArgumentException("Both ISBN and title and author and description can't be null");
			}
		}
	}

	@Override
	public String toString() {
		return "Book{" +
				"isbn='" + isbn + '\'' +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
