package org.example;

import java.util.ArrayList;
import java.util.List;

public class SistemaMatricula {
    private List<Curso> cursos;
    private List<Aluno> alunos;
    private boolean periodoMatriculaAberto;

    public SistemaMatricula() {
        this.cursos = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.periodoMatriculaAberto = false;
    }

    public void abrirPeriodoMatricula() {
        periodoMatriculaAberto = true;
    }

    public void fecharPeriodoMatricula() {
        periodoMatriculaAberto = false;
        verificarDisciplinasAtivas();
    }

    public void adicionaCurso(Curso curso) {
        cursos.add(curso);
    }

    public void cadastraAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public Aluno getAlunoByNumMatricula(long numMatricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getNumMatricula() == numMatricula) {
                return aluno;
            }
        }
        return null;
    }

    public Professor getProfessorByNome(String nome) {
        for (Curso curso : cursos) {
            for (Disciplina disciplina : curso.getDisciplinas()) {
                if (disciplina.getProfessor().getNome().equalsIgnoreCase(nome)) {
                    return disciplina.getProfessor();
                }
            }
        }
        return null;
    }

    public void realizaMatricula(Aluno aluno, Disciplina disciplina, boolean obrigatoria) {
        if (!periodoMatriculaAberto) {
            System.out.println("Período de matrícula fechado.");
            return;
        }

        boolean matriculado = disciplina.matricularAluno(aluno);
        if (matriculado) {
            System.out.println("Aluno " + aluno.getNome() + " matriculado na disciplina " + disciplina.getNome() + (obrigatoria ? " (obrigatória)" : " (optativa)"));
            aluno.matricularDisciplina(disciplina, obrigatoria);
            notificarSistemaCobrancas(aluno, disciplina);
        } else {
            System.out.println("Não foi possível matricular o aluno " + aluno.getNome() + " na disciplina " + disciplina.getNome());
        }
    }

    public void cancelarMatricula(Aluno aluno, Disciplina disciplina) {
        if (!periodoMatriculaAberto) {
            System.out.println("Período de matrícula fechado.");
            return;
        }

        disciplina.cancelarMatricula(aluno);
        aluno.cancelarMatricula(disciplina);
        System.out.println("Matrícula cancelada na disciplina " + disciplina.getNome() + " para o aluno " + aluno.getNome());
    }

    public void verificarDisciplinasAtivas() {
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

    private void notificarSistemaCobrancas(Aluno aluno, Disciplina disciplina) {
        System.out.println("Sistema de cobranças notificado: Aluno " + aluno.getNome() + " será cobrado pela disciplina " + disciplina.getNome());
    }
}
