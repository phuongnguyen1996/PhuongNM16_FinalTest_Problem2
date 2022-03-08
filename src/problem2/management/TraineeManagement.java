package problem2.management;

import java.sql.Date;
import java.util.Scanner;

import problem2.dao.TraineeDao;
import problem2.entities.Trainee;

public class TraineeManagement {
	private static TraineeDao traineeDao = new TraineeDao();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("========== FA System ==========");
		System.out.println("1.Create Trainee....................");
		System.out.println("2.Update Trainee....................");
		System.out.println("3.Remove a specific Trainee.........");
		System.out.println("4.Report incompleted training.......");
		System.out.println("5.List excellent trainees...........");
		System.out.println("6.Exit..............................");
		System.out.println("====================");

		System.out.print("Your choose:");
		int choise = scanner.nextInt();

		String account;
		String full_name;
		String genderS;
		String gender;
		String birth_date;
		String phone_number;
		String gpa;
		String status;
		int id = 0;

		switch (choise) {
		case 1:
			
			System.out.print("Enter account: ");
			account = scanner.next();

			System.out.print("Enter full_name: ");
			full_name = scanner.next();

			System.out.print("Enter gender (male/female): ");
			genderS = scanner.next();

			System.out.print("Enter birth_date (yyyy-mm-dd): ");
			birth_date = scanner.next();
			Date date = Date.valueOf(birth_date);

			System.out.print("Enter phone_number: ");
			phone_number = scanner.next();

			System.out.print("Enter gpa: ");
			gpa = scanner.next();

			status = "active";
			if(genderS.equals("male")) {
				gender = "1";
			} else {
				gender = "0";
			}

			Trainee trainee = new Trainee(account, full_name, gender, date, phone_number, gpa, status);

			traineeDao.save(trainee);

			menu();

			break;
		case 2:
			System.out.println("List account active:");
			traineeDao.getAllByStatusActive();
			
			System.out.println("Choose account need update:");
			id = scanner.nextInt();

			System.out.print("Enter account: ");
			account = scanner.next();

			System.out.print("Enter full_name: ");
			full_name = scanner.next();

			System.out.print("Enter gender (male/female): ");
			genderS = scanner.next();

			System.out.print("Enter birth_date (yyyy-mm-dd): ");
			birth_date = scanner.next();
			Date date1 = Date.valueOf(birth_date);

			System.out.print("Enter phone_number: ");
			phone_number = scanner.next();

			System.out.print("Enter gpa: ");
			gpa = scanner.next();
			
			System.out.print("Enter status (active/inactive): ");
			status = scanner.next();

			if(genderS.equals("male")) {
				gender = "1";
			} else {
				gender = "0";
			}

			Trainee trainee1 = new Trainee(account, full_name, gender, date1, phone_number, gpa, status);
			System.out.println(trainee1.toString());
			traineeDao.update(trainee1, id);

			menu();

			break;
		case 3:
			System.out.println("List FA:");
			traineeDao.getAllByStatusInActive();

			if (traineeDao.getAllByStatusInActive() != null) {
				System.out.print("Choose account need delete: ");
				id = scanner.nextInt();
				traineeDao.remove(id);
			} else {
				System.out.println("Don't have account inactive");
			}

			menu();

			break;
		case 4:
			traineeDao.findIncompletedTrainee();
			menu();

			break;
		case 5:
			traineeDao.findExcellentTrainee();
			menu();

			break;
		default:
			System.out.println("Exit!!!");
			break;
		}
		scanner.close();
	}

	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		int c = 0;
		try {
			do {
				System.out.println("Input '1' to continue or '0' to end?");
				c = scanner.nextInt();
			} while (c != 1 && c != 0);
			if (c == 1) {
				main(null);
			} else {
				System.out.println("The end");
			}
		} catch (Exception e) {
			System.out.println("input error!");
		}

		scanner.close();
	}
}
