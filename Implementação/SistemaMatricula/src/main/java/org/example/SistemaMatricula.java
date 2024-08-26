package org.example;

import java.util.ArrayList;
import java.util.List;

public class SistemaMatricula {

    private List<Curso> cursos;
    private List<Aluno> alunos;

    public SistemaMatricula() {
        this.cursos = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public void adicionaCurso(Curso curso) {
        cursos.add(curso);
    }

    public void cadastraAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void realizaMatricula(Aluno aluno, Disciplina disciplina) {
        if (disciplina.matricularAluno(aluno)) {
            System.out.println("Aluno " + aluno.getNome() + " matriculado na disciplina " + disciplina.getNome());
        } else {
            System.out.println("Não foi possível matricular o aluno " + aluno.getNome() + " na disciplina " + disciplina.getNome());
        }
    }

    public void verificaStatusDisciplinas() {
        for (Curso curso : cursos) {
            for (Disciplina disciplina : curso.getDisciplinas()) {
                if (disciplina.isAtiva()) {
                    System.out.println("Disciplina ativa: " + disciplina.getNome());
                } else {
                    System.out.println("Disciplina cancelada: " + disciplina.getNome());
                }
            }
        }
    }
}
