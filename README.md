# Guia para Rodar o WSDL (Caso Necessário)

Este guia detalha como utilizar o Maven para configurar e executar o WSDL em seu projeto.

---

## 1. Abrir a Aba do Maven

1. **Atalho**: Pressione `Alt + 1` para abrir o painel lateral do Maven.
2. **Menu**: Caso o painel não esteja visível:
   - Navegue até `View > Tool Windows > Maven`.

---

## 2. Localizar o Lifecycle

1. No painel Maven, localize o nome do seu projeto (por exemplo, `emmestoque-app`).
2. Clique para expandir o projeto.
3. Navegue até a seção **Lifecycle**.

---

## 3. Executar o Comando `clean`

1. Dentro da seção **Lifecycle**, você encontrará uma lista de fases.
2. Clique em `clean` para remover todos os artefatos gerados anteriormente, como builds antigos e classes compiladas.

---

## 4. Configuração e Execução no Maven

Após executar o `clean`, você pode seguir estas etapas:

### **Compile**
- Comando: `compile`
- Função: Compila o código do projeto.

### **Install**
- Comando: `install`
- Função: Compila, testa e instala o artefato gerado no repositório local.

### **Gerar Recursos SOAP**
- Comando: `jaxws:wsgen`
- Função: Gera os recursos necessários para o uso do protocolo SOAP (se configurado no `pom.xml`).

---

> **Nota:** Certifique-se de que o Maven esteja configurado corretamente no seu ambiente de desenvolvimento e que as dependências necessárias estejam listadas no arquivo `pom.xml`.

