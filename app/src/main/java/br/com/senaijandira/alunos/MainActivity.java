package br.com.senaijandira.alunos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.senaijandira.alunos.adapter.AlunoAdapter;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.service.ServiceFactory;

//quando um método é implementado é obrigatorio criar os métodos da classe de contrato
public class MainActivity extends AppCompatActivity  implements  MainView{


    ListView listView;
    AlunoAdapter adapter;

    //Declarando a progressBar
    ProgressBar progressbar;

    MainPresenter presenter;


    //NO MANIFEST DA PERMISSAO PARA O NAVEGADOR
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        progressbar = findViewById(R.id.progressBar);
        listView = findViewById(R.id.listView);
        //instanciar o adapter
        adapter = new AlunoAdapter(this);

        //Plugar o adapter na lista
        listView.setAdapter(adapter);

        //Configurando o presenter
        presenter = new MainPresenter(this, ServiceFactory.create());

        presenter.carregarAluno();

    }

    //Método para adicionar alunos no adapter
    //è preciso usar o @override para dizer que o método da classe de contrado foi rescrito
    @Override
    public void preencherLista(List<Aluno> lstAlunos){
        //Limpando o adapter
        adapter.clear();
        //adicionando alunos na lista
        adapter.addAll(lstAlunos);
    }
    //método para exibir a barra de progresso
    @Override
    public void exibirBarraProgresso(){
        progressbar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
    }
    //esconder a barra de progresso
    @Override
    public void esconderBarraProgresso(){
        progressbar.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
    }

}
