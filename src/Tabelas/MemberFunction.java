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
public class MemberFunction {
    private int IdFunction;
    private int IdMember;

    public MemberFunction(int idFunction, int idMember) {
        this.IdFunction = idFunction;
        this.IdMember = idMember;
    }

    public int getIdFunction() {
        return IdFunction;
    }

    public void setIdFunction(int idFunction) {
        this.IdFunction = idFunction;
    }

    public int getIdMember() {
        return IdMember;
    }

    public void setIdMember(int idMember) {
        this.IdMember = idMember;
    }

}
