/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author albie
 */
public class UnpackingDTO {
    private RenameMeDTO[] data;
    
    public UnpackingDTO(RenameMeDTO[] data){
        this.data = data;
    }
    
    public RenameMeDTO[] getData(){
        return data;
    }
    
    public void setData(RenameMeDTO[] data){
        this.data = data;
    }
}
