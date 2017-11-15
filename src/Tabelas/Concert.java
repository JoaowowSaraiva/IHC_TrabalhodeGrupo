/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

import java.sql.SQLData;

/**
 *
 * @author smf_1
 */
public class Concert {
    private int Local;
    private SQLData DataHora;
    private double Payment;
    private int Status;
    private int Vehicles;
    private int Fatura;

    public Concert(int Local, SQLData DataHora, int Status, int Fatura) {
        this.Local = Local;
        this.DataHora = DataHora;
        this.Status = Status;
        this.Fatura = Fatura;
    }
    
    
    
    public int getLocal() {
        return Local;
    }

    public void setLocal(int Local) {
        this.Local = Local;
    }

    public SQLData getDataHora() {
        return DataHora;
    }

    public void setDataHora(SQLData DataHora) {
        this.DataHora = DataHora;
    }

    public double getPayment() {
        return Payment;
    }

    public void setPayment(double Payment) {
        this.Payment = Payment;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getVehicles() {
        return Vehicles;
    }

    public void setVehicles(int Vehicles) {
        this.Vehicles = Vehicles;
    }

    public int getFatura() {
        return Fatura;
    }

    public void setFatura(int Fatura) {
        this.Fatura = Fatura;
    }
    
    
}
