package com.briefly.repository;

import com.briefly.model.Highlight;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.UUID;

public interface HighlightRepository extends JpaRepository<Highlight, UUID> {

    @Query("""
        SELECT h FROM Highlight h
        JOIN FETCH h.document
        LEFT JOIN FETCH h.concepts
        ORDER BY h.createdAt DESC
        """)
    List<Highlight> findAllWithDetails(Pageable pageable);
}