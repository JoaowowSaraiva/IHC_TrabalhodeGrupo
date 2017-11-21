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
public class MemberConcert {
    private int Member;
    private int Concert;
    private double Payment;
    private int Status;

    public MemberConcert() {
    }

    public MemberConcert(int Member, int Concert, double Payment, int Status) {
        this.Member = Member;
        this.Concert = Concert;
        this.Payment = Payment;
        this.Status = Status;
    }

 

    public int getMember() {
        return Member;
    }

    public void setMember(int Member) {
        this.Member = Member;
    }

    public int getConcert() {
        return Concert;
    }

    public void setConcert(int Concert) {
        this.Concert = Concert;
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
    
    
    
}
