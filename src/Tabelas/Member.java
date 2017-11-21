/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

/**
 *
 * @author Joao Saraiva
 */
public class Member {
    private int IdMember;
    private String FirstName;
    private String LastName;

    public Member(int idMember, String FirstName, String LastName) {
        this.IdMember = idMember;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public int getIdMember() {
        return IdMember;
    }

    public void setIdMember(int idMember) {
        this.IdMember = idMember;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    
    
}
