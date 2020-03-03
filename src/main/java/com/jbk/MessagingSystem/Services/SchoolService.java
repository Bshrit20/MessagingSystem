package com.jbk.MessagingSystem.Services;

import com.jbk.MessagingSystem.Bean.School;

public interface SchoolService {
	public School getById( int  school_id ); 
	public School addSchool(School school) ;
	public School updateSchool(School school, int  school_id) ;
	public int deleteSchool(int  school_id);

}
