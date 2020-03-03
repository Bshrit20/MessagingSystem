package com.jbk.MessagingSystem.Dao;

import com.jbk.MessagingSystem.Bean.School;

public interface SchoolDao {
	public School getById(int  school_id); 
	public School addSchool(School school) ;
	public School updateSchool(School school, int  school_id) ;
	public void deleteSchool(int  school_id);
	
		

}
