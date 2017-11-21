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
public class Function {
    int IdFunction;
    String Name;

    public Function(int idFunction, String name) {
        this.IdFunction = idFunction;
        this.Name = name;
    }

    
    public int getIdFunction() {
        return IdFunction;
    }

    public void setIdFunction(int idFunction) {
        this.IdFunction = idFunction;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
    
    
}
