package com.briefly.dto;

import com.briefly.model.Highlight;
import java.util.List;

public record HighlightDto(
    String id,
    String selectedText,
    String explanation,
    List<String> concepts,
    String pageTitle,
    String pageUrl,
    String createdAt
) {
    public static HighlightDto from(Highlight h) {
        return new HighlightDto(
            h.getId().toString(),
            h.getSelectedText(),
            h.getExplanation(),
            h.getConcepts().stream().map(c -> c.getName()).toList(),
            h.getDocument().getTitle(),
            h.getDocument().getUrl(),
            h.getCreatedAt().toString()
        );
    }
}