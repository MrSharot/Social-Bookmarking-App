package com.project.socialbookmarking;

import com.project.entities.Bookmark;
import com.project.entities.User;
import com.project.managers.BookmarkManager;
import com.project.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	private static void loadData() {
		System.out.println("1. Loading data.....");
		DataStore.loadData();
		
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		
		System.out.println("Printing data. . . .");
		printUserData();
		printBookmarkData();
		
	}

	private static void printBookmarkData() {
		for(Bookmark[] bookmarkList : bookmarks) {
			for(Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
		}
		
	}

	private static void printUserData() {
		for( User user : users) {
			System.out.println(user);
		}
		
	}
	private static void startBookmarking() {
		System.out.println("2. Bookmaring... ");
		for(User user : users ) {
			View.bookmark(user, bookmarks);
		}
		
	}

	public static void main(String[] args) {
		loadData();
		startBookmarking();
		

	}

	

	

}
