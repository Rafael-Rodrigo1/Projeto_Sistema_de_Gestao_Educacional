package service;

import model.*;
import repository.AlunoRepository;
import repository.CursoRepository;
import repository.ProfessorRepository;
import repository.TurmaRepository;

public class TurmaService {
    private TurmaRepository turmaRepository;
    private AlunoRepository alunoRepository;
    private ProfessorRepository professorRepository;
    private CursoRepository cursoRepository;

    public TurmaService(TurmaRepository turmaRepository, AlunoRepository alunoRepository, ProfessorRepository professorRepository, CursoRepository cursoRepository) {
        this.turmaRepository = turmaRepository;
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.cursoRepository = cursoRepository;
    }

    public void criarTurma(String codigo, String registroProfessor, String codigoCurso) {

        if (turmaRepository.buscarPorCodigo(codigo) != null) {
            System.out.println("Já existe uma turma com este código.");
            return;
        }
        
            Professor professor = professorRepository.buscaPorRegistro(registroProfessor);
            Curso curso = cursoRepository.buscaPorCodigo(codigoCurso);

        if (professor != null && curso != null) {
            Turma turma = new Turma(codigo, professor, curso);
            turmaRepository.salvar(turma);
            System.out.println("A Turma foi criada com sucesso.");
        } else {
            System.out.println("Professor ou curso não foi encontrado.");
        }
    }

    public void adicionarAlunoATurma(String codigoTurma, String matriculaAluno) {
        Turma turma = turmaRepository.buscarPorCodigo(codigoTurma);
        Aluno aluno = alunoRepository.buscaPorMatricula(matriculaAluno);
        if (turma != null && aluno != null) {
            turma.adicionarAluno(aluno);
            System.out.println("Aluno adicionado à turma.");
        } else {
            System.out.println("Turma ou aluno não encontrado.");
        }
    }
   
    public void registrarAvaliacao(String matriculaAluno, String descricao, double nota) {
        Aluno aluno = alunoRepository.buscaPorMatricula(matriculaAluno);
        if (aluno != null) {
            Avaliacao avaliacao = new Avaliacao(descricao);
            avaliacao.atribuirNota(nota);
            aluno.adicionarAvaliacao(avaliacao);
            System.out.println("Avaliação registrada.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
}
