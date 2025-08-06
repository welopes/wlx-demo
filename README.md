# WLX Demo

Este projeto é uma aplicação Android de demonstração das bibliotecas da suíte **WLX**, estruturada com **MVVM** e **Clean Architecture**. Ele serve como referência de uso para as seguintes bibliotecas:

- [`wlx-logger`](https://github.com/welopes/wlx-logger)
- [`wlx-foundation`](https://github.com/welopes/wlx-foundation)
- [`wlx-analytics`](https://github.com/welopes/wlx-analytics)
- [`wlx-storage`](https://github.com/welopes/wlx-storage)
- [`wlx-communication`](https://github.com/welopes/wlx-communication)

🧱 Arquitetura
Este projeto segue os princípios da Clean Architecture com separação em camadas:

📁 domain       - regras de negócio e casos de uso  
📁 data         - repositórios e fontes de dados (remota/local)  
📁 presentation - UI (Jetpack Compose) e ViewModels (MVVM)  
📁 di           - módulos de injeção de dependência com Koin  

🚀 Como rodar
Clone o repositório:

bash
git clone https://github.com/welopes/wlx-demo.git
Abra no Android Studio Hedgehog (ou superior)

Sincronize os scripts do Gradle e execute no emulador ou dispositivo.

🎯 Funcionalidades demonstradas
Login com camada de comunicação desacoplada (via wlx-communication)

Armazenamento de token com wlx-storage

Logs estruturados com wlx-logger

Rastreio de eventos com wlx-analytics

Base modular com wlx-foundation

Injeção de dependência com Koin

MVVM com ViewModel, UseCase, Repository

🤝 Contribuindo
Faça um fork

Crie uma nova branch: git checkout -b minha-feature

Commit suas mudanças: git commit -m 'Adiciona nova feature'

Push para a branch: git push origin minha-feature

Crie um Pull Request

📄 Licença
Este projeto está licenciado sob a MIT License.