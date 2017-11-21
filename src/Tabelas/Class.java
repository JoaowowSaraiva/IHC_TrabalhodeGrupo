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
public class Class {
    private int IdClass;
    private SQLData Date;

    public Class(int idClass, SQLData Date) {
        this.IdClass = idClass;
        this.Date = Date;
    }

    public int getIdClass() {
        return IdClass;
    }

    public void setIdClass(int idClass) {
        this.IdClass = idClass;
    }

    public SQLData getDate() {
        return Date;
    }

    public void setDate(SQLData Date) {
        this.Date = Date;
    }
}
