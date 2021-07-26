package br.com.crosOften.apiKadetes.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column (unique = true)
	private String cpf;
	@JsonFormat (pattern = "dd/MM/yyyy")
	private LocalDate birthDate;
	private String phoneNumber;
	@Column (unique = true)
	private String email;
	
	public Student(String name, String cpf, LocalDate birthDate, String phoneNumber, String email) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
}


