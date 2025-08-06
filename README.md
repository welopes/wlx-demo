# WLX Demo

[![License: CC BY-NC 4.0](https://img.shields.io/badge/License-CC%20BY--NC%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by-nc/4.0/)

Este projeto é uma aplicação Android de demonstração das bibliotecas da suíte **WLX**, estruturada com **MVVM** e **Clean Architecture**. Ele serve como referência de uso para as seguintes bibliotecas:

- [`wlx-logger`](https://github.com/welopes/wlx-logger)
- [`wlx-foundation`](https://github.com/welopes/wlx-foundation)
- [`wlx-analytics`](https://github.com/welopes/wlx-analytics)
- [`wlx-storage`](https://github.com/welopes/wlx-storage)
- [`wlx-communication`](https://github.com/welopes/wlx-communication)

---

## 📦 Bibliotecas Usadas

O projeto demonstra o uso das seguintes bibliotecas modulares:

- **Logger**
    - `wlx.logger.api`
    - `wlx.logger.impl`

- **Foundation**
    - `wlx.foundation.api`

- **Analytics**
    - `wlx.analytics.api`
    - `wlx.analytics.impl`

- **Storage**
    - `wlx.storage.api`
    - `wlx.storage.impl`

- **Communication**
    - `wlx.communication.api`
    - `wlx.communication.impl`

Essas bibliotecas são desacopladas e seguem o padrão de separação entre API e implementação para maior flexibilidade e reutilização.

---

## 🧱 Arquitetura
Este projeto segue os princípios da Clean Architecture com separação em camadas:

📁 domain       - regras de negócio e casos de uso  
📁 data         - repositórios e fontes de dados (remota/local)  
📁 presentation - UI (Jetpack Compose) e ViewModels (MVVM)  
📁 di           - módulos de injeção de dependência com Koin  

- **MVVM**: Separação clara entre View (Activity/Fragment), ViewModel e dados.
- **Clean Architecture**: Camadas de `presentation`, `domain` e `data`, cada uma com sua responsabilidade.

---

## 🚀 Funcionalidades

- Tela de login com autenticação via endpoint HTTP.
- Comunicação genérica utilizando `OkHttpCommunicationClient`.
- Armazenamento de token com `wlx.storage`.
- Logs estruturados com `wlx.logger`.
- Eventos de analytics com `wlx.analytics`.

---

## 🧪 Testes

Você pode testar o app utilizando um endpoint real ou mockado com serviços como:

- [https://mockapi.io](https://mockapi.io)
- [https://beeceptor.com](https://beeceptor.com)
- [https://webhook.site](https://webhook.site)

---

## 🚀 Como rodar
Clone o repositório:

bash
git clone https://github.com/welopes/wlx-demo.git
Abra no Android Studio Hedgehog (ou superior)

Sincronize os scripts do Gradle e execute no emulador ou dispositivo.

---

## 🛡️ Licença

Este projeto está licenciado sob a licença **Creative Commons Attribution-NonCommercial 4.0 International (CC BY-NC 4.0)**.

Você pode:

- Compartilhar
- Adaptar

**Desde que:**

- Atribua crédito ao autor original
- **Não utilize para fins comerciais**

Mais informações: [https://creativecommons.org/licenses/by-nc/4.0/](https://creativecommons.org/licenses/by-nc/4.0/)

---

## 🤝 Contribuições

Contribuições são bem-vindas, desde que respeitem a licença.

---

## 👨‍💻 Autor

**Wellington Lopes**  
[github.com/welopes](https://github.com/welopes)