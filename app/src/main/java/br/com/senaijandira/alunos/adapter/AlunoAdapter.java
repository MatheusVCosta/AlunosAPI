package br.com.senaijandira.alunos.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.model.Aluno;

public class AlunoAdapter extends ArrayAdapter<Aluno> {

    //Criando um construtor pois um adapter precisa de um
    public AlunoAdapter(Context ctx){
        //Construtor padrão, criando uma lista vazia
        super(ctx, 0, new ArrayList<Aluno>());
    }

    //padrão chmar o getview, que vai criar cada bloca do layout
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        //se o v for nulo é a primeria vez que esta chgando aqui
        if(v == null){
            //O v vai inflar o layout do list_view_item
            v = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item, parent, false);
        }

        //Criar uma variavel do tipo aluno que ira receber a posição de acordo com o layout
        Aluno aluno = getItem(position);
        TextView txtNome = v.findViewById(R.id.txtNomeAluno);
        TextView txtMatricula = v.findViewById(R.id.txtMatriculaAluno);

        txtMatricula.setText(aluno.getMatricula()+"");
        txtNome.setText(aluno.getNome());

        //Recusividade, sera chamado a mesma função isso ficara em um loop
        return v;
    }
}
