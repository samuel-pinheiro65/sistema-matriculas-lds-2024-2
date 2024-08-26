package org.example;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private long id;
    private String nome;
    private List<Disciplina> disciplinas;

    public Curso(String nome) {
        this.nome = nome;
    }

    public Curso(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }
}

