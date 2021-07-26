package br.com.crosOften.apiKadetes.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ControllerAdvice
public class GlobalHandlerException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> MethodArgumentNotValidException () {
		return new ResponseEntity<Object> ("Alguns campos estão inválidos", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler (SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Object> SQLIntegrityConstraintViolationException (){
		return new ResponseEntity<Object> ("Já existe um usuário com este email ou cpf", HttpStatus.BAD_REQUEST);
	}

}
