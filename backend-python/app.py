from flask import Flask, jsonify
import requests
import sqlite3

app = Flask(__name__)

# 1. ERROR ARCHIVO
@app.route("/api/file-error")
def file_error():
    try:
        open("no_existe.txt")
    except Exception as e:
        return jsonify({"error": "Error al leer archivo", "detalle": str(e)}), 500

# 2. ERROR BASE DE DATOS
@app.route("/api/db-error")
def db_error():
    try:
        conn = sqlite3.connect("test.db")
        cursor = conn.cursor()
        cursor.execute("SELECT * FROM tabla_que_no_existe")
        conn.close()
        return jsonify({"ok": True})
    except Exception as e:
        return jsonify({"error": "Error en base de datos", "detalle": str(e)}), 500

# 3. ERROR API EXTERNA (Pokemon)
@app.route("/api/pokemon-error")
def pokemon_error():
    try:
        response = requests.get("https://pokeapi.co/api/v2/pokemon/999999")
        response.raise_for_status()
        return jsonify(response.json())
    except Exception as e:
        return jsonify({"error": "Error llamando a API externa", "detalle": str(e)}), 500

# 4. API OK (para comparar)
@app.route("/api/ok")
def ok():
    return jsonify({"mensaje": "Todo funciona correctamente"})

@app.route("/")
def home():
    return "API funcionando"

if __name__ == "__main__":
    app.run(debug=True)
