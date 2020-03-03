package com.jbk.MessagingSystem.Bean;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jbk.MessagingSystem.Dao.DataAudit;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity

public class School extends DataAudit implements Serializable {
	@Id

	// @GeneratedValue(strategy=GenerationType.TABLE)
	int school_id;
	@NotBlank(message = "SchoolName can not  null")

	String school_Name;
	@NotBlank(message = "school Address can not  null")

	String school_Address;
	@NotBlank(message = "email Id can not  null")

	String school_Email;
	@NotBlank(message = "phone number can not  null")

	String school_Phone;

	String school_created_by;
	String school_updated_by;

}
