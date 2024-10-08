package org.example;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private Professor professor;
    private int numeroMinimoAlunos = 3;
    private int numeroMaximoAlunos = 60;
    private List<Aluno> alunosMatriculados;

    public Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
        this.alunosMatriculados = new ArrayList<>();
        professor.adicionarDisciplinaLecionada(this); // Adiciona a disciplina ao professor
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public boolean matricularAluno(Aluno aluno) {
        if (alunosMatriculados.size() < numeroMaximoAlunos) {
            alunosMatriculados.add(aluno);
            return true;
        } else {
            System.out.println("Disciplina sem vagas: " + nome);
            return false;
        }
    }

    public void cancelarMatricula(Aluno aluno) {
        alunosMatriculados.remove(aluno);
    }

    public boolean isAtiva() {
        return alunosMatriculados.size() >= numeroMinimoAlunos;
    }
}
