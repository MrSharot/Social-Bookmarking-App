package com.project.entities;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.project.constant.BookGenre;
import com.project.partner.Shareable;

public class Book extends Bookmark implements Shareable {
	
	private int publicationYear;
	private String publisher;
	private String genre;
	private String[] authors;
	private double amazonRating;

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		// TODO Auto-generated method stub
		this.genre = genre;
		
	}

	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", genre=" + genre
				+ ", authors=" + Arrays.toString(authors) + ", amazonRating=" + amazonRating + "]";
	}

	@Override
	public boolean isKidsFriendlyEligible() {
		
		if(genre.equals(BookGenre.PHILOSOPHY)|| genre.equals(BookGenre.SELF_HELP)) {
			return false;
		}
		return true;
	}

	@Override
	public String getItemData() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
			builder.append("<type>Book</type>");
			builder.append("<title>").append(getTitle()).append("</title>");
			builder.append("<aithors>").append(getTitle()).append("</authors>");
			builder.append("<publisher>").append(StringUtils.join(authors, ",")).append("</publisher>");
			builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
			builder.append("<genre>").append(genre).append("</genre>");
		builder.append("</item>");
		
		return builder.toString();
	}
	

	

}
