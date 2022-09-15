package com.example.springboot2.Controller;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot2.Dto.ErrorResponseDto;
import com.example.springboot2.Dto.SuccessResponseDto;
import com.example.springboot2.Dto.UploadFileResponse;
import com.example.springboot2.Entities.FileUploadEntity;
import com.example.springboot2.Exception.MyFileNotFoundException;
import com.example.springboot2.Exception.ResourceNotFoundException;
import com.example.springboot2.ServiceInterface.FileStorageServiceInterface;



@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	FileStorageServiceInterface fileStorageServiceInterface;
	
	
	@PostMapping("/upload-file")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam(defaultValue = " ") String type, HttpServletRequest request) throws IOException{
		
		FileUploadEntity fileDetail = new FileUploadEntity();
		
		try {
			
			fileDetail=fileStorageServiceInterface.storeFile(file,type,request);
			
		}catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponseDto("invalidFile","invalidUploadRype","invalidFile"),HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<SuccessResponseDto>(new SuccessResponseDto("File Uploaded Successfully","fileUploadSuccessfully",new UploadFileResponse(fileDetail.getId(),fileDetail.getFilename(),type)),HttpStatus.CREATED);
		
	}






	@GetMapping("/downloadFile/{path}/{fileName:.+}")
	public ResponseEntity<?> downloadFile(@PathVariable String path,@PathVariable String fileName,HttpServletRequest request)
	{
		Resource resource=null;
		
		try {
			resource=fileStorageServiceInterface.loadFileAsResource(path +"/"+ fileName);
		}catch (MyFileNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponseDto("fileNotFound","fileNotFound","fileNotFound"),HttpStatus.NOT_FOUND);
		}
		
		String contentType=null;
		
		try {
			contentType=request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
			
		}catch (IOException ex) {
			System.out.println("Could not determine file type");
		}
		
		if(contentType==null) {
			contentType="application/octet-stream";
		}
		
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(HttpHeaders.CONTENT_DISPOSITION,"inline; filename=\""+ resource.getFilename() + "\"").body(resource);
//		return new ResponseEntity<SuccessResponseDto>(new SuccessResponseDto("Success","Success",ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(HttpHeaders.CONTENT_DISPOSITION,"inline; filename=\""+ resource.getFilename() + "\"").body(resource)), HttpStatus.OK);
		
	}
	}
	
	










