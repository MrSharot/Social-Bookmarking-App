package com.project.controller;

import com.project.entities.Bookmark;
import com.project.entities.User;
import com.project.managers.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController() {
		
	}
	public static BookmarkController getInstance() {
		return instance;
	}
	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
		
	}
	public void setKidsFriendlyStatus(User user, String kidsFriendlyStatus, Bookmark bookmark) {
		BookmarkManager.getInstance().setKidsFriendlyStatus(user, kidsFriendlyStatus, bookmark);
		
	}
	public void share(User user, Bookmark bookmark) {
		// TODO Auto-generated method stub
		BookmarkManager.getInstance().share(user, bookmark);
		
	}
	
}
