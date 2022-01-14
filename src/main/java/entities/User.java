package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "user_name", length = 25)
  private String userName;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "user_pass")
  private String userPass;
  @Basic(optional = false)
  @NotNull
  @Column(name = "phone")
  private int phone;
  @Basic(optional = false)
  @Column(name = "email", length = 25)
  private String email;
  @Basic(optional = false)
  @Column(name = "account")
  private int account;
  @JoinTable(name = "user_roles", joinColumns = {
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")}, inverseJoinColumns = {
    @JoinColumn(name = "role_name", referencedColumnName = "role_name")})
  @ManyToMany
  private List<Role> roleList = new ArrayList<>();
  @ManyToMany
  private List<Assignment> assignments = new ArrayList<>();
  
  public List<String> getRolesAsStrings() {
    if (roleList.isEmpty()) {
      return null;
    }
    List<String> rolesAsStrings = new ArrayList<>();
    roleList.forEach((role) -> {
        rolesAsStrings.add(role.getRoleName());
      });
    return rolesAsStrings;
  }

  public User() {}

  //TODO Change when password is hashed
   public boolean verifyPassword(String pw){
        return BCrypt.checkpw(pw, userPass);
    }

  public User(String userName, String userPass, int phone, String email, int account, List<Assignment> assignments) {
    this.userName = userName;
    this.userPass = BCrypt.hashpw(userPass, BCrypt.gensalt());
    this.phone = phone;
    this.email = email;
    this.account = account;
    this.assignments = assignments;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPass() {
    return this.userPass;
  }

  public void setUserPass(String userPass) {
    this.userPass = BCrypt.hashpw(userPass, BCrypt.gensalt());
  }
  
  public int getPhone(){
      return phone;
  }
  
  public void setPhone(int phone){
      this.phone = phone;
  }
  
  public String getEmail(){
      return email;
  }
  
  public void setEmail(String email){
      this.email = email;
  }
  
  public int getAccount(){
      return account;
  }
  
  public void setAccount(int account){
      this.account = account;
  }
  
  public List<Assignment> getAssignments(){
      return assignments;
  }
  
  public void setAssignments(List<Assignment> assignments){
      this.assignments = assignments;
  }

  public List<Role> getRoleList() {
    return roleList;
  }

  public void setRoleList(List<Role> roleList) {
    this.roleList = roleList;
  }

  public void addRole(Role userRole) {
    roleList.add(userRole);
  }

}
