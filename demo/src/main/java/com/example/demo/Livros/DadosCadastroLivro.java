package com.example.demo.Livros;

public class DadosCadastroLivro {
    private  String titulo;
    private String autor;
    private int edicao;
    private int ano;

    public DadosCadastroLivro(String titulo, String autor, int edicao, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "DadosCadastroLivro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", edicao=" + edicao +
                ", ano=" + ano +
                '}';
    }
}


