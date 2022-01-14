/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author albie
 */
@Entity
@Table(name = "dinnerevent")
public class Dinnerevent implements Serializable {
    @Id
    @Column(name = "eventID")
    private Long id;
    @Column(name = "price")
    private int price;
    @Column(name = "location")
    private String location;
    @Column(name = "dish")
    private String dish;
    @Column(name = "eventTime")
    private String eventTime;
    @JoinColumn(name = "assignmentID")
    @OneToMany
    private List<Assignment> assignments = new ArrayList<>();
    

    public Dinnerevent() {}
    
    public Dinnerevent(int price, String location, String dish, String eventTime, List<Assignment> assignments){
        this.price = price;
        this.location = location;
        this.dish = dish;
        this.eventTime = eventTime;
        this.assignments = assignments;
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public String getLocation(){
        return location;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    
    public String getDish(){
        return dish;
    }
    
    public void setDish(String dish){
        this.dish = dish;
    }
    
    public String getEventTime(){
        return eventTime;
    }
    
    public void setEventTime(String eventTime){
        this.eventTime = eventTime;
    }
    
    public List<Assignment> getAssignments(){
        return assignments;
    }
    
    public void setAssignments(List<Assignment> assignments){
        this.assignments = assignments;
    }
}
