# Jarvis - Downtown App (Kotlin) - Primeira Versão

Este repositório contém a primeira versão do aplicativo **Downtown**, desenvolvido em **Kotlin**. Embora ainda não esteja finalizado, esta entrega inclui as principais telas do projeto e já integra as chamadas de API para cadastro, login, e para buscar informações relacionadas ao usuário autenticado.

## Funcionalidades Implementadas

- **Cadastro de Usuários**: Integração com API para permitir que novos usuários se cadastrem no aplicativo.
- **Login de Usuários**: Chamadas de API para autenticar os usuários e acessar suas informações.
- **Telas Principais**: O aplicativo inclui as telas básicas de navegação para explorar diferentes categorias de moda, como "Tela principal", "Tela de login", "Tela de cadastro" , "Tela do perfil do usuario", "Tela de recuperar senha",  "Street Masculino", "Street Feminino", "Casual Masculino" "Casual Feminino" .

## Integrantes 
- Raphael Pabst rm98525
- Silvio Junior rm550821
- Pedro Braga rm551061
- Eduardo Reis Braga rm551987
- Vinicius Martins Abdala rm99455


## Estrutura de Pastas

Abaixo está o diagrama da estrutura de pastas do projeto para ajudar a entender a organização dos arquivos e código:

```
/root Downtown*
│
├── /app
│   ├── /manifests
│   ├── /kotlin+java
│   │   └── /br
│   │       └── /com
│   │           └── /downtown
│   │               ├── /activity
│   │               │   ├── CadastroActivity.kt
│   │               │   ├── CasualFActivity.kt
│   │               │   ├── CasualMActivity.kt
│   │               │   ├── ForgotPasswordActivity.kt
│   │               │   ├── LoginActivity.kt
│   │               │   ├── MainActivity.kt
│   │               │   ├── ProfileActivity.kt
│   │               │   ├── StreetFActivity.kt
│   │               │   └── StreetMActivity.kt
│   │               ├── /auth
│   │               │   └── RetroFit.kt
│   │               ├── /model
│   │               │   └── User.kt
│   │               └── /service
│   │                   └── ApiService.kt
│   └── /test
│       └── /br
│           └── /com
│               └── /downtown
│                   ├── ExampleInstrumentedTest.kt
│                   └── ExampleUnitTest.kt
│
├── /res
│   ├── /drawable
│   │   ├── babylook.jpg
│   │   ├── baseline_arrow_back_ios_24.xml
│   │   ├── bomberjacket.png
│   │   ├── botaovoltar.png
│   │   ├── calcabaggy.png
│   │   ├── calcacheans.png
│   │   ├── calcamoletom.jpg
│   │   ├── camisabox.png
│   │   ├── camisaover.png
│   │   ├── camisatee.png
│   │   ├── casualman.png
│   │   ├── casualwom.png
│   │   ├── conjutobaggy.png
│   │   ├── ic_launcher_background.xml
│   │   ├── ic_launcher_foreground.xml
│   │   ├── jaquetacropped.png
│   │   ├── jaquetaold.png
│   │   ├── jaquetarigida.png
│   │   ├── jeansreta.png
│   │   ├── regata.png
│   │   ├── rounded_button.xml
│   │   ├── rounded_edittext_background.xml
│   │   ├── streetman.png
│   │   ├── streetwom.png
│   │   ├── usuario.png
│   │   ├── vestidobranco.png
│   │   ├── vintage.jpg
│   │   └── wildleg.png
│   ├── /layout
│   │   ├── activity_cadastro.xml
│   │   ├── activity_casual_fem.xml
│   │   ├── activity_casual_masc.xml
│   │   ├── activity_esquecer_senha.xml
│   │   ├── activity_login.xml
│   │   ├── activity_main.xml
│   │   ├── activity_perfil.xml
│   │   ├── activity_street_fem.xml
│   │   └── activity_street_masc.xml
│
└── /gradle
    └── wrapper
        └── gradle-wrapper.properties


```
