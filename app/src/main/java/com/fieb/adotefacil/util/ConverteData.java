package com.fieb.adotefacil.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String calculaIdade(Date data){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);

        int anoNascimento = calendar.get(Calendar.YEAR);
        int mesNascimento = calendar.get(Calendar.MONTH) + 1; // Lembrando que o mês começa em zero

        LocalDate dataNascimento = LocalDate.of(anoNascimento, mesNascimento, 1); // Define o dia como 1 para simplificar o cálculo

        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataNascimento, hoje);
        int anos = periodo.getYears();
        int meses = periodo.getMonths();

        String idadeFormatada = anos + " anos e " + meses + " meses";
        return idadeFormatada;
    }


}
