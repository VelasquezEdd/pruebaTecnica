import React, { useEffect, useState } from "react";
import { getClientes } from "./assets/Js/Api";
import { useNavigate } from "react-router-dom";  
import "./assets/Css/ListaClientes.css";

export default function ListaClientes() {
  const [clientes, setClientes] = useState([]);
  const navigate = useNavigate(); 

  useEffect(() => {
    getClientes().then(setClientes);
  }, []);

  return (
    <div className="table-container">
      <h2>Clientes Registrados</h2>

      <button type="button" onClick={() => navigate("/")}>
        Inicio
      </button>

      <table>
        <thead>
          <tr>
            <th>Identificación</th>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Ciudad</th>
            <th>Departamento</th>
            <th>País</th>
            <th>Marca</th>
          </tr>
        </thead>
        <tbody>
          {clientes.map((c) => (
            <tr key={c.idCliente}>
              <td>{c.numeroIdentificacion}</td>
              <td>{c.nombres}</td>
              <td>{c.apellidos}</td>
              <td>{c.ciudad?.nombre}</td>
              <td>{c.departamento?.nombre}</td>
              <td>{c.pais?.nombre}</td>
              <td>{c.marca}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
