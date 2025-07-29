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
Luego de un login exitoso, se simula la acción de consultar el saldo de la cuenta. Se verifica que el campo de saldo contenga información.

4. Transferencia bancaria exitosa.
Realiza una transferencia de dinero con un monto válido y suficiente. El test valida que el mensaje de confirmación contenga los datos de la cuenta de destino y el monto enviado.

5. Transferencia con saldo insuficiente.
Simula una transferencia con un monto muy alto, superior al saldo disponible. El sistema debe mostrar el mensaje de error correspondiente por saldo insuficiente.

6. Logout y retorno al formulario de login.
Verifica que, tras cerrar sesión, el usuario sea redirigido al formulario de inicio de sesión. Se comprueba que el mensaje principal del formulario se muestre correctamente.




