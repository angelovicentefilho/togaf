
# Modelo de Dominio

1. **Modelo**
   - `id`: BIGSERIAL (Chave Primária)
   - `nome`: VARCHAR(255)
   - `descricao`: TEXT
   - Relacionamentos:
     - Muitos-para-muitos com `Fase` (via tabela `modelos_fases`)
     - Um-para-muitos com `Anexo`
     - Um-para-muitos com `Projeto Atual`

2. **Fase**
   - `id`: BIGSERIAL (Chave Primária)
   - `nome`: VARCHAR(255)
   - `descricao`: TEXT
   - Relacionamentos:
     - Muitos-para-muitos com `Modelo` (via tabela `modelos_fases`)
     - Um-para-muitos com `Observação`
     - Muitos-para-um com `Projeto Atual`

3. **Modelos_Fases** (Tabela Associativa)
   - `modelo_id`: BIGINT (Chave Estrangeira)
   - `fase_id`: BIGINT (Chave Estrangeira)

4. **Anexo**
   - `id`: BIGSERIAL (Chave Primária)
   - `nome_arquivo`: VARCHAR(255)
   - `tipo_arquivo`: VARCHAR(50)
   - `tamanho_arquivo`: BIGINT
   - `conteudo`: BYTEA
   - `modelo_id`: BIGINT (Chave Estrangeira)
   - Relacionamento: Muitos-para-um com `Modelo`

5. **Usuário**
   - `id`: BIGSERIAL (Chave Primária)
   - `nome_usuario`: VARCHAR(255)
   - `senha`: VARCHAR(255)
   - `papel`: VARCHAR(50)
   - `email`: VARCHAR(255)

6. **Projeto Atual**
   - `id`: BIGSERIAL (Chave Primária)
   - `nome`: VARCHAR(255)
   - `descricao`: TEXT
   - `modelo_id`: BIGINT (Chave Estrangeira)
   - `fase_atual_id`: BIGINT (Chave Estrangeira)
   - Relacionamentos:
     - Muitos-para-um com `Modelo`
     - Muitos-para-um com `Fase`
     - Um-para-muitos com `Observação`

7. **Observação**
   - `id`: BIGSERIAL (Chave Primária)
   - `texto`: TEXT
   - `projeto_id`: BIGINT (Chave Estrangeira)
   - `fase_id`: BIGINT (Chave Estrangeira)
   - Relacionamentos:
     - Muitos-para-um com `Projeto Atual`
     - Muitos-para-um com `Fase`
