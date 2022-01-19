/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import entities.Pkmon;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author albie
 */
@Path("Pkmon")
public class PkmonResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allPkmon(){
        EntityManager em = EMF.createEntityManager();
        try{
            TypedQuery<Pkmon> query = em.createQuery("SELECT * FROM Pokemon", Pkmon.class);
            List<Pkmon> pkmons = query.getResultList();
            String pkmonString = "";
            for(Pkmon pkmon : pkmons){
                pkmonString += pkmon.getName() + ", ";
            }
            return pkmonString;
        }finally{
            em.close();
        }
    }
}
