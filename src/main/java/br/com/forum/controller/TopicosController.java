package br.com.forum.controller;

import br.com.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.forum.controller.dto.TopicoDto;
import br.com.forum.controller.form.AtualizarTopicoForm;
import br.com.forum.controller.form.TopicoForm;
import br.com.forum.modelo.Topico;
import br.com.forum.repository.CursoRepository;
import br.com.forum.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

   @Autowired
   private TopicoRepository topicoRepository;
   @Autowired
   private CursoRepository cursoRepository;

   @GetMapping
   public List<TopicoDto> lista(String nomeCurso) {
      if (nomeCurso==null) {
         List<Topico> topicos = topicoRepository.findAll();
         return TopicoDto.converter(topicos);
      } else {
         List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
         return TopicoDto.converter(topicos);
      }
   }

   @PostMapping
   public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
      Topico topico = form.converter(cursoRepository);
      topicoRepository.save(topico);
      URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
      return ResponseEntity.created(uri).body(new TopicoDto(topico));
   }

   @GetMapping("/{id}")
   public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id) {
      if (topicoRepository.existsById(id)) {
         Topico topico = topicoRepository.getReferenceById(id);
         return ResponseEntity.ok(new DetalhesDoTopicoDto(topico));
      }
      return ResponseEntity.notFound().build();
   }

   @PutMapping("/{id}")
   public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarTopicoForm form) {
      if (topicoRepository.existsById(id)) {
         Topico topico = form.atualizar(id, topicoRepository);
         topicoRepository.save(topico);
         return ResponseEntity.ok(new TopicoDto(topico));
      }
      return ResponseEntity.notFound().build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> remover(@PathVariable Long id) {
      if (topicoRepository.existsById(id)) {
         topicoRepository.deleteById(id);
         return ResponseEntity.ok().build();
      }
      return ResponseEntity.notFound().build();
   }
}
