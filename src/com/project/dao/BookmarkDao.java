package com.project.dao;

import com.project.entities.Bookmark;
import com.project.entities.UserBookmark;
import com.project.socialbookmarking.DataStore;

public class BookmarkDao {
	
	public Bookmark[][] getBookmark(){
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		
		DataStore.add(userBookmark);
		
	}
	
}
