package com.intervest.hrms.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Proxy(lazy = false)
@Table(name = "employees")
public class Employee {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "name_with_initials")
	private String nameWithInitials;
	@Column(name = "name_in_full")
	private String nameInFull;
	@Column(name = "personal_address")
	private String personalAddress;
	@Column(name = "current_address")
	private String currentAddress;
	private int gender;
	private String dob;
	@Column(name = "nic_no")
	private String nicNo;
	private String email;
	@Column(name = "contact_no")
	private String contactNo;
	@Column(name = "heighest_qualifications")
	private String highestQualification;
	@Column(name = "skills_and_specializations")
	private String skillsAndSpecialozations;
	@Column(name = "years_of_experiance")
	private double yearsOfExperiance;
	private String university;
	@Column(name = "year_graduated")
	private int yearGraduated;
	@Column(name = "currently_followings")
	private String currentlyFollowing;
	@Column(name = "date_of_appoinment")
	private String appointmentDate;
	@Column(name = "basic_salary")
	private double basicSalary;

	@ManyToOne
	@JoinColumn(name = "designation")
	private Designation designation;

	@ManyToOne
	@JoinColumn(name = "supervisor")
	private Employee supervisor;

	@OneToMany(mappedBy = "supervisor")
	private List<Employee> employees;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	private Set<AppliedLeave> appliedLeaves;

	@OneToMany(mappedBy = "employee")
	private Set<EntitlementDetail> entitlement;

	@OneToMany(mappedBy = "employee")
	private Set<TrainingEmployee> trainingEmployee;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<AppliedLeave> getAppliedLeaves() {
		return appliedLeaves;
	}

	public void setAppliedLeaves(Set<AppliedLeave> appliedLeaves) {
		this.appliedLeaves = appliedLeaves;
	}

	public Set<EntitlementDetail> getEntitlement() {
		return entitlement;
	}

	public void setEntitlement(Set<EntitlementDetail> entitlement) {
		this.entitlement = entitlement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNameWithInitials() {
		return nameWithInitials;
	}

	public void setNameWithInitials(String nameWithInitials) {
		this.nameWithInitials = nameWithInitials;
	}

	public String getNameInFull() {
		return nameInFull;
	}

	public void setNameInFull(String nameInFull) {
		this.nameInFull = nameInFull;
	}

	public String getPersonalAddress() {
		return personalAddress;
	}

	public void setPersonalAddress(String personalAddress) {
		this.personalAddress = personalAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		if (dob.equals("")) {
			dob = null;
		}
		this.dob = dob;
	}

	public String getNicNo() {
		return nicNo;
	}

	public void setNicNo(String nicNo) {
		this.nicNo = nicNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public String getSkillsAndSpecialozations() {
		return skillsAndSpecialozations;
	}

	public void setSkillsAndSpecialozations(String skillsAndSpecialozations) {
		this.skillsAndSpecialozations = skillsAndSpecialozations;
	}

	public double getYearsOfExperiance() {
		return yearsOfExperiance;
	}

	public void setYearsOfExperiance(double yearsOfExperiance) {
		this.yearsOfExperiance = yearsOfExperiance;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public int getYearGraduated() {
		return yearGraduated;
	}

	public void setYearGraduated(int yearGraduated) {
		this.yearGraduated = yearGraduated;
	}

	public String getCurrentlyFollowing() {
		return currentlyFollowing;
	}

	public void setCurrentlyFollowing(String currentlyFollowing) {
		this.currentlyFollowing = currentlyFollowing;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		if (appointmentDate.equals("")) {
			appointmentDate = null;
		}
		this.appointmentDate = appointmentDate;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Set<TrainingEmployee> getTrainingEmployee() {
		return trainingEmployee;
	}

	public void setTrainingEmployee(Set<TrainingEmployee> trainingEmployee) {
		this.trainingEmployee = trainingEmployee;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}