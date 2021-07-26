package br.com.crosOften.apiKadetes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.crosOften.apiKadetes.model.Image;
import br.com.crosOften.apiKadetes.service.ImageService;

@RestController
public class ImageController {

	@Autowired
	private ImageService imageService;

	@GetMapping(value = "/")
	public String get(Model model) {
		List<Image> docs = imageService.getFiles();
		model.addAttribute("docs", docs);
		return "doc";
	}

	@PostMapping(value = "/uploadFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile file : files) {
			imageService.saveFile(file);
		}
		return "redirect:/";
	}
}