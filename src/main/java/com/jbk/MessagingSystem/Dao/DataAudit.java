package com.jbk.MessagingSystem.Dao;

import java.sql.Date;
import java.time.Instant;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@MappedSuperclass
@EntityListeners( AuditingEntityListener.class )//only by using this annotation 
@Data
@JsonIgnoreProperties(value= {"school_created_dtm","school_updated_dtm"},
allowGetters=true)
	

public  abstract class DataAudit {

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@CreatedDate
	Instant school_created_dtm;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@LastModifiedDate
	Instant school_updated_dtm;

}
