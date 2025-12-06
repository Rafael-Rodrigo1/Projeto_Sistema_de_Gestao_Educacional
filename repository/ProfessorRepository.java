package repository;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository  {
  private List<Professor> professores = new ArrayList<>();

    public void salvar(Professor professor) {
        professores.add(professor);
    }

    public List<Professor> listarProfessores() {
        return professores;
    }

    //método para buscar o professor por Registro
    public Professor buscaPorRegistro(String registro) {
        for (Professor p : professores) {
            if (p.getRegistro().equals(registro)) {
                return p;
            }
        }
        return null;
    }
}
