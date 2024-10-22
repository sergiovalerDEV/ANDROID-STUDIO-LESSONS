package com.example.loginandroid_29_09_2023.lstMov.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Pelicula;

import java.util.ArrayList;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {
    private final ArrayList<Pelicula> peliculas;
    private final Context context;

    public PeliculaAdapter(Context context, ArrayList<Pelicula> peliculas) {
        this.context = context;
        this.peliculas = peliculas;

        for (Pelicula p : peliculas) {
            Log.d("PeliculaDebug", "Título: " + p.getTitulo() + ", URL Imagen: " + p.getUrlimagen());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.tvTitulo.setText(pelicula.getTitulo());
        holder.tvDescripcion.setText(pelicula.getDescripcion());
        holder.tvDirector.setText(pelicula.getDirector());
        holder.tvAnyo.setText(String.valueOf(pelicula.getAnyo()));

        String urlImagen = pelicula.getUrlimagen();
        Log.d("PeliculaAdapter", "Cargando imagen desde URL: " + urlImagen); // Log de URL

        Glide.with(context)
                .load(urlImagen) // Carga la imagen desde la URL
                .into(holder.ivPeliculaImagen); // Establece la imagen en el ImageView
    }


    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitulo, tvDescripcion, tvDirector, tvAnyo;
        public ImageView ivPeliculaImagen;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvDirector = itemView.findViewById(R.id.tvDirector);
            tvAnyo = itemView.findViewById(R.id.tvAnyo);
            ivPeliculaImagen = itemView.findViewById(R.id.ivPeliculaImagen);
        }
    }
}
