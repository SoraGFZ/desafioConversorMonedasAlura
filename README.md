# Conversor de Monedas 💱

Este es un proyecto en **Java** que utiliza la API de [ExchangeRate API](https://www.exchangerate-api.com/) y la librería **Gson** para realizar conversiones entre distintas monedas.  

Actualmente soporta conversiones entre:  
- 🇺🇸 Dólar (USD)  
- 🇦🇷 Peso Argentino (ARS)  
- 🇨🇴 Peso Colombiano (COP)  
- 🇯🇵 Yen Japonés (JPY)  

---

## 🚀 Funcionalidades
- Conversión **USD ↔ ARS**  
- Conversión **USD ↔ COP**  
- Conversión **USD ↔ JPY**  
- Menú interactivo por consola.  
- Opción para **salir del programa** escribiendo `7`, `salir` o `exit`.  

---

## 🛠️ Requisitos
- **Java 17+** (funciona también con Java 11).  
- **IntelliJ IDEA** (o cualquier IDE Java).  
- Librería **Gson**:
  - Con **Maven/Gradle**:  
    ```xml
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.11.0</version>
    </dependency>
    ```
  - O manualmente, descargar [gson-2.11.0.jar](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.11.0/gson-2.11.0.jar) y agregarlo al proyecto.

---

## 📦 Instalación
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tuusuario/conversor-monedas-java.git
