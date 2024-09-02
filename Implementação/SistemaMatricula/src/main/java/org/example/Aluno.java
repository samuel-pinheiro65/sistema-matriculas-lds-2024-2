package org.example;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private long numMatricula;
    private String nome;
    private String senha;
    private List<Disciplina> disciplinasMatriculadas;
    private List<Disciplina> disciplinasOptativas;

    public Aluno(String nome, long numMatricula, String senha) {
        this.nome = nome;
        this.numMatricula = numMatricula;
        this.senha = senha;
        this.disciplinasMatriculadas = new ArrayList<>();
        this.disciplinasOptativas = new ArrayList<>();
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

    public List<Disciplina> getDisciplinasOptativas() {
        return disciplinasOptativas;
    }

    public boolean matricularDisciplina(Disciplina disciplina, boolean obrigatoria) {
        if (obrigatoria) {
            if (disciplinasMatriculadas.size() < 4 && !disciplinasMatriculadas.contains(disciplina)) {
                disciplinasMatriculadas.add(disciplina);
                return true;
            }
        } else {
            if (disciplinasOptativas.size() < 2 && !disciplinasOptativas.contains(disciplina)) {
                disciplinasOptativas.add(disciplina);
                return true;
            }
        }
        return false;
    }

    public void cancelarMatricula(Disciplina disciplina) {
        disciplinasMatriculadas.remove(disciplina);
        disciplinasOptativas.remove(disciplina);
    }
}
