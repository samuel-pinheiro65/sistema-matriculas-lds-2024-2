package org.example;

public class MatriculaAlunos {
    public long numMatricula;
    private Aluno aluno;
    private Curso curso
    private Disciplina disciplina;

    public MatriculaAlunos(long numMatricula, Aluno aluno, Curso curso, Disciplina disciplina) {
        this.numMatricula = numMatricula;
        this.aluno = aluno;
        this.curso = curso;
        this.disciplina = disciplina;
    }

    public long getNumMatricula() {
        return numMatricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}

}
