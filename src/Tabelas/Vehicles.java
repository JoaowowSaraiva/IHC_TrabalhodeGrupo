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
    private int IdVehicles;
    private String NumberPlate;
    private int IdMember;
    private int Part;

    public Vehicles(int IdVehicles, String NumberPlate, int IdMember, int Part) {
        this.IdVehicles = IdVehicles;
        this.NumberPlate = NumberPlate;
        this.IdMember = IdMember;
        this.Part = Part;
    }

    public int getIdVehicles() {
        return IdVehicles;
    }

    public void setIdVehicles(int IdVehicles) {
        this.IdVehicles = IdVehicles;
    }

    public String getNumberPlate() {
        return NumberPlate;
    }

    public void setNumberPlate(String NumberPlate) {
        this.NumberPlate = NumberPlate;
    }

    public int getIdMember() {
        return IdMember;
    }

    public void setIdMember(int IdMember) {
        this.IdMember = IdMember;
    }

    public int getPart() {
        return Part;
    }

    public void setPart(int Part) {
        this.Part = Part;
    }
    


}