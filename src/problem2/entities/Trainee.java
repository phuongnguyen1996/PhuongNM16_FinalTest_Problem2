package problem2.entities;

import java.sql.Date;

public class Trainee {
	private int trainee_id;
	private String account;
	private String full_name;
	private String gender;
	private Date birth_date;
	private String phone_number;
	private String gpa;
	private String status;

	public Trainee(String account, String full_name, String gender, Date birth_date,
			String phone_number, String gpa, String status) {
		super();
		this.account = account;
		this.full_name = full_name;
		this.gender = gender;
		this.birth_date = birth_date;
		this.phone_number = phone_number;
		this.gpa = gpa;
		this.status = status;
	}

	public int getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(int trainee_id) {
		this.trainee_id = trainee_id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Trainee [trainee_id=" + trainee_id + ", account=" + account + ", full_name=" + full_name + ", gender="
				+ gender + ", birth_date=" + birth_date + ", phone_number=" + phone_number + ", gpa=" + gpa
				+ ", status=" + status + "]";
	}
}
