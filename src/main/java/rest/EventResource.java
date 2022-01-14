/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Assignment;
import entities.Dinnerevent;
import errorhandling.API_Exception;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author albie
 */
@Path("createEvent")
public class EventResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    EntityManager emf = EMF.createEntityManager();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createEvent(String jsonString) throws API_Exception{
        String location;
        String dish;
        int price;
        String time;
        List<Assignment> blankList = new ArrayList<>();
        Dinnerevent dinnerevent;
        try{
            JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
            price = json.get("Price").getAsInt();
            location = json.get("Location").getAsString();
            dish = json.get("Dish").getAsString();
            time = json.get("Time").getAsString();
             dinnerevent = new Dinnerevent(price, location, dish, time, blankList);
        }catch(Exception e){
            throw new API_Exception("Malformed JSON suplied", 400, e);
        }
        
        emf.getTransaction().begin();
        emf.persist(dinnerevent);
        emf.getTransaction().commit();
    }
}
