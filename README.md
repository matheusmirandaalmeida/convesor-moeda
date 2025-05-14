# 💱 Conversor de Moedas - Java

Este é um aplicativo de linha de comando simples desenvolvido em **Java** para conversão de moedas utilizando a [ExchangeRate API](https://www.exchangerate-api.com/). O usuário informa a moeda de origem, a moeda de destino e o valor a ser convertido, e o sistema retorna o valor equivalente.

---

## 🧩 Funcionalidades

- Entrada interativa via terminal (CLI)
- Validação dos códigos de moeda
- Conversão de moedas em tempo real via API
- Tratamento de exceções (como códigos de moeda inválidos)
- Permite realizar múltiplas conversões em uma única execução

---

## 📦 Estrutura do Projeto

```
conversor/
├── excecao/
│   └── MoedaInvalidaException.java
├── model/
│   ├── ExchangeRateResponse.java
│   └── Usuario.java
├── service/
│   ├── ConversorApplication.java
│   ├── ConversorService.java
│   └── MenuService.java
```

---

## 🔐 API utilizada

- **ExchangeRate API**  
  Endpoint:  
  ```
  https://v6.exchangerate-api.com/v6/<API_KEY>/latest/USD
  ```

- A chave de API usada no projeto é pública de demonstração. Para uso em produção, registre-se no site da API e substitua sua própria chave no código:
  ```java
  String url = "https://v6.exchangerate-api.com/v6/SUA_API_KEY_AQUI/latest/" + moedaOrigem;
  ```

---

## 🧠 Exemplo de uso

```
==================================
 Bem-vindo ao Conversor de Moedas 
==================================
Digite a moeda de origem (ex: USD): USD
Digite a moeda de destino (ex: BRL): BRL
Digite a quantidade a ser convertida: 100
Valor convertido: 520.75 BRL

Deseja converter outra moeda? (S/N): N
Obrigado por usar o conversor de moedas!
```

---

## 📌 Tecnologias e conceitos aplicados

- Java 11
- API HTTP (HttpClient)
- JSON parsing com Gson
- Record (Java 14+)
- Orientação a Objetos
- Tratamento de exceções
- Programação interativa via terminal

---

## 👨‍💻 Autor

Desenvolvido por [Matheus M Almeida](https://github.com/seu-usuario)

---

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
