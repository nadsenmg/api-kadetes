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

import br.com.crosOften.apiKadetes.dto.TeacherDTO;
import br.com.crosOften.apiKadetes.model.Teacher;
import br.com.crosOften.apiKadetes.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping (value = "/professores")
@Api (value = "API REST PROFESSORES")
@CrossOrigin (origins = "*")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping
	@ApiOperation (value = "Retorna uma lista de professores")
	@ResponseStatus (HttpStatus.OK)
	public List<Teacher> findAll () {
		return teacherService.findAll();
	}

	@GetMapping (value = "/{id}")
	@ApiOperation (value = "Retorna um professor único")
	public ResponseEntity<Teacher> findById(@PathVariable Long id) {
		return teacherService.findById(id);
	}

	@PostMapping (value = "/cadastrar")
	@ApiOperation (value = "Cadastra um professor")
	@ResponseStatus (HttpStatus.CREATED)
	public void  insertStudent (@RequestBody @Valid TeacherDTO teacherDTO) {
		this.teacherService.insert(new Teacher(teacherDTO.getName(), teacherDTO.getCpf(), teacherDTO.getBirthDate(), teacherDTO.getPhoneNumber(), teacherDTO.getEmail()));
	}
	
	@PutMapping (value = "/{id}")
	@ApiOperation (value = "Atualiza um professor")
	public ResponseEntity<Teacher> update (@PathVariable("id") Long id, @RequestBody Teacher teacher) {
		teacherService.update(id, teacher);
		return ResponseEntity.ok().body(teacher);
	}
	
	@DeleteMapping (value = "/{id}")
	@ApiOperation (value = "Deleta um professor especifico")
	public void delete (@PathVariable long id) {
		this.teacherService.delete(id);
	}  
	
}
