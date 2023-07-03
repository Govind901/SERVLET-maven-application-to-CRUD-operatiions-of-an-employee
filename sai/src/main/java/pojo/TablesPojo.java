package pojo;

public class TablesPojo {
	int id,salary;
	String ep,department;
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
	public String getEp() {
		return ep;
	}
	public void setEp(String ep) {
		this.ep = ep;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public TablesPojo(int id, int salary, String ep, String department) {
		super();
		this.id = id;
		this.salary = salary;
		this.ep = ep;
		this.department = department;
	}
	public TablesPojo() {
		super();
	}
	

}
