# Requisitos

1. **Endpoints da API**:
   - CRUD (Create, Read, Update, Delete) para modelos e fases.
   - Endpoint para associar um modelo a uma fase.
   - Endpoint para analistas selecionarem modelos e adicionar informações a cada fase.
   - Endpoint para upload de anexos com limite de 5MB.

2. **Estrutura de Dados**:
   - Definir as entidades Modelo e Fase, incluindo atributos relevantes.
   - Considerar a relação entre modelos e fases (muitos-para-muitos, um-para-muitos, etc.).

3. **Validação**:
   - Validar o tamanho dos anexos (máximo de 5MB).
   - Outras validações básicas (por exemplo, campos obrigatórios).

4. **Segurança**:
   - Autenticação e autorização, diferenciando os papéis de administrador e analista.

5. **Documentação**:
   - Utilizar Swagger ou outra ferramenta de documentação de API.

6. **Testes**:
   - Planejar testes unitários e de integração.

7. **Armazenamento**:
   - Decidir sobre o armazenamento de dados (banco de dados) e arquivos (sistema de arquivos, serviço de armazenamento em nuvem, etc.).

8. **Formato dos Arquivos**:
   - Permitir formatos de arquivo variados para os anexos.

9. **Logs e Monitoramento**:
   - Implementar logs adequados para monitoramento e diagnóstico.

10. **Configurações e Deployment**:
    - Definir a configuração da aplicação e as opções de deployment.

Por favor, informe se há alguma preferência ou requisito específico em qualquer uma dessas áreas ou algo adicional que você gostaria de incluir.
