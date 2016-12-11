package customer;

/**
 *
 * @author babylu
 */
public class UserInfo {
    private String username = "";
    private String name = "";
    private String address_street = "";
    private String address_city = "";
    private String address_state = "";
    private int address_zipcode = 0;
    private String marriage = "";
    private String gender = "";
    private int age = 0;
    private int income = 0;
    private String password  = "";
    
    public String getUsername() {
            return username;
    }
    public void setUsername(String username) {
            this.username = username;
    }
    public String getName() {
            return name;
    }
    public void setName(String name) {
            this.name = name;
    }
    public String getAddress_street() {
            return address_street;
    }
    public void setAddress_street(String address_street) {
            this.address_street = address_street;
    }
    public String getAddress_city() {
            return address_city;
    }
    public void setAddress_city(String address_city) {
            this.address_city = address_city;
    }
    public String getAddress_state() {
            return address_state;
    }
    public void setAddress_state(String address_state) {
            this.address_state = address_state;
    }
    public int getAddress_zipcode() {
            return address_zipcode;
    }
    public void setAddress_zipcode(int address_zipcode) {
            this.address_zipcode = address_zipcode;
    }
    public String getMarriage() {
            return marriage;
    }
    public void setMarriage(String marriage) {
            this.marriage = marriage;
    }
    public String getGender() {
            return gender;
    }
    public void setGender(String gender) {
            this.gender = gender;
    }
    public int getAge() {
            return age;
    }
    public void setAge(int age) {
            this.age = age;
    }
    public int getIncome() {
            return income;
    }
    public void setIncome(int income) {
            this.income = income;
    }
    public String getPassword() {
            return password;
    }
    public void setPassword(String password) {
            this.password = password;
    }
}
