package UI;

import model.*;
import repository.*;
import service.*;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private AlunoRepository alunoRepository = new AlunoRepository();
    private ProfessorRepository professorRepository = new ProfessorRepository();
    private CursoRepository cursoRepository = new CursoRepository();
    private TurmaRepository turmaRepository = new TurmaRepository();
    private TurmaService turmaService = new TurmaService(turmaRepository, alunoRepository, professorRepository, cursoRepository);

    public void MostrarMenu() {
        while (true) {
            System.out.println("========================//===================");
            System.out.println("\n ----- Sistema de Gestão Educacional (SGE) -----");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Professor");
            System.out.println("3 - Cadastrar Curso");
            System.out.println("4 - Criar Turma");
            System.out.println("5 - Adicionar Aluno à Turma");
            System.out.println("6 - Registrar Avaliação");
            System.out.println("7 - Gerar Relatórios");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno(); 
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    cadastrarCurso();
                    break;
                case 4:
                    criarTurma();
                    break;
                case 5:
                    adicionarAlunoATurma();
                    break;
                case 6:
                    registrarAvaliacao();
                    break;
                case 7:
                    gerarRelatorios();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

   private void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Login: ");
        String login = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();

        System.out.print("Curso: ");
        String curso = sc.nextLine();

        if (alunoRepository.buscaPorMatricula(matricula) != null) {
            System.out.println("Já existe um aluno com essa matrícula!");
            return;
        }

        alunoRepository.salvar(new Aluno(nome, login, senha, matricula, curso));
        System.out.println("Aluno cadastrado com sucesso!");
        
    }

    private void cadastrarProfessor() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Login: ");
        String login = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        System.out.print("Especialidade: ");
        String especialidade = sc.nextLine();

        System.out.print("Registro: ");
        String registro = sc.nextLine();

        if (professorRepository.buscaPorRegistro(registro) != null) {
            System.out.println("Já existe um professor com esse registro!");
            return;
        }

        professorRepository.salvar(new Professor(nome, login, senha, especialidade, registro));
        System.out.println("Professor cadastrado com sucesso!");
    }

     private void cadastrarCurso() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Código: ");
        String codigo = sc.nextLine();

        if (cursoRepository.buscaPorCodigo(codigo) != null) {
           System.out.println("Já existe um curso com esse código! Cadastro cancelado.");
       return;
       }

        System.out.print("Carga Horária: ");
        int carga = sc.nextInt();
        sc.nextLine();

        System.out.print("Tipo (1 - Presencial, 2 - EAD): ");
        int tipo = sc.nextInt();
        sc.nextLine();


        if (tipo == 1) {
            System.out.print("Sala: ");
            String sala = sc.nextLine();
            CursoPresencial curso = new CursoPresencial(nome, codigo, carga, sala);
            cursoRepository.salvar(curso);
        } else {
            System.out.print("Plataforma: ");
            String plataforma = sc.nextLine();

            CursoEAD curso = new CursoEAD(nome, codigo, carga, plataforma);
            cursoRepository.salvar(curso);
        }
        System.out.println("Curso cadastrado.");
    }
    private void criarTurma() {
        System.out.print("Código da Turma: ");
        String codigo = sc.nextLine();
       if (turmaRepository.buscarPorCodigo(codigo) != null) {
           System.out.println("Já existe uma turma com esse código! Cadastro cancelado.");
        return;
       }

        System.out.print("Registro do Professor: ");
        String registro = sc.nextLine();

        System.out.print("Código do Curso: ");
        String codigoCurso = sc.nextLine();

        turmaService.criarTurma(codigo, registro, codigoCurso);
    }
    private void adicionarAlunoATurma() {
        System.out.print("Código da Turma: ");
        String t = sc.nextLine();
        String codigoTurma = t;
       
        System.out.print("Matrícula do Aluno: ");
        String matricula = sc.nextLine();
        turmaService.adicionarAlunoATurma(codigoTurma, matricula);
    }
    private void registrarAvaliacao() {
        System.out.print("Matrícula do Aluno: ");
        String matricula = sc.nextLine();

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        System.out.print("Nota: ");
        double nota = sc.nextDouble();
        sc.nextLine();

        turmaService.registrarAvaliacao(matricula, descricao, nota);
        System.out.println("Avaliação registrada com sucesso!");
    }

    private void gerarRelatorios() {
        System.out.println("\n====================///===============");
        for (Aluno a : alunoRepository.listarAlunos()) {
            a.gerarRelatorio();
        }
        System.out.println("\n===================///===============");
        for (Professor p : professorRepository.listarProfessores()) {
            p.gerarRelatorio();
        }
        System.out.println("\n==================///================");
        for (Curso c : cursoRepository.listarTodos()) {
            c.gerarRelatorio();
        }
        System.out.println("\n==================///=================");
        for (Turma t : turmaRepository.listarTodos()) {
            t.mostrarResumo();
        }
        System.out.println("\n==================///=================");
    }
}   