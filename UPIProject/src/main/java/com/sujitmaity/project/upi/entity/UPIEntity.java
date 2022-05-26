package com.sujitmaity.project.upi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="UPI")
public class UPIEntity {
	
	@Id
	@Column(name="upiId")//It should in proper format
	private String upiId;
	
	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;

	@Column(name="phoneNo")
	private long phoneNo;

	@Column(name="userEmail")
	private String userEmail;

}
