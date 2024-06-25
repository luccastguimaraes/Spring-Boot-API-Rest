package br.com.forum.controller.dto;

import br.com.forum.modelo.StatusTopico;
import br.com.forum.modelo.Topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesDoTopicoDto {

   private Long id;
   private String titulo;
   private String mensagem;
   private LocalDateTime dataCriacao;
   private String nomeAutor;
   private StatusTopico status;
   private List<RespostaDto> respostas;

   public DetalhesDoTopicoDto(Topico o) {
      this.id = o.getId();
      this.titulo = o.getTitulo();
      this.mensagem = o.getMensagem();
      this.dataCriacao = o.getDataCriacao();
      this.nomeAutor = o.getAutor().getNome();
      this.status = o.getStatus();
      this.respostas = new ArrayList<>();
      this.respostas.addAll(o.getRespostas().stream().map(RespostaDto::new).toList());
   }

   public Long getId() {
      return id;
   }

   public String getTitulo() {
      return titulo;
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

   public StatusTopico getStatus() {
      return status;
   }

   public List<RespostaDto> getRespostas() {
      return respostas;
   }
}
