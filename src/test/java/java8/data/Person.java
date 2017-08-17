package java8.data;

public class Person {

    private String firstname;
    private String lastname;
    private Integer age;
    private String password;

    public Person() {
    }

    public Person(String firstname, String lastname, Integer age, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", password=" + password
				+ "]";
	}    
}
