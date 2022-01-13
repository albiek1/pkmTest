/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.google.gson.Gson;
import dtos.CombinedDTO;
import dtos.RenameMeDTO;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author albie
 */
public class HttpUtils {
    
    private static Gson gson = new Gson();
    
    public static CombinedDTO fetchDataParallel(){
        ExecutorService es = Executors.newCachedThreadPool();
        Future<RenameMeDTO> renamemeDTOFuture = es.submit(
                () -> gson.fromJson(HttpUtils.fetchData(""), RenameMeDTO.class)
                );
        
        //same as above
        
        //DTO1 dto1 = dto1future.get();
        //combine here
        CombinedDTO combinedDTO = new CombinedDTO();
        return combinedDTO;
    }
    
    public static String fetchData(String _url)throws MalformedURLException, IOException{
        URL url = new URL(_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "server");
        
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if(scan.hasNext()){
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }
    
    public static String searchData(String _url, String searchString) throws MalformedURLException, IOException{
        URL url = new URL(_url+searchString);
        //if api key is required use _url+apiKey+"&q="+searchString
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "server");
        
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if(scan.hasNext()){
            jsonStr = scan.nextLine();
        }
        scan.close();
        
        return jsonStr;
    }
}
