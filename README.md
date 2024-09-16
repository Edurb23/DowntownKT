# Downtown App (Kotlin) - Primeira Versão

Este repositório contém a primeira versão do aplicativo **Downtown**, desenvolvido em **Kotlin**. Embora ainda não esteja finalizado, esta entrega inclui as principais telas do projeto e já integra as chamadas de API para cadastro, login, e para buscar informações relacionadas ao usuário autenticado.

## Funcionalidades Implementadas

- **Cadastro de Usuários**: Integração com API para permitir que novos usuários se cadastrem no aplicativo.
- **Login de Usuários**: Chamadas de API para autenticar os usuários e acessar suas informações.
- **Telas Principais**: O aplicativo inclui as telas básicas de navegação para explorar diferentes categorias de moda, como "Tela principal", "Tela de login", "Tela de cadastro" , "Tela do perfil do usuario", "Tela de recuperar senha",  "Street Masculino", "Street Feminino", "Casual Masculino" "Casual Feminino" .

## Estrutura de Pastas

Abaixo está o diagrama da estrutura de pastas do projeto para ajudar a entender a organização dos arquivos e código:


/root (nome do projeto)
│
├── /app
│   ├── /build
│   ├── /src
│   │   ├── /main
│   │   │   ├── /java
│   │   │   │   └── /br
│   │   │   │       └── /com
│   │   │   │           └── /downtown
│   │   │   │               └── /activity
│   │   │   │                   ├── MainActivity.kt
│   │   │   │                   ├── LoginActivity.kt
│   │   │   │                   ├── StreetMActivity.kt
│   │   │   │                   ├── StreetFActivity.kt
│   │   │   │                   ├── CasualMActivity.kt
│   │   │   │                   └── CasualFActivity.kt
│   │   │   ├── /res
│   │   │   │   ├── /drawable
│   │   │   │   │   ├── streetman.png
│   │   │   │   │   ├── streetwom.png
│   │   │   │   │   ├── casualman.png
│   │   │   │   │   └── casualwom.png
│   │   │   │   ├── /layout
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── activity_street_m.xml
│   │   │   │   │   ├── activity_street_f.xml
│   │   │   │   │   ├── activity_casual_m.xml
│   │   │   │   │   └── activity_casual_f.xml
│   │   │   │   ├── /values
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── styles.xml
│   │   │   └── AndroidManifest.xml
│   └── build.gradle
│
└── /gradle
    └── wrapper
        └── gradle-wrapper.properties
