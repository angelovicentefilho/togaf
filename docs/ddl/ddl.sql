-- Criação da tabela 'modelos'
CREATE TABLE modelos (
    id BIGSERIAL PRIMARY KEY, nome VARCHAR(255) NOT NULL, descricao TEXT
);

-- Criação da tabela 'fases'
CREATE TABLE fases (
    id BIGSERIAL PRIMARY KEY, nome VARCHAR(255) NOT NULL, descricao TEXT
);

-- Tabela de associação muitos-para-muitos entre 'modelos' e 'fases'
CREATE TABLE modelos_fases (
    modelo_id BIGINT NOT NULL, fase_id BIGINT NOT NULL, PRIMARY KEY (modelo_id, fase_id), FOREIGN KEY (modelo_id) REFERENCES modelos (id) ON DELETE CASCADE, FOREIGN KEY (fase_id) REFERENCES fases (id) ON DELETE CASCADE
);

-- Criação da tabela 'anexos'
CREATE TABLE anexos (
    id BIGSERIAL PRIMARY KEY, nome_arquivo VARCHAR(255) NOT NULL, tipo_arquivo VARCHAR(50), tamanho_arquivo BIGINT, conteudo BYTEA, modelo_id BIGINT NOT NULL, FOREIGN KEY (modelo_id) REFERENCES modelos (id) ON DELETE CASCADE
);

-- Criação da tabela 'usuarios'
CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY, nome_usuario VARCHAR(255) NOT NULL UNIQUE, senha VARCHAR(255) NOT NULL, papel VARCHAR(50) NOT NULL, email VARCHAR(255) NOT NULL UNIQUE
);

-- Criação da tabela 'projetos_atuais'
CREATE TABLE projetos_atuais (
    id BIGSERIAL PRIMARY KEY, nome VARCHAR(255) NOT NULL, descricao TEXT, modelo_id BIGINT NOT NULL, fase_atual_id BIGINT NOT NULL, FOREIGN KEY (modelo_id) REFERENCES modelos (id), FOREIGN KEY (fase_atual_id) REFERENCES fases (id)
);

-- Criação da tabela 'observacoes'
CREATE TABLE observacoes (
    id BIGSERIAL PRIMARY KEY, texto TEXT NOT NULL, projeto_id BIGINT NOT NULL, fase_id BIGINT NOT NULL, FOREIGN KEY (projeto_id) REFERENCES projetos_atuais (id) ON DELETE CASCADE, FOREIGN KEY (fase_id) REFERENCES fases (id)
);