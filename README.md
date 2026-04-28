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
