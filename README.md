# QA Automatizado para Banca Ficticia

### Módulo 4 - Sesión 6 - Evaluación Modular

### Equipo 4: 
- Eduardo Arellano
- Fabiola Díaz
- Felipe Lobos
- Carlos Vasquez


Este proyecto automatiza pruebas funcionales del sitio web [Banca Ficticia](https://bco-selenium.netlify.app/) usando Selenium WebDriver, JUnit 5 y WebDriverManager.

### Comandos

#### Instalar dependencias
```console
mvn clean install
```

#### Ejecutar pruebas
```console
mvn test
```

### Casos de prueba implementados

1. Login exitoso con usuario válido.
Verifica que un usuario con credenciales correctas puede iniciar sesión correctamente. Se valida que el mensaje de bienvenida coincida con el nombre del usuario.


2. Login fallido con credenciales incorrectas.
Prueba el comportamiento del sistema ante un intento de inicio de sesión con un usuario incorrecto. Se espera que el sistema muestre un mensaje de error.

3. Consulta de saldo tras iniciar sesión.
4. Transferencia bancaria exitosa.
5. Transferencia con saldo insuficiente.
6. Logout y retorno al formulario de login.


