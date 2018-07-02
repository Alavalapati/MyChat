package com.org.Dao;

import com.org.models.DisplayPicture;

public interface DisplayPictureDao {
	void saveDisplayPicture(DisplayPicture displayPicture);
	DisplayPicture  getDisplayPicture(String email);
	

}
