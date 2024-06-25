package br.com.forum.controller.dto;


import br.com.forum.modelo.Topico;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto {
   private Long id;
   private String titulo;
   private String mensagem;
   private LocalDateTime dataCriacao;

   public TopicoDto(Topico o) {
      this.id = o.getId();
      this.titulo = o.getTitulo();
      this.mensagem = o.getMensagem();
      this.dataCriacao = o.getDataCriacao();
   }

   public static Page<TopicoDto> converter(Page<Topico> topicos) {
      return topicos.map(TopicoDto::new);
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
}
