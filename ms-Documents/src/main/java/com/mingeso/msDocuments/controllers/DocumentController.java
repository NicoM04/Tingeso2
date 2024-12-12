package com.mingeso.msDocuments.controllers;

import com.mingeso.msDocuments.entities.DocumentEntity;
import com.mingeso.msDocuments.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocuments(@RequestParam("files") MultipartFile[] files,
                                                  @RequestParam(value = "creditId", required = false) Long creditId) {
        StringBuilder responseMessage = new StringBuilder();

        try {
            if (files.length == 0) {
                return ResponseEntity.badRequest().body("No se han subido archivos.");
            }

            for (MultipartFile file : files) {
                documentService.saveDocument(file, creditId);
                responseMessage.append("Archivo subido correctamente: ").append(file.getOriginalFilename()).append("\n");
            }

            return ResponseEntity.ok(responseMessage.toString());

        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error al subir los archivos: " + e.getMessage());
        }
    }

    @GetMapping("/download/{documentId}")
    public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable Long documentId) {
        DocumentEntity document = documentService.getDocumentById(documentId);

        ByteArrayResource resource = new ByteArrayResource(document.getFileData());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DocumentEntity>> getAllDocuments() {
        List<DocumentEntity> documents = documentService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

    @GetMapping("/byCredit/{creditId}")
    public ResponseEntity<List<DocumentEntity>> getDocumentsByCreditId(@PathVariable("creditId") Long creditId) {
        List<DocumentEntity> documents = documentService.getDocumentsByCreditId(creditId);

        if (documents.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(documents);
    }
}
