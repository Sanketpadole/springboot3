package com.example.springboot2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot2.Entities.*;

public interface FileUploadRepository extends JpaRepository<FileUploadEntity, Long> {
}
