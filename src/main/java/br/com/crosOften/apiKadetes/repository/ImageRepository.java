package br.com.crosOften.apiKadetes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crosOften.apiKadetes.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
