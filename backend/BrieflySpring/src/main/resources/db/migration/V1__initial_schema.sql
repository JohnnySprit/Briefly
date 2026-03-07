CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE document (
    id         UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    url        TEXT NOT NULL UNIQUE,
    title      TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE highlight (
    id            UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    document_id   UUID NOT NULL REFERENCES document(id) ON DELETE CASCADE,
    selected_text TEXT NOT NULL,
    explanation   TEXT NOT NULL,
    created_at    TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE concept (
    id           UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    highlight_id UUID NOT NULL REFERENCES highlight(id) ON DELETE CASCADE,
    name         TEXT NOT NULL,
    created_at   TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_highlight_created ON highlight(created_at DESC);
CREATE INDEX idx_concept_highlight ON concept(highlight_id);