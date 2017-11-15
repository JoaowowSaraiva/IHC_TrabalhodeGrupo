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
public class StudentMemberFunction {
    private int idStudent;
    private int IdFunction;
    private int IdMember;
    private int idClass;
    private int status;

    public StudentMemberFunction(int idStudent, int IdFunction, int IdMember, int idClass, int status) {
        this.idStudent = idStudent;
        this.IdFunction = IdFunction;
        this.IdMember = IdMember;
        this.idClass = idClass;
        this.status = status;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
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
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
