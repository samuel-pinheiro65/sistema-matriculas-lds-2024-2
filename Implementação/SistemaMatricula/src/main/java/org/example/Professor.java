package org.example;

import java.util.List;

public class Professor {
    private int id;
    private String nome;
    private List<Disciplina> disciplinasLecionadas;

    public Professor(String nome) {
        this.nome = nome;
        this.disciplinasLecionadas = disciplinasLecionadas;
    }

    public String getNome() {
        return nome;
    }

    public List<Aluno> getAlunosMatriculados() {
        List<Aluno> alunosMatriculados = List.of();
        return alunosMatriculados;
    }
}

