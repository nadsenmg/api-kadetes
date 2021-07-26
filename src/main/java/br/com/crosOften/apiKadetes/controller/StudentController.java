package br.com.crosOften.apiKadetes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.crosOften.apiKadetes.dto.StudentDTO;
import br.com.crosOften.apiKadetes.model.Student;
import br.com.crosOften.apiKadetes.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping (value = "/alunos")
@Api (value = "API REST Alunos")
@CrossOrigin (origins = "*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	@ApiOperation (value = "Retorna uma lista de alunos")
	@ResponseStatus (HttpStatus.OK)
	public List<Student> findAll () {
		return studentService.findAll();
	}

	@GetMapping (value = "/{id}")
	@ApiOperation (value = "Retorna um aluno único")
	public ResponseEntity<Student> findById(@PathVariable Long id) {
		return studentService.findById(id);
	}

	@PostMapping (value = "/cadastrar")
	@ApiOperation (value = "Cadastra um aluno")
	@ResponseStatus (HttpStatus.CREATED)
	public void  insertStudent (@RequestBody @Valid StudentDTO studentDTO) {
		this.studentService.insert(new Student(studentDTO.getName(), studentDTO.getCpf(), studentDTO.getBirthDate(), studentDTO.getPhoneNumber(), studentDTO.getEmail()));
	}
	
	@PutMapping (value = "/{id}")
	@ApiOperation (value = "Atualiza um aluno")
	public ResponseEntity<Student> update (@PathVariable("id") Long id, @RequestBody Student student) {
		studentService.update(id, student);
		return ResponseEntity.ok().body(student);
	}
	
	@DeleteMapping (value = "/{id}")
	@ApiOperation (value = "Deleta um aluno especifico")
	public void delete (@PathVariable long id) {
		this.studentService.delete(id);
	}  
	
}
