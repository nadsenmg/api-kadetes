package br.com.crosOften.apiKadetes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crosOften.apiKadetes.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	Optional<Teacher> findByEmail(String email);

}
