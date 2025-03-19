package question08;

public class Student {
	private String name;
	private int number;
	private String department;
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	public String getDepartment() {
		return department;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String toString() {
		return "이름 : "+name+"\n학번 : "
				+number+"\n소속학과 : "+department;
	}
}
