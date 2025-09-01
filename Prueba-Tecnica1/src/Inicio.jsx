import React from "react";
import { useNavigate } from "react-router-dom";
import "./assets/css/Inicio.css";

export default function Inicio() {
  const navigate = useNavigate();

  return (
    <div className="main-container">
      <h1>Bienvenido al Registro de Clientes</h1>
      <p>Selecciona una opción para continuar:</p>

      <div className="button-group">
        <button onClick={() => navigate("/formulario")}>
          Registrar Cliente
        </button>
        <button onClick={() => navigate("/clientes")}>
          Ver Clientes
        </button>
      </div>
    </div>
  );
}
