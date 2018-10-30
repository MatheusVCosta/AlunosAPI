package br.com.senaijandira.alunos.service;

import java.util.List;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.model.ApiResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AlunoService {

    String URL_BASE = "http://10.0.2.2:5001/";

    //endPoints
    @GET("/alunos")
    //usando lista pois vai vim uma array do servidor
    //Call uma chamada que será executada mais tarde
    Call<List<Aluno>> obterAlunos();

    //quando passar um objeto inteiro usar o @body
    //ApiREsult fica dentro de uma call para retonar um True
    @POST("/novo")
    Call<ApiResult> cadastrarAluno(@Body Aluno aluno);


}
