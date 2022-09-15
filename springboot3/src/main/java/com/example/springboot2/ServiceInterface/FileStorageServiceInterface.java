package com.example.springboot2.ServiceInterface;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot2.Entities.FileUploadEntity;
import com.example.springboot2.Exception.MyFileNotFoundException;
import com.example.springboot2.Exception.ResourceNotFoundException;


@Service
public interface FileStorageServiceInterface {

//	public Resource loadFileAsResource(String fileName) throws MyFileNotFoundException;
//
//	public String getFolderName(String type) throws ResourceNotFoundException;

	FileUploadEntity storeFile(MultipartFile file, String type, HttpServletRequest request) throws IOException;

	Resource loadFileAsResource(String string);

	String getFolderName(String type) throws ResourceNotFoundException;

	


}
