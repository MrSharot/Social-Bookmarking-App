package com.project.socialbookmarking;

import com.project.constant.KidsFriendlyStatus;
import com.project.constant.UserType;
import com.project.controller.BookmarkController;
import com.project.entities.Bookmark;
import com.project.entities.User;
import com.project.partner.Shareable;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items... ");
		int bookmarkCount = 0;
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				// bookmarking
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;

						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New Item Bookmarked - -" + bookmark);

					}
				}
				
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {

					// mark as kid friendly
					if (bookmark.isKidsFriendlyEligible()
							&& bookmark.getKidsFriendlyStatus().equals(KidsFriendlyStatus.UNKNOWN)) {

						String kidsFriendlyStatus = getKidsFriendlyStatusDecision(bookmark);
						if (!kidsFriendlyStatus.equals(KidsFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidsFriendlyStatus(user, kidsFriendlyStatus, bookmark);
							 
							
						}
					}
					
					// Sharing !!
					
					if (bookmark.getKidsFriendlyStatus().equals(KidsFriendlyStatus.APPROVED)
							&& bookmark instanceof Shareable) {
						boolean isShared = getShareDecision();
						if(isShared) {
							BookmarkController.getInstance().share(user, bookmark);
						}
						
					}
				}
			}
		}
		for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPE_COUNT);
			int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];

			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
			System.out.println(bookmark);

		}
	}
	
	//TODO: Below methods simulate user input After IO, we take input via console.
	
	private static boolean getShareDecision() {
		
		return Math.random() < 0.5 ? true : false;
		
	}

	private static String getKidsFriendlyStatusDecision(Bookmark bookmark) {
		
		return Math.random() < 0.4 ? KidsFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8) ? KidsFriendlyStatus.REJECTED
						: KidsFriendlyStatus.UNKNOWN;

	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {

		return Math.random() < 0.5 ? true : false;

	}

	public static void bookmark(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is bookmarking");
		for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPE_COUNT);
			int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];

			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
			System.out.println(bookmark);

		}

	}

}
