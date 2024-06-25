package br.com.forum.controller.form;

import br.com.forum.modelo.Topico;
import br.com.forum.repository.TopicoRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AtualizarTopicoForm {

   @NotNull @NotEmpty
   private String titulo;
   @NotNull @NotEmpty
   private String mensagem;

   public @NotNull @NotEmpty String getTitulo() {
      return titulo;
   }

   public @NotNull @NotEmpty String getMensagem() {
      return mensagem;
   }

   public void setTitulo(@NotNull @NotEmpty String titulo) {
      this.titulo = titulo;
   }

   public void setMensagem(@NotNull @NotEmpty String mensagem) {
      this.mensagem = mensagem;
   }

   public Topico atualizar(Long id, TopicoRepository topicoRepository) {
      Topico topico = topicoRepository.getReferenceById(id);
      topico.setTitulo(this.titulo);
      topico.setMensagem(this.mensagem);
      return topico;
   }
}
