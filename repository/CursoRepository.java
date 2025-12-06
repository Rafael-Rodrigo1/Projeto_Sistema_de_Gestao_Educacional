package repository;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private List<Curso> cursos = new ArrayList<>();
    public void salvar(Curso curso) {
        cursos.add(curso);
    }
    public List<Curso> listarTodos() {
        return cursos;
    }

    //método para buscar o curso Por Codigo
    public Curso buscaPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }
}