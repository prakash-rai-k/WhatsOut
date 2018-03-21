package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dbConnection.QueryExecutor;
import com.model.PictureGallery;
public class PhotoGalleryDao {
	/*
	 * Written on March 20, 2018 
	 * This function creates the path to the photo gallery
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public boolean insert(PictureGallery pg) {
		QueryExecutor qex = new QueryExecutor();
		String query = "INSERT INTO gallery (path,eventID) VALUES(?,?)";
		boolean result = qex.insert(query, pg.getPath(),pg.getEvent().getId());
		qex.closeConnection();
		return result;
	}
	/*
	 * Written on March 20, 2018 
	 * This function retrieves the path picture in the galery event
	 * It is used by the RatingService.
	 * Uses the model written by Rupendre Maharjan
	 * Uses the QueryExecutor Class written by Yvan GAKUBA
	 * @Author Yvan GAKUBA
	 * */
	public List<PictureGallery> findBy(int eventID) {
		QueryExecutor qex = new QueryExecutor();
		String query = "SELECT * FROM gallery WHERE eventID=?";
		List<PictureGallery> list = new ArrayList<>();
		try {
			ResultSet rs = qex.getData(query,eventID);
			while (rs.next()) {
				list.add(new PictureGallery(rs.getInt(1), rs.getString(2), new EventDao().get(rs.getInt(3))));
			}
		} catch (SQLException sq) {
			System.out.println(sq);
		}
		qex.closeConnection();
		return list;
	}
}
