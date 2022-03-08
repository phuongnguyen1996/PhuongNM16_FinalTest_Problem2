package problem2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import problem2.entities.Trainee;

public class TraineeDao {
	Connection conn = JDBC.getConnection();
	Statement stm = null;

	public Trainee save(Trainee trainee) {
		try {
			stm = conn.createStatement();
			String sql1 = "INSERT INTO `trainee`(`account`, `full_name`, `gender`, `birth_date`, `phone_number`, `gpa`, `status`) "
					+ "VALUES ('" + trainee.getAccount() + "','" + trainee.getFull_name() + "','" + trainee.getGender()
					+ "','" + trainee.getBirth_date() + "','" + trainee.getPhone_number() + "','" + trainee.getGpa()
					+ "','" + trainee.getStatus() + "')";
			stm.executeUpdate(sql1);

			System.out.println("create product done!");

			return trainee;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Trainee update(Trainee trainee, int id) {
		try {
			stm = conn.createStatement();

			stm.execute("UPDATE `trainee` SET `account`='" + trainee.getAccount() + "',`full_name`='"
					+ trainee.getFull_name() + "',`gender`='" + trainee.getGender() + "',`birth_date`='"
					+ trainee.getBirth_date() + "', `phone_number`='" + trainee.getPhone_number() + "',`gpa`='"
					+ trainee.getGpa() + "',`status`='" + trainee.getStatus() + "' WHERE `trainee_id` = '" + id + "'");

			System.out.println("Updated!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Trainee> getAllByStatusActive() {
		try {
			stm = conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * FROM `trainee` WHERE `status`='active'");
			while (rs.next()) {
				String id = rs.getString(1);
				String account = rs.getString(2);

				System.out.println(id + ". " + account);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Trainee> getAllByStatusInActive() {
		try {
			stm = conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * FROM `trainee` WHERE `status`='inactive'");
			while (rs.next()) {
				String id = rs.getString(1);
				String account = rs.getString(2);

				System.out.println(id + ". " + account);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Trainee remove(int id) {
		try {
			stm = conn.createStatement();

			stm.execute("DELETE FROM `trainee` WHERE `trainee_id` = '" + id + "'");
			
			System.out.println("Deleted!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Trainee> findIncompletedTrainee() {
		try {
			stm = conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * FROM `trainee` WHERE `gpa` < 6");
			while (rs.next()) {
				String id = rs.getString(1);
				String account = rs.getString(2);

				System.out.println(id + ". " + account);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Trainee> findExcellentTrainee() {
		try {
			stm = conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * FROM `trainee` WHERE `gpa` > 90 AND `gpa` < 100");
			while (rs.next()) {
				String id = rs.getString(1);
				String account = rs.getString(2);
				String full_name = rs.getString(3);
				String gender = rs.getString(4);
				String birth_date = rs.getString(5);
				String gpa = rs.getString(7);
				System.out.println(id + ", account=" + account + ", full_name=" + full_name + ", gender="
						+ gender + ", birth_date=" + birth_date + ", gpa=" + gpa);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

