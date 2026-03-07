package com.briefly.repository;
import java.util.UUID;

import com.briefly.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, UUID> {
    Optional<Document> findByUrl(String url);
}