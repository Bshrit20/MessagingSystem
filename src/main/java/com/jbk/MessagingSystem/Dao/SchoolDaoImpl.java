package com.jbk.MessagingSystem.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.MessagingSystem.Bean.School;
@Repository
public class SchoolDaoImpl {
	@Autowired
	SessionFactory sessionFactory;

	public School getById(int  school_id) {
		System.out.println("dao");

		return sessionFactory.getCurrentSession().load(School.class,  school_id);

	}

	public School updateSchool(School school ,int school_id) {
		School school2= sessionFactory.getCurrentSession().get(School.class,  school_id);
		school2.setSchool_Name(school.getSchool_Name());
		school2.setSchool_Address(school.getSchool_Address());
		school2.setSchool_Email(school.getSchool_Email());
		school2.setSchool_Phone(school.getSchool_Phone());

          return school;

		

	}
	public void addSchool(School school) {
		Session session = sessionFactory.getCurrentSession();
		/*
		 * session.beginTransaction(); session.save(school);
		 * session.getTransaction().commit(); session.clear();
		 */
		session.save(school);
		
		 //sessionFactory.openSession().save(school);
		
		
	}
	public void deleteSchool(int  school_id) {
		Session session = sessionFactory.getCurrentSession();
		School school = getById( school_id);
		  session.delete(school);
		/*
		 * session.getTransaction().commit(); session.clear();
		 */
		 
		  
		
	}

}
