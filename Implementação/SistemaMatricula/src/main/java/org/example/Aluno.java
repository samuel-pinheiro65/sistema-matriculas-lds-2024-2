package org.example;

import java.util.List;

public class Aluno {
    private long numMatricula;
    private String nome;
    private List<Disciplina> disciplinasMatriculadas;

    public Aluno(String nome, long numMatricula) {
        this.nome = nome;
        this.numMatricula = numMatricula;
        this.disciplinasMatriculadas = disciplinasMatriculadas;
    }


    public String getNome() {
        return nome;
    }

    public long getNumMatricula() {
        return numMatricula;
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public void matricularDisciplina(Disciplina disciplina) {
        disciplinasMatriculadas.add(disciplina);
    }
}
