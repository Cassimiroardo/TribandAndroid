package com.integrador.apresentação.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.integrador.apresentação.Interfaces.PerfilEstudioActivity;
import com.integrador.apresentação.Interfaces.PesquisarActivity;
import com.integrador.apresetação.R;
import com.integrador.model.Estudio;
import com.integrador.services.EstudioService;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Long> ids = new ArrayList<>();
    private ArrayList<String> imagens = new ArrayList<>();
    private ArrayList<String> precos = new ArrayList<>();
    private ArrayList<String> nomes = new ArrayList<>();
    private ArrayList<String> localizacoes = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<Long> ids, ArrayList<String> imagens, ArrayList<String> precos, ArrayList<String> nomes, ArrayList<String> localizacoes) {
        this.ids = ids;
        this.imagens = imagens;
        this.precos = precos;
        this.nomes = nomes;
        this.localizacoes = localizacoes;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        //colocar as imagens ?????

        Glide.with(context)
                .asBitmap()
                .load(imagens.get(position))
                .into(holder.imagem);

        holder.nome.setText(nomes.get(position));
        holder.preco.setText("R$ " + precos.get(position));
        holder.localizacao.setText(localizacoes.get(position));

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PerfilEstudioActivity.class);
                intent.putExtra("estudioId", ids.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imagens.size();
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
