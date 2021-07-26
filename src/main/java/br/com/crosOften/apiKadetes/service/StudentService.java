package br.com.crosOften.apiKadetes.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.crosOften.apiKadetes.model.Student;
import br.com.crosOften.apiKadetes.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public ResponseEntity<Student> findById(Long id) {
		return studentRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public void insert(Student student) {
		studentRepository.save(student);
	}

	public ResponseEntity<Student> update(Long id, Student student) {
		return studentRepository.findById(id).map(record -> {
			record.setName(student.getName());
			record.setCpf(student.getCpf());
			record.setBirthDate(student.getBirthDate());
			record.setPhoneNumber(student.getPhoneNumber());
			record.setEmail(student.getEmail());
			Student updated = studentRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	public Student findByEmail(String email) {
		Optional<Student> LocateEmail = Optional.ofNullable(
				studentRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado!")));
		return LocateEmail.get();
	}

	public ResponseEntity<?> delete(Long id) {
		return studentRepository.findById(id).map(record -> {
			studentRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
