import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Inicio from "./Inicio"; 
import Formulario from "./Formulario";
import ListaClientes from "./ListaClientes";
import "./assets/Css/App.css";
export default function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Inicio />} /> 
        <Route path="/formulario" element={<Formulario />} />
        <Route path="/clientes" element={<ListaClientes />} />
      </Routes>
    </Router>
  );
}
