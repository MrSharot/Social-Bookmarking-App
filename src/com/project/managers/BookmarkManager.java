package com.project.managers;

import com.project.dao.BookmarkDao;
import com.project.entities.Book;
import com.project.entities.Bookmark;
import com.project.entities.Movie;
import com.project.entities.User;
import com.project.entities.UserBookmark;
import com.project.entities.WebLink;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkManager() {

	}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Movie createMovie(long id, String title, int releaseYear, String[] cast, String[] directors, String genre,
			double imdbRating) {

		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);

		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;

	}

	public Book createBook(long id, String title, int publishYear, String publisher, String[] authors, String genre,
			double amazonRating) {
		Book book = new Book();

		book.setId(id);
		book.setAmazonRating(amazonRating);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setPublicationYear(publishYear);
		book.setPublisher(publisher);
		book.setTitle(title);

		return book;

	}

	public WebLink createWebLink(long id, String title, String url, String host) {
		WebLink webLink = new WebLink();

		webLink.setId(id);
		webLink.setTitle(title);

		webLink.setHost(host);
		webLink.setUrl(url);

		return webLink;

	}

	public Bookmark[][] getBookmarks() {
		return dao.getBookmark();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);

		dao.saveUserBookmark(userBookmark);

	}

	public void setKidsFriendlyStatus(User user, String kidsFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidsFriendlyStatus(kidsFriendlyStatus);
		bookmark.setKidsFriendlyMarkedBy(user);
		System.out.println("Kid friendly status: " + kidsFriendlyStatus + ", Marked by: " + user.getEmail() + bookmark);

	}

	public void share(User user, Bookmark bookmark) {
		
		bookmark.setSharedBy(user);
		System.out.println("Data to be shared: ");
		if(bookmark instanceof Book) {
			System.out.println(((Book)bookmark).getItemData());
			
		}
		else if(bookmark instanceof WebLink) {
			System.out.println(((WebLink)bookmark).getItemData());
			
		}
		
		
	}

}
