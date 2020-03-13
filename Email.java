import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = ".company.com";
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = setDepartment();
		
		this.password = generateRandomPassword(12);
		System.out.println("Password: " + password);
		
		// Create email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
	}
	
	// Ask for the department
	private String setDepartment() {
		System.out.print("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter the department: ");
		Scanner in = new Scanner(System.in);
		int departmentCode = in.nextInt();
		in.close();
		
		switch (departmentCode) {
		case 1:
			return "sales";
		case 2: 
			return "dev";
		case 3:
			return "acct";
		default: 
			return "";
		}
	}
	
	// Generate a random password
	private String generateRandomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setMailboxCapacity(int capacity) {
		mailboxCapacity = capacity;
	}
	
	public void setAlternateEmail(String email) {
		alternateEmail = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String showInfo() {
		return "NAME: " + firstName + " " + lastName + 
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
