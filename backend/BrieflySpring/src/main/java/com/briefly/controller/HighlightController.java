package com.briefly.controller;

import com.briefly.dto.ExplainRequest;
import com.briefly.dto.ExplainResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HighlightController {

    @PostMapping("/explain")
    public ResponseEntity<ExplainResponse> explain(@Valid @RequestBody ExplainRequest req) {
        return ResponseEntity.ok(new ExplainResponse(
            "This is a hardcoded explanation for: " + req.text().substring(0, 20),
            List.of("concept one", "concept two", "concept three")
        ));
    }
}