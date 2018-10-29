package br.com.senaijandira.alunos;

import android.util.Log;

import java.util.List;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.service.AlunoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {


    //referencia da mainView
    //ligando essa classe com a mainActivity usando a mainView
    MainView mainView;
    AlunoService service;

    //injeção de dependecia
    public MainPresenter(MainView mainViewm, AlunoService service) {
        this.mainView = mainViewm;
        this.service = service;
    }

    public void carregarAluno() {

//        //Criar o serviço que chama a API
//        AlunoService service = ServiceFactory.create();

        //Objeto de chamada a API de alunos
        Call<List<Aluno>> call = service.obterAlunos();

        //vai mostrar a barra de progresso
        mainView.exibirBarraProgresso();

        //Efetuar a chamada a API//Recebe como parametro um callBack com a lista de alunos
        call.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {

                //Lista de alunos retornada pelo servidor
                List<Aluno> alunos = response.body();

                for (Aluno a : alunos) {
                    Log.d("API_ALUNOS", a.getNome());
                }
                //Exibir os alunos na tela
                mainView.preencherLista(alunos);

                //vai esconder a barra de progresso e mostrar a lista
                mainView.esconderBarraProgresso();
            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                Log.e("ERRO_API", t.getMessage());
            }
        });

    }
}
