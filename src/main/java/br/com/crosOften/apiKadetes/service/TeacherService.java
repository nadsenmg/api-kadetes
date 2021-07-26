package br.com.crosOften.apiKadetes.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.crosOften.apiKadetes.model.Teacher;
import br.com.crosOften.apiKadetes.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	public ResponseEntity<Teacher> findById(Long id) {
		return teacherRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	public void insert(Teacher teacher) {
		teacherRepository.save(teacher);
	}

	public ResponseEntity<Teacher> update(Long id, Teacher teacher) {
		return teacherRepository.findById(id).map(record -> {
			record.setName(teacher.getName());
			record.setCpf(teacher.getCpf());
			record.setBirthDate(teacher.getBirthDate());
			record.setPhoneNumber(teacher.getPhoneNumber());
			record.setEmail(teacher.getEmail());
			Teacher updated = teacherRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public Teacher findByEmail(String email) {
		Optional<Teacher> LocateEmail = Optional.ofNullable(
				teacherRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Professor não encontrado!")));
		return LocateEmail.get();
	}

	public ResponseEntity<?> delete(Long id) {
		return teacherRepository.findById(id).map(record -> {
			teacherRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	public void saveImage(MultipartFile imageFile) throws Exception {
		String folder = "/photos";
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(folder + imageFile.getOriginalFilename());
		Files.write(path, bytes);
	}
}
