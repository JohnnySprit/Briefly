package com.briefly.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ExplainRequest(
    @NotBlank @Size(max = 5000) String text,
    @NotBlank String pageUrl,
    String pageTitle
) {}