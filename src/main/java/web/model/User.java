package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "age")
    int age;
    @Column(name = "password")
    String password;
    @Column(name = "role")
    String role;
    public User(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public static class Builder{
        User user;
        public Builder(){
            user = new User();
        }

        public Builder withId(int id){
            user.id = id;
            return this;
        }
        public Builder withName(String name){
            user.name = name;
            return this;
        }
        public Builder withAge(int age){
            user.age = age;
            return this;
        }
        public Builder withPassword(String passwrod){
            user.password = passwrod;
            return this;
        }
        public Builder withRole(String role){
            user.role = role;
            return this;
        }
        public User build(){
            return user;
        }
    }
}
