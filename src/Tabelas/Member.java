/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

import java.time.LocalDate;

/**
 *
 * @author Joao Saraiva
 */
public class Member {
    private int IdMember;
    private String FirstName;
    private String LastName;
    private String Birthday;
    
    public Member(){     
    }
    public Member(int IdMember, String FirstName, String LastName, String Birthday) {
        this.IdMember = IdMember;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Birthday = Birthday;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
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
