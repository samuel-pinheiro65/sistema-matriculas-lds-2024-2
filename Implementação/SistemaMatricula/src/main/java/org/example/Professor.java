package org.example;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private int id;
    private String nome;
    private String senha;
    private List<Disciplina> disciplinasLecionadas;

    public Professor(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.disciplinasLecionadas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }

    public List<Disciplina> getDisciplinasLecionadas() {
        return disciplinasLecionadas;
    }

    public List<Aluno> getAlunosMatriculados(Disciplina disciplina) {
        return disciplina.getAlunosMatriculados();
    }

    public void adicionarDisciplinaLecionada(Disciplina disciplina) {
        disciplinasLecionadas.add(disciplina);
    }
}