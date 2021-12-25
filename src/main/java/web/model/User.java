package web.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;
    private String lastname;
    private byte age;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    private String username;
    private String password;



    public User() {
    }

    public User(String firstname, String lastname, byte age, Set<Role> roles, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.roles = roles;
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public byte getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getStringRole(){
        StringBuilder result= new StringBuilder();
        roles.stream().map(role->{String r=role.getRole();return r.substring(r.indexOf("_")+1); }).forEach(roleName->result.append(roleName+"/"));
        result.deleteCharAt(result.lastIndexOf("/"));
        return result.toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", roles=" + roles +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
