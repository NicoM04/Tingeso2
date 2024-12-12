package com.mingeso.msDocuments.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "document")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Long id;

    public String fileName;  // Nombre del archivo
    public Long creditId;  // ID del crédito asociado

    @Lob
    public byte[] fileData;  // Contenido del archivo en formato byte[]
}