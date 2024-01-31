# Endpoints para Modelos

1. **Criar Modelo**
   - **POST** `/api/modelos`
   - Recebe dados do modelo e cria um novo registro.

2. **Listar Modelos**
   - **GET** `/api/modelos`
   - Retorna uma lista de todos os modelos.

3. **Obter Modelo Específico**
   - **GET** `/api/modelos/{modeloId}`
   - Retorna detalhes de um modelo específico.

4. **Atualizar Modelo**
   - **PUT** `/api/modelos/{modeloId}`
   - Atualiza os dados de um modelo existente.

5. **Excluir Modelo**
   - **DELETE** `/api/modelos/{modeloId}`
   - Remove um modelo específico.

## Endpoints para Fases

1. **Criar Fase**
   - **POST** `/api/fases`
   - Recebe dados da fase e cria um novo registro.

2. **Listar Fases**
   - **GET** `/api/fases`
   - Retorna uma lista de todas as fases.

3. **Obter Fase Específica**
   - **GET** `/api/fases/{faseId}`
   - Retorna detalhes de uma fase específica.

4. **Atualizar Fase**
   - **PUT** `/api/fases/{faseId}`
   - Atualiza os dados de uma fase existente.

5. **Excluir Fase**
   - **DELETE** `/api/fases/{faseId}`
   - Remove uma fase específica.

## Endpoints para Associação de Modelos a Fases

1. **Associar Modelo a Fase**
   - **POST** `/api/modelos/{modeloId}/fases/{faseId}`
   - Associa um modelo a uma fase.

2. **Listar Fases de um Modelo**
   - **GET** `/api/modelos/{modeloId}/fases`
   - Lista todas as fases associadas a um modelo específico.

3. **Remover Associação de Modelo com Fase**
   - **DELETE** `/api/modelos/{modeloId}/fases/{faseId}`
   - Remove a associação entre um modelo e uma fase.

## Endpoints para Gerenciamento de Anexos

1. **Upload de Anexo**
   - **POST** `/api/modelos/{modeloId}/anexos`
   - Faz o upload de um anexo para um modelo específico.

2. **Listar Anexos de um Modelo**
   - **GET** `/api/modelos/{modeloId}/anexos`
   - Lista todos os anexos de um modelo específico.

3. **Excluir Anexo**
   - **DELETE** `/api/modelos/{modeloId}/anexos/{anexoId}`
   - Remove um anexo específico de um modelo.

## Endpoints de Autenticação e Autorização

1. **Login**
   - **POST** `/api/auth/login`
   - Autentica um usuário e retorna um token.

2. **Registro de Usuário** (Opcional, se necessário)
   - **POST** `/api/auth/register`
   - Registra um novo usuário.

## Considerações Adicionais

- **Versionamento**: Pode ser útil versionar sua API (por exemplo, `/api/v1/modelos`).
- **Formato de Resposta**: Padronizar as respostas da API, possivelmente usando um formato comum que inclui dados, mensagens e códigos de status.
- **Tratamento de Erros**: Implementar uma estrutura de tratamento de erros consistente.
