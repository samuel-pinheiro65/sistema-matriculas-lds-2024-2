package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaMatricula sistema = new SistemaMatricula();

        Professor prof1 = new Professor("Cleber", "123456");
        Professor prof2 = new Professor("Ione", "123456");
        Professor prof3 = new Professor("Marcos", "123456");
        Professor prof4 = new Professor("Bruno", "123456");
        Professor prof5 = new Professor("Claudia", "123456");

        Curso cursoEngenhariaSoftware = new Curso("Engenharia de Software", 40);
        Disciplina d1 = new Disciplina("Aed", prof1);
        Disciplina d2 = new Disciplina("Arquitetura de Software", prof3);
        Disciplina d3 = new Disciplina("Redes", prof4);
        Disciplina d4 = new Disciplina("TIS", prof1);
        Disciplina d5 = new Disciplina("Gerencia (Optativa)", prof5);
        Disciplina d6 = new Disciplina("Filosofia (Optativa)", prof2);

        cursoEngenhariaSoftware.adicionarDisciplina(d1);
        cursoEngenhariaSoftware.adicionarDisciplina(d2);
        cursoEngenhariaSoftware.adicionarDisciplina(d3);
        cursoEngenhariaSoftware.adicionarDisciplina(d4);
        cursoEngenhariaSoftware.adicionarDisciplina(d5);
        cursoEngenhariaSoftware.adicionarDisciplina(d6);

        sistema.adicionaCurso(cursoEngenhariaSoftware);

        while (true) {
            System.out.println("Menu do Sistema de Matrícula:");
            System.out.println("1. Abrir período de matrícula");
            System.out.println("2. Fechar período de matrícula");
            System.out.println("3. Cadastrar um novo aluno");
            System.out.println("4. Realizar matrícula em disciplinas");
            System.out.println("5. Cancelar matrícula");
            System.out.println("6. Verificar disciplinas ativas");
            System.out.println("7. Ver alunos matriculados em uma disciplina");
            System.out.println("8. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    sistema.abrirPeriodoMatricula();
                    System.out.println("Período de matrícula aberto.");
                    break;
                case 2:
                    sistema.fecharPeriodoMatricula();
                    System.out.println("Período de matrícula fechado.");
                    break;
                case 3:
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = scanner.nextLine();
                    System.out.print("Digite o número de matrícula: ");
                    long numMatricula = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Digite a senha do aluno: ");
                    String senhaAluno = scanner.nextLine();
                    Aluno novoAluno = new Aluno(nomeAluno, numMatricula, senhaAluno);
                    sistema.cadastraAluno(novoAluno);
                    System.out.println("Aluno cadastrado com sucesso.");
                    break;
                case 4:
                    System.out.print("Digite o número de matrícula do aluno: ");
                    long numMatriculaAluno = scanner.nextLong();
                    scanner.nextLine();
                    Aluno aluno = sistema.getAlunoByNumMatricula(numMatriculaAluno);

                    if (aluno == null) {
                        System.out.println("Aluno não encontrado.");
                        break;
                    }

                    System.out.println("Escolha as disciplinas para matrícula (obrigatórias):");
                    List<Disciplina> obrigatorias = escolherDisciplinas(scanner, cursoEngenhariaSoftware, 4);
                    for (Disciplina disciplina : obrigatorias) {
                        sistema.realizaMatricula(aluno, disciplina, true);
                    }

                    System.out.println("Escolha as disciplinas para matrícula (optativas):");
                    List<Disciplina> optativas = escolherDisciplinas(scanner, cursoEngenhariaSoftware, 2);
                    for (Disciplina disciplina : optativas) {
                        sistema.realizaMatricula(aluno, disciplina, false);
                    }

                    break;
                case 5:
                    System.out.print("Digite o número de matrícula do aluno: ");
                    long numMatriculaCancelar = scanner.nextLong();
                    scanner.nextLine();
                    Aluno alunoCancelar = sistema.getAlunoByNumMatricula(numMatriculaCancelar);

                    if (alunoCancelar == null) {
                        System.out.println("Aluno não encontrado.");
                        break;
                    }

                    System.out.println("Escolha a disciplina para cancelar:");
                    List<Disciplina> disciplinasMatriculadas = alunoCancelar.getDisciplinasMatriculadas();
                    List<Disciplina> disciplinasOptativas = alunoCancelar.getDisciplinasOptativas();
                    List<Disciplina> todasDisciplinas = new ArrayList<>(disciplinasMatriculadas);
                    todasDisciplinas.addAll(disciplinasOptativas);

                    for (int i = 0; i < todasDisciplinas.size(); i++) {
                        System.out.println((i + 1) + ". " + todasDisciplinas.get(i).getNome());
                    }
                    int disciplinaIndex = scanner.nextInt() - 1;
                    if (disciplinaIndex >= 0 && disciplinaIndex < todasDisciplinas.size()) {
                        sistema.cancelarMatricula(alunoCancelar, todasDisciplinas.get(disciplinaIndex));
                    } else {
                        System.out.println("Escolha inválida.");
                    }
                    break;
                case 6:
                    sistema.verificarDisciplinasAtivas();
                    break;
                case 7:
                    System.out.print("Digite o nome do professor: ");
                    String nomeProfessor = scanner.nextLine();
                    System.out.print("Digite a senha do professor: ");
                    String senhaProfessor = scanner.nextLine();
                    Professor professor = sistema.getProfessorByNome(nomeProfessor);

                    if (professor != null && professor.validarSenha(senhaProfessor)) {
                        List<Disciplina> disciplinasLecionadas = professor.getDisciplinasLecionadas();
                        if (disciplinasLecionadas.isEmpty()) {
                            System.out.println("O professor " + professor.getNome() + " não está lecionando nenhuma disciplina.");
                        } else {
                            for (Disciplina disciplina : disciplinasLecionadas) {
                                System.out.println("\nAlunos matriculados na disciplina " + disciplina.getNome() + ":");
                                List<Aluno> alunosMatriculados = disciplina.getAlunosMatriculados();
                                if (alunosMatriculados.isEmpty()) {
                                    System.out.println("Nenhum aluno matriculado.");
                                } else {
                                    for (Aluno alunoMatriculado : alunosMatriculados) {
                                        System.out.println("- " + alunoMatriculado.getNome());
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Professor não encontrado ou senha incorreta.");
                    }
                    break;
                case 8:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static List<Disciplina> escolherDisciplinas(Scanner scanner, Curso curso, int maxDisciplinas) {
        List<Disciplina> disciplinasEscolhidas = new ArrayList<>();
        List<Disciplina> todasDisciplinas = curso.getDisciplinas();

        for (int i = 0; i < maxDisciplinas; i++) {
            System.out.println("Escolha a disciplina " + (i + 1) + ":");
            for (int j = 0; j < todasDisciplinas.size(); j++) {
                System.out.println((j + 1) + ". " + todasDisciplinas.get(j).getNome());
            }

            int opcao = scanner.nextInt() - 1;
            if (opcao >= 0 && opcao < todasDisciplinas.size()) {
                disciplinasEscolhidas.add(todasDisciplinas.get(opcao));
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                i--; // Permitir que o usuário escolha novamente
            }
        }

        return disciplinasEscolhidas;
    }
}
