package study05;

class Customer1VO {
	private String name;
	private int year;
	
	public void setname(String name) {
		this.name = name;
	}
	public void setyear(int year) {
		this.year = year;
	}
	public String getname() {
		return name;
	}
	public int getyear() {
		return year;
	}
}

class Customer2VO extends Customer1VO {
	private String phone;
	private int age;
	private String address;
	
	public void setphone(String phone) {
		this.phone = phone;
	}
	public void setage(int age) {
		this.age = age;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getphone() {
		return phone;
	}
	public int getage() {
		return age;
	}
	public String getaddress() {
		return address;
	}
}
public class CustomerMng {

	public static void main(String[] args) {
		Customer2VO c = new Customer2VO();
		c.setname("이방인");
		c.setphone("010-111-2222");
		c.setage(30);
		c.setaddress("서울 강남");
		System.out.println(c.getname());
		System.out.println(c.getage());
		System.out.println(c.getaddress());
		
		
		
	}

}
