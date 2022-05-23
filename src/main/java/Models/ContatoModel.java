package Models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name" , "last_name" , "email" , "age" , "phone" , "addres" , "state" , "city"})
public class ContatoModel {

    private String name;
    private String last_name;
    private String email;
    private String age;
    private String phone;
    private String address;
    private String state;
    private String city;

    public ContatoModel(String name, String last_name, String email, String age,
                        String phone, String address, String state, String city) {

        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.state = state;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
