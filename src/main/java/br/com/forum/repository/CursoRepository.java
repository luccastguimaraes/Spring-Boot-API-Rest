package br.com.forum.repository;

import br.com.forum.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CursoRepository extends JpaRepository<Curso, Long> {
   Curso findByNome(String nomeCurso);
}
