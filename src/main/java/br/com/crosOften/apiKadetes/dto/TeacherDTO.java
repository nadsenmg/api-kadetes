package br.com.crosOften.apiKadetes.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
	
	
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
}