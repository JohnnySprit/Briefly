package com.briefly.dto;

import java.util.List;

public record ExplainResponse(
    String explanation,
    List<String> concepts
) {}