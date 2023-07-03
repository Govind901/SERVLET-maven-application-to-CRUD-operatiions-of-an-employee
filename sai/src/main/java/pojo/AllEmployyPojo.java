package pojo;

public class AllEmployyPojo {
	int id,salary;
	String department,ep,type;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getEp() {
		return ep;
	}


	public void setEp(String ep) {
		this.ep = ep;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	public AllEmployyPojo(int id, int salary, String department, String ep, String type) {
		super();
		this.id = id;
		this.salary = salary;
		this.department = department;
		this.ep = ep;
		this.type = type;
	}


	public AllEmployyPojo() {
		super();
	}
	

}
