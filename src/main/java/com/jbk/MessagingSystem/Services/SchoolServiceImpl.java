package com.jbk.MessagingSystem.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.MessagingSystem.Bean.School;
import com.jbk.MessagingSystem.Dao.SchoolDaoImpl;
@Service
@Transactional
public class SchoolServiceImpl {
	@Autowired
	SchoolDaoImpl schoolDaoImpl;
	public School getById(int  school_id) {
		System.out.println("service");

		
		return schoolDaoImpl.getById( school_id);
		
	}
	public void addSchool(School school) {
		 schoolDaoImpl.addSchool(school);
		
	}
	public School updateSchool(School school, int  school_id) {
		return schoolDaoImpl.updateSchool(school,  school_id);
		
	}
	public void deleteSchool(int  school_id) {
		
		 schoolDaoImpl.deleteSchool( school_id);
		
	}

}
