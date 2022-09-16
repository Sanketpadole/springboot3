package com.example.springboot2.Service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot2.Entities.FileUploadEntity;
import com.example.springboot2.Exception.FileStorageException;
import com.example.springboot2.Exception.MyFileNotFoundException;
import com.example.springboot2.Exception.ResourceNotFoundException;
import com.example.springboot2.Repository.FileUploadRepository;
import com.example.springboot2.ServiceInterface.FileStorageServiceInterface;
import com.example.springboot2.properties.FileStorageProperties;

@Service
public class FileStorageServiceImpl implements FileStorageServiceInterface {

	private final Path fileStorageLocation;

	@Autowired
	public FileStorageServiceImpl(FileStorageProperties fileStorageProperties) {

		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
		try {

			Files.createDirectories(this.fileStorageLocation);

		} catch (Exception ex) {

			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
					ex);

		}

	}

	@Autowired
	private FileUploadRepository fileUploadRepository;

	@Override
	public FileUploadEntity storeFile(MultipartFile file, String type, HttpServletRequest request) throws IOException {

		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		String fileName=StringUtils.endsWithIgnoreCase(file.getName(), "pdf");

		System.out.println("filename" + fileName);

		try {

			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {

				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);

			}

//			if (fileName.endsWith("pdf")) {
//
//				System.out.println("File Found");
//
//				try {

					File pathAsFile = new File(this.fileStorageLocation + "/" + type);

					if (!Files.exists(Paths.get(this.fileStorageLocation + "/" + type))) {

						pathAsFile.mkdir();

					}

					// Copy file to the target location (Replacing existing file with the same name)
					Path targetLocation = this.fileStorageLocation.resolve(type + "/" + fileName);
					Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
					FileUploadEntity newFile = new FileUploadEntity();
					newFile.setEncoding(request.getCharacterEncoding());
					newFile.setType(type);
					newFile.setFilename(fileName);
					newFile.setMimetype(file.getContentType());
					newFile.setOriginalName(fileName);
					newFile.setSize(file.getSize());

					FileUploadEntity fileDetail = this.fileUploadRepository.save(newFile);

					return fileDetail;
				}

				catch (IOException ex) {
					throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
				}

//			} else {
//				throw new FileStorageException("Pdf Not Found file " + fileName);
//			}
//		}

		catch (Exception ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);

		}

	}

	@Override
	public Resource loadFileAsResource(String fileName) throws MyFileNotFoundException {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());

			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found");
			}
		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException("File not found");
		}

	}

	@Override
	public String getFolderName(String type) throws ResourceNotFoundException {

		String folderPath = "";

		switch (type) {

		case "images":

			folderPath = "images";
			break;

		case "test":
			folderPath = "test";
			break;

		case "products":
			folderPath = "products";
			break;

		default:
			throw new ResourceNotFoundException("Invalid Upload Type");

		}

		return folderPath;

	}
}
