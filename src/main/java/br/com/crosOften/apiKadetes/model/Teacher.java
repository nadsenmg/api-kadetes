package br.com.crosOften.apiKadetes.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank (message = "Este campo precisa ser preeenchido")
	private String name;
	@CPF
	private String cpf;
	@JsonFormat (pattern = "dd/MM/yyyy") @NotNull (message = "Este campo precisa ser preenchido")
	private LocalDate birthDate;
	
	@NotBlank (message = "Este campo precisa ser preenchido")
	private String phoneNumber;
	@Email @NotBlank(message = "Precisa ser um email válido")
	private String email;
	
	public Teacher(@NotBlank(message = "Este campo precisa ser preeenchido") String name, @CPF String cpf,
			@NotNull(message = "Este campo precisa ser preenchido") LocalDate birthDate,
			@NotBlank(message = "Este campo precisa ser preenchido") String phoneNumber,
			@Email @NotBlank(message = "Precisa ser um email válido") String email) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
}

