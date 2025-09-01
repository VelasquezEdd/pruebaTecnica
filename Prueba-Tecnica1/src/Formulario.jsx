import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { getPaises, getDepartamentos, getCiudades, saveCliente } from "./assets/Js/Api";
import "./assets/Css/Formulario.css";

export default function Formulario({ onSuccess }) {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    tipoIdentificacion: "",
    numeroIdentificacion: "",
    nombres: "",
    apellidos: "",
    fechaNacimiento: "",
    direccion: "",
    idPais: "",
    idDepartamento: "",
    idCiudad: "",
    marca: "",
  });

  const [paises, setPaises] = useState([]);
  const [departamentos, setDepartamentos] = useState([]);
  const [ciudades, setCiudades] = useState([]);
  const [loadingPaises, setLoadingPaises] = useState(true);
  const [loadingDepartamentos, setLoadingDepartamentos] = useState(false);
  const [loadingCiudades, setLoadingCiudades] = useState(false);

  useEffect(() => {
    getPaises()
      .then(res => {
        console.log("Paises cargados:", res); 
        setPaises(res);
      })
      .catch(err => console.error("Error cargando paises:", err))
      .finally(() => setLoadingPaises(false));
  }, []);


  useEffect(() => {
    if (formData.idPais) {
      setLoadingDepartamentos(true);
      getDepartamentos(formData.idPais)
        .then(setDepartamentos)
        .finally(() => setLoadingDepartamentos(false));
    } else {
      setDepartamentos([]);
    }
    setFormData(prev => ({ ...prev, idDepartamento: "", idCiudad: "" }));
  }, [formData.idPais]);

  useEffect(() => {
    if (formData.idDepartamento) {
      setLoadingCiudades(true);
      getCiudades(formData.idDepartamento)
        .then(setCiudades)
        .finally(() => setLoadingCiudades(false));
    } else {
      setCiudades([]);
    }
    setFormData(prev => ({ ...prev, idCiudad: "" }));
  }, [formData.idDepartamento]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: ["idPais", "idDepartamento", "idCiudad"].includes(name)
        ? (value ? Number(value) : null)
        : value
    }));
  };

const handleSubmit = async (e) => {
  e.preventDefault();

  if (!formData.tipoIdentificacion || !formData.numeroIdentificacion || !formData.nombres || !formData.apellidos) {
    alert("Completa todos los campos obligatorios.");
    return;
  }

  if (!formData.idPais || !formData.idDepartamento || !formData.idCiudad) {
    alert("Selecciona país, departamento y ciudad.");
    return;
  }

  try {
    const fechaNacimientoFormatted = formData.fechaNacimiento
      ? new Date(formData.fechaNacimiento).toISOString().split("T")[0]
      : null;

    const marcaFormatted = formData.marca ? formData.marca.toUpperCase() : null;
    const paisObj = paises.find(p => p.idPais === formData.idPais);
    const deptoObj = departamentos.find(d => d.idDepartamento === formData.idDepartamento);
    const ciudadObj = ciudades.find(c => c.idCiudad === formData.idCiudad);

    const payload = {
      tipoIdentificacion: formData.tipoIdentificacion,
      numeroIdentificacion: formData.numeroIdentificacion,
      nombres: formData.nombres,
      apellidos: formData.apellidos,
      fechaNacimiento: fechaNacimientoFormatted,
      direccion: formData.direccion,
      pais: paisObj,
      departamento: deptoObj,
      ciudad: ciudadObj,
      marca: marcaFormatted,
    };

    console.log("Payload enviado:", payload);

    await saveCliente(payload);

    alert("Cliente registrado correctamente.");
    onSuccess?.();
    setFormData({
      tipoIdentificacion: "",
      numeroIdentificacion: "",
      nombres: "",
      apellidos: "",
      fechaNacimiento: "",
      direccion: "",
      idPais: "",
      idDepartamento: "",
      idCiudad: "",
      marca: "",
    });

  } catch (err) {
    console.error(err);
    alert(`Error: ${err.message}`);
  }
};



  return (
    <form onSubmit={handleSubmit}>
      <h2>Registro de Cliente</h2>

      <select name="tipoIdentificacion" onChange={handleChange} value={formData.tipoIdentificacion} required>
        <option value="">Tipo de Identificación</option>
        <option value="CC">Cédula</option>
        <option value="TI">Tarjeta de Identidad</option>
        <option value="CE">Cédula de Extranjería</option>
      </select>

      <input type="text" name="numeroIdentificacion" placeholder="Número ID" value={formData.numeroIdentificacion} onChange={handleChange} required />
      <input type="text" name="nombres" placeholder="Nombres" value={formData.nombres} onChange={handleChange} required />
      <input type="text" name="apellidos" placeholder="Apellidos" value={formData.apellidos} onChange={handleChange} required />
      <input type="date" name="fechaNacimiento" value={formData.fechaNacimiento} onChange={handleChange} required />
      <input type="text" name="direccion" placeholder="Dirección" value={formData.direccion} onChange={handleChange} required />

      <select name="idPais" onChange={handleChange} value={formData.idPais} required>
        <option value="">Seleccione País</option>
        {loadingPaises
          ? <option key="loading-pais" disabled>Cargando...</option>
          : paises.map(p => <option key={p.idPais} value={p.idPais}>{p.nombre}</option>)
        }
      </select>

      <select name="idDepartamento" onChange={handleChange} value={formData.idDepartamento} required disabled={!formData.idPais}>
        <option value="">Seleccione Departamento</option>
        {loadingDepartamentos
          ? <option key="loading-departamento" disabled>Cargando...</option>
          : departamentos.map(d => <option key={d.idDepartamento} value={d.idDepartamento}>{d.nombre}</option>)
        }
      </select>

      <select name="idCiudad" onChange={handleChange} value={formData.idCiudad} required disabled={!formData.idDepartamento}>
        <option value="">Seleccione Ciudad</option>
        {loadingCiudades
          ? <option key="loading-ciudad" disabled>Cargando...</option>
          : ciudades.map(c => <option key={c.idCiudad} value={c.idCiudad}>{c.nombre}</option>)
        }
      </select>

      <select name="marca" onChange={handleChange} value={formData.marca} required>
        <option value="">Seleccione Marca</option>
        <option value="AMERICANINO">Americanino</option>
        <option value="AMERICAN_EAGLE">American Eagle</option>
        <option value="CHEVIGNON">Chevignon</option>
        <option value="ESPRIT">Esprit</option>
        <option value="NAF_NAF">Naf Naf</option>
        <option value="RIFLE">Rifle</option>
      </select>

      <button type="submit">Registrar</button>
      <button type="button" onClick={() => navigate("/")}>
          Inicio
        </button>
    </form>
  );
}
