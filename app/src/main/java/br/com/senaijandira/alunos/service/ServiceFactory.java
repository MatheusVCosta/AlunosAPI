package br.com.senaijandira.alunos.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    public static AlunoService create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AlunoService.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(AlunoService.class);
    }
}
