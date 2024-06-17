package com.suraj.sms.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sms_school")
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_id")
	private Integer schoolId;

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "about")
	private String schoolAbout;

	@OneToMany(mappedBy = "school", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	private List<Student> students;	

}
