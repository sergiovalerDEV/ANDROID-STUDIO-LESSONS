package com.example.loginandroid_29_09_2023.beans;

public class Pelicula {
    private int id;
    private String titulo;
    private String descripcion;
    private String director;
    private int anyo;
    private String urlImagen; //Mayúscula fundamental, esto debe
    //llamarse igual que en la BD para evitar errores y poder mostrar
    //nuestras imágenes (El enlace puede venir de google o de un Amazon S3)

    public Pelicula(int id, String titulo, String descripcion, String director, int anyo, String urlimagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.director = director;
        this.anyo = anyo;
        this.urlImagen = urlimagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getUrlimagen() {
        return urlImagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlImagen = urlimagen;
    }
}