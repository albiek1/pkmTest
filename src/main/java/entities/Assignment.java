/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author albie
 */
@Entity
@Table(name = "assignments")
public class Assignment implements Serializable {
    @Id
    private Long id;
    @Basic(optional = false)
    @Column(name = "familyName")
    private String familyName;
    @Column(name = "createDate")
    private Date createDate;
    @Column(name = "numPeople")
    private int numPeople;
    @ManyToMany(mappedBy = "assignments")
    private List<User> users = new ArrayList<>();

    public Assignment() {}
    
    public Assignment(String familyName, Date createDate, int numPeople){
        this.familyName = familyName;
        this.createDate = createDate;
        this.numPeople = numPeople;
    }
    
    public String getFamilyName(){
        return familyName;
    }
    
    public void setFamilyName(String familyName){
        this.familyName = familyName;
    }
    
    public Date getCreateDate(){
        return createDate;
    }
    
    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }
    
    public int getNumPeople(){
        return numPeople;
    }
    
    public void setNumPeople(int numPeople){
        this.numPeople = numPeople;
    }
    
    public List<User> getUsers(){
        return users;
    }
    
    public void setUsers(List<User> users){
        this.users = users;
    }
}
