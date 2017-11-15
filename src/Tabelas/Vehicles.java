/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

/**
 *
 * @author smf_1
 */
public class Vehicles {
    private int idVehicles;
    private String NumberPlate;
    private int idMember;
    private int Part;

    public Vehicles(int idVehicles, String NumberPlate, int idMember, int Part) {
        this.idVehicles = idVehicles;
        this.NumberPlate = NumberPlate;
        this.idMember = idMember;
        this.Part = Part;
    }

    public int getIdVehicles() {
        return idVehicles;
    }

    public void setIdVehicles(int idVehicles) {
        this.idVehicles = idVehicles;
    }

    public String getNumberPlate() {
        return NumberPlate;
    }

    public void setNumberPlate(String NumberPlate) {
        this.NumberPlate = NumberPlate;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public int getPart() {
        return Part;
    }

    public void setPart(int Part) {
        this.Part = Part;
    }
    
}
