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
public class StudentClass {
    private int IdStudent;
    private int IdFunction;
    private int IdMember;
    private int IdClass;
    private int Status;

    public StudentClass(int IdStudent, int IdFunction, int IdMember, int IdClass, int Status) {
        this.IdStudent = IdStudent;
        this.IdFunction = IdFunction;
        this.IdMember = IdMember;
        this.IdClass = IdClass;
        this.Status = Status;
    }

    public int getIdStudent() {
        return IdStudent;
    }

    public void setIdStudent(int IdStudent) {
        this.IdStudent = IdStudent;
    }

    public int getIdFunction() {
        return IdFunction;
    }

    public void setIdFunction(int IdFunction) {
        this.IdFunction = IdFunction;
    }

    public int getIdMember() {
        return IdMember;
    }

    public void setIdMember(int IdMember) {
        this.IdMember = IdMember;
    }

    public int getIdClass() {
        return IdClass;
    }

    public void setIdClass(int IdClass) {
        this.IdClass = IdClass;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }






}