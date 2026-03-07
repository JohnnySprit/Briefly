package com.briefly.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "highlight")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Highlight {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    @Column(name = "selected_text", nullable = false, columnDefinition = "TEXT")
    private String selectedText;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String explanation;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "highlight", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Concept> concepts;
}