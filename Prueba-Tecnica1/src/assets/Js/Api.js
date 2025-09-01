const API_URL = "http://localhost:8080/api";

export async function getClientes() {
  try {
    const res = await fetch(`${API_URL}/clientes`);
    if (!res.ok) throw new Error("Error al obtener clientes");
    return await res.json();
  } catch (err) {
    console.error(err);
    return [];
  }
}

export async function saveCliente(cliente) {
  try {
    const payload = {
      tipoIdentificacion: cliente.tipoIdentificacion,
      numeroIdentificacion: cliente.numeroIdentificacion,
      nombres: cliente.nombres,
      apellidos: cliente.apellidos,
      fechaNacimiento: cliente.fechaNacimiento,
      direccion: cliente.direccion,
      pais: cliente.pais,           
      departamento: cliente.departamento,
      ciudad: cliente.ciudad,       
      marca: cliente.marca,
    };

    console.log("Payload a enviar:", payload);

    const res = await fetch(`${API_URL}/clientes`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(payload),
    });

    if (!res.ok) {
      const errorText = await res.text();
      throw new Error(`Error al guardar cliente: ${errorText}`);
    }

    return await res.json();
  } catch (err) {
    console.error(err);
    throw err;
  }
}

export async function getPaises() {
  try {
    const res = await fetch(`${API_URL}/paises`);
    if (!res.ok) throw new Error("Error al obtener países");
    return await res.json();
  } catch (err) {
    console.error(err);
    return [];
  }
}

export async function getDepartamentos(idPais) {
  if (!idPais) return [];
  try {
    const res = await fetch(`${API_URL}/departamentos/porPais/${idPais}`);
    if (!res.ok) throw new Error(`Error al obtener departamentos para país ID ${idPais}`);
    return await res.json();
  } catch (err) {
    console.error(err);
    return [];
  }
}

export async function getCiudades(idDepartamento) {
  if (!idDepartamento) return [];
  try {
    const res = await fetch(`${API_URL}/ciudades/porDepartamento/${idDepartamento}`);
    if (!res.ok) throw new Error(`Error al obtener ciudades para departamento ID ${idDepartamento}`);
    return await res.json();
  } catch (err) {
    console.error(err);
    return [];
  }
}
