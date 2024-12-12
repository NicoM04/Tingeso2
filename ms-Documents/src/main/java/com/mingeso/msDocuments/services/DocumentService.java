package com.mingeso.msDocuments.services;


import com.mingeso.msDocuments.entities.DocumentEntity;
import com.mingeso.msDocuments.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public DocumentEntity saveDocument(MultipartFile file, Long creditId) throws IOException {
        DocumentEntity document = new DocumentEntity();

        document.setFileName(file.getOriginalFilename());
        document.setFileData(file.getBytes());
        document.setCreditId(creditId);

        return documentRepository.save(document);
    }


    public DocumentEntity getDocumentById(Long documentId) {
        return documentRepository.findById(documentId)
                .orElseThrow(() -> new IllegalArgumentException("Documento no encontrado."));
    }

    public List<DocumentEntity> getAllDocuments() {
        return documentRepository.findAll();
    }

    public List<DocumentEntity> getDocumentsByCreditId(Long creditId) {
        return documentRepository.findByCreditId(creditId);
    }

    public byte[] getDocumentData(Long documentId) {
        DocumentEntity document = getDocumentById(documentId);
        return document.getFileData();  // Devolver los bytes del archivo
    }
}