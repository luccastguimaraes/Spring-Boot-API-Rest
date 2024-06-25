package br.com.forum.controller.form;

import br.com.forum.modelo.Curso;
import br.com.forum.modelo.Topico;
import br.com.forum.repository.CursoRepository;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



public class TopicoForm {

   @NotNull @NotEmpty
   private String titulo;
   @NotNull @NotEmpty
   private String mensagem;
   @NotNull @NotEmpty
   private String nomeCurso;

   public @NotNull @NotEmpty String getTitulo() {
      return titulo;
   }

   public @NotNull @NotEmpty String getMensagem() {
      return mensagem;
   }

   public @NotNull @NotEmpty String getNomeCurso() {
      return nomeCurso;
   }

   public Topico converter(CursoRepository cursoRepository) {
      Curso curso = cursoRepository.findByNome(nomeCurso);
      return new Topico(titulo, mensagem, curso);
   }

}
