# Práctica 2 - Sistemas Distribuidos

## Descripción

Aplicación distribuida basada en:

- Frontend en Spring Boot (Java)
- API en Python con Flask
- Gestión de excepciones entre servicios

El objetivo es demostrar el tratamiento de errores en:

- Acceso a archivos
- Acceso a base de datos
- Llamadas a APIs externas


## Arquitectura

Cliente (navegador)  -> Spring Boot (Frontend)   -> Flask API (Python)   -> Base de datos / APIs externas  


## Backend Python (Flask)

Ubicación:
backend-python/ 

Endpoints disponibles:

- `/api/file-error` -> Error al leer archivo
- `/api/db-error` -> Error de base de datos
- `/api/pokemon-error` -> Error API externa
- `/api/ok` -> Respuesta correcta

Ejecutar:

cd backend-python
source venv/bin/activate
python app.py

## Ejecución completa

### Backend Flask
cd backend-python
source venv/bin/activate
python app.py

### Frontend Spring Boot
cd frontend-spring/frontend-spring/frontend
mvn spring-boot:run

### Acceso
http://localhost:8080

# Practica finalizada
Página principal ✔
Login ✔
Pantalla de simulación ✔
API Flask ✔
Excepciones archivo ✔
Excepciones BD ✔
Excepciones API ✔
Manejo en frontend ✔
Traducción de errores ✔

## Pruebas con Postman

Se han realizado pruebas de los endpoints de la API Flask utilizando Postman, obteniendo los siguientes resultados:

- /api/file-error 
  → Error al leer archivo 
  → Detalle: archivo no encontrado

- /api/db-error 
  → Error en base de datos 
  → Detalle: tabla inexistente

- /api/pokemon-error 
  → Error llamando a API externa 
  → Detalle: recurso no encontrado (404)

Todos los endpoints devuelven correctamente errores controlados con código 500.
