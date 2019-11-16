package com.integrador.apresentação.Adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.integrador.apresetação.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> imagens = new ArrayList<>();
    private ArrayList<String> precos = new ArrayList<>();
    private ArrayList<String> nomes = new ArrayList<>();
    private Context context;

    

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imagem;
        TextView nome;
        TextView preco;
        TextView localizacao;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imagem = itemView.findViewById(R.id.iv_image);
            this.nome = itemView.findViewById(R.id.tv_nome);
            this.preco = itemView.findViewById(R.id.tv_preco);
            this.localizacao = itemView.findViewById(R.id.tv_localizacao);
            this.constraintLayout = itemView.findViewById(R.id.constraint);
        }
    }

}
