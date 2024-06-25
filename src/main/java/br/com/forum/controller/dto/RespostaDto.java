package br.com.forum.controller.dto;

import br.com.forum.modelo.Resposta;

import java.time.LocalDateTime;

public class RespostaDto {

   private Long id;
   private String mensagem;
   private LocalDateTime dataCriacao;
   private String nomeAutor;

   public RespostaDto(Resposta r) {
      this.id = r.getId();
      this.mensagem = r.getMensagem();
      this.dataCriacao = r.getDataCriacao();
      this.nomeAutor = r.getAutor().getNome();
   }

   public Long getId() {
      return id;
   }

   public String getMensagem() {
      return mensagem;
   }

   public LocalDateTime getDataCriacao() {
      return dataCriacao;
   }

   public String getNomeAutor() {
      return nomeAutor;
   }
}
