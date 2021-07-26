package br.com.crosOften.apiKadetes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.crosOften.apiKadetes.model.Image;
import br.com.crosOften.apiKadetes.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	 public Image saveFile(MultipartFile file) {
		  String docname = file.getOriginalFilename();
		  try {
			  Image image = new Image(docname,file.getContentType(),file.getBytes());
			  return imageRepository.save(image);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return null;
	  }
	  public Optional<Image> getFile(Long fileId) {
		  return imageRepository.findById(fileId);
	  }
	  public List<Image> getFiles(){
		  return imageRepository.findAll();
	  }
}
