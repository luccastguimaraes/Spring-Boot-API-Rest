package br.com.forum.config.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

   @Autowired
   private MessageSource message;

   @ResponseStatus(code = HttpStatus.BAD_REQUEST)
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException e) {
      List<ErroDeFormularioDto> dto = new ArrayList<>();
      List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
      fieldErrors.forEach(f -> dto.add(new ErroDeFormularioDto(f.getField()
            , message.getMessage(f, LocaleContextHolder.getLocale()))));

      return dto;
   }
}
