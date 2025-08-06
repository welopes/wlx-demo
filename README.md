# WLX Demo

[![License: CC BY-NC 4.0](https://img.shields.io/badge/License-CC%20BY--NC%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by-nc/4.0/)

This project is an Android application demonstrating the WLX library suite, structured using MVVM and Clean Architecture. It serves as a usage reference for the following libraries:

- [`wlx-logger`](https://github.com/welopes/wlx-logger)
- [`wlx-foundation`](https://github.com/welopes/wlx-foundation)
- [`wlx-analytics`](https://github.com/welopes/wlx-analytics)
- [`wlx-storage`](https://github.com/welopes/wlx-storage)
- [`wlx-communication`](https://github.com/welopes/wlx-communication)

---

## 📦 Libraries Used

This project showcases the usage of the following modular libraries:

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

These libraries are decoupled and follow the API + implementation separation pattern to promote flexibility and reuse.

---

## 🧱Architecture

The project follows a layered architecture:

📁 domain       - business rules and use cases
📁 data         - repositories and data sources (remote/local)
📁 presentation - UI (Jetpack Compose) and ViewModels (MVVM)
📁 di           - dependency injection modules using Koin  
📁 flow         - Defines and organizes the navigation flows between the screens of a specific feature.

- **MVVM**: Clear separation between View (Activity/Fragment), ViewModel, and data layers.
- **Clean Architecture**: Layered approach with `presentation`, `domain`, and `data`, each with a single responsibility.

---

## 🚀 Features

- Login screen with authentication via HTTP endpoint.
- Generic communication using `OkHttpCommunicationClient`.
- Token storage with `wlx.storage`.
- Structured logging using `wlx.logger`.
- Analytics event tracking with `wlx.analytics`.

---

## 🧪 Testing

You can test the app using a real or mocked backend, such as:

- [https://mockapi.io](https://mockapi.io)
- [https://beeceptor.com](https://beeceptor.com)
- [https://webhook.site](https://webhook.site)

---

## 🚀 How to Run
Clone the repository:

``bash

git clone https://github.com/welopes/wlx-demo.git
Then open the project in Android Studio Hedgehog (or newer).

Finally, sync the Gradle scripts and run the app on an emulator or physical device.

---

## 🛡️ License

This project is licensed under the **Creative Commons Attribution-NonCommercial 4.0 International (CC BY-NC 4.0)** license.

You are free to:

- Share
- Adapt

**As long as you:**

- Give appropriate credit to the original author
- **Do not use it for commercial purposes**

More info: [https://creativecommons.org/licenses/by-nc/4.0/](https://creativecommons.org/licenses/by-nc/4.0/)

---

## 🤝 Contributions

Contributions are welcome, as long as they comply with the license.

---

## 👨‍💻 Author

**Wellington Eliel Lopes**  
[github.com/welopes](https://github.com/welopes)