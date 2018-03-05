package com.file;

import java.io.Serializable;

public class Teacher  implements Serializable{

	private String id = null;
	private String name = null;
	private String password = null;
	private String age = null;	
	private String sex = null;
	private Course teaching_course = null;
	
	public Teacher(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", password="
				+ password + ", age=" + age + ", sex=" + sex
				+ ", teaching_course=" + teaching_course + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result
				+ ((teaching_course == null) ? 0 : teaching_course.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (teaching_course == null) {
			if (other.teaching_course != null)
				return false;
		} else if (!teaching_course.equals(other.teaching_course))
			return false;
		return true;
	}

	public Teacher(String id, String name, String password, String age,
			String sex, Course teaching_course) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.teaching_course = teaching_course;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Course getTeaching_course() {
		return teaching_course;
	}

	public void setTeaching_course(Course teaching_course) {
		this.teaching_course = teaching_course;
	}
	
}
	