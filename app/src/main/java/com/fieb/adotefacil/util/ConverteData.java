package com.fieb.adotefacil.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverteData {
    /** DATA **/
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Date data = new Date();
    public Date dataBanco(String dataString)   {
        try {
            data = formato.parse(dataString);
        }catch (Exception e){
            System.out.println("ERRO CONVERTER DATA: "+e.getMessage());
            return null;
        }

       return (new java.sql.Date(data.getTime()));
    }
}
