package org.example;

public static void main(String[] args) {
    // Configuração inicial do sistema
    SistemaMatricula sistema = new SistemaMatricula();

    Professor prof1 = new Professor("Dr. João");
    Professor prof2 = new Professor("Dra. Maria");

    Curso cursoEngenharia = new Curso("Engenharia");
    Disciplina d1 = new Disciplina("Matemática", prof1);
    Disciplina d2 = new Disciplina("Física", prof2);

    cursoEngenharia.adicionarDisciplina(d1);
    cursoEngenharia.adicionarDisciplina(d2);

    sistema.adicionaCurso(cursoEngenharia);

    Aluno aluno1 = new Aluno("Pedro Silva", 799348);
    sistema.cadastraAluno(aluno1);

    // Realizando matrículas
    sistema.realizaMatricula(aluno1, d1);
    sistema.realizaMatricula(aluno1, d2);

    // Verificando o status das disciplinas
    sistema.verificaStatusDisciplinas();
}
}