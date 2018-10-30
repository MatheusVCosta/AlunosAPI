package br.com.senaijandira.alunos.util;

public class DateUtil {
    public int convertToInt (String data){
        //TODO:fazer a logica

        //quebrar a string a partir do /
        //01/01/1999
        String[] dataSplit = data.split("/");

        String dia = dataSplit[0];
        String mes = dataSplit[1];
        String ano = dataSplit[2];

        String dataFormatada = ano + mes + dia;

        return Integer.parseInt(dataFormatada);
    }

}
