import { useEffect, useState } from "react";
import type { Equipo } from "../interfaces/Equipo";
import type { Rol } from "../interfaces/Rol";
import type { User } from "../interfaces/User";
import type { Cargo } from "../interfaces/Cargo";
import Navbar from "./NavBar";
import { updateUser } from "../helpers/updateUser";
import { fetchWithAuth } from "../../home/helpers/fetchDataLogged";

export const UpdateProfile = () => {
  const [user, setUser] = useState<User | null>(null);
  const [equipos, setEquipos] = useState<Equipo[]>([]);
  const [cargos, setCargos] = useState<Cargo[]>([]);
  const [roles, setRoles] = useState<Rol[]>([]);
  const [loading, setLoading] = useState(true);
  const [saving, setSaving] = useState(false); 

  useEffect(() => {
  const correo = localStorage.getItem("correo"); // 🔹 Traemos el correo del localStorage

  const fetchUser = async ()=>{
    // Llamamos a los datos con la autenticacion
      const data = await fetchWithAuth(`http://localhost:8080/api/user-update/${correo}`)
      setUser(data)
      // Traemos los campos de los select 
      Promise.all([
        fetch("http://localhost:8080/api/roles").then((res) => res.json()),
        fetch("http://localhost:8080/api/equipos").then((res) => res.json()),
        fetch("http://localhost:8080/api/cargos").then((res) => res.json()),
      ])
        .then(([ rolesData, equiposData, cargosData]) => {
          setRoles(rolesData);
          setEquipos(equiposData);
          setCargos(cargosData);
        })
        .finally(() => setLoading(false));
    }
    fetchUser()
}, []);


  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    if (!user) return;
    setUser({ ...user, [e.target.name]: e.target.value });
  };


  // ✅ Manejador de submit
  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault(); // previene recarga de página
    if (!user) return;

    try {
      setSaving(true);
      const updated = await updateUser(user);
      setUser(updated);
      alert("Usuario actualizado correctamente");
    } catch (error) {
      alert("Error al actualizar el usuario");
      console.error(error);
    } finally {
      setSaving(false);
    }
  };


  if (loading) return <div className="loading">Cargando datos...</div>;

  return (
    <>
    
    <Navbar/>
    <div className="form-container">
    <h2>Actualizar Perfil</h2>
    <form className="update-form" onSubmit={handleSubmit}>
        {/* ID (solo lectura) */}
        <label htmlFor="id">ID</label>
        <input type="text" id="id" name="id" value={user?.id || ""} readOnly />

        {/* Cédula (solo lectura) */}
        <label htmlFor="nroCedula">Nro. Cédula</label>
        <input
        type="text"
        id="nroCedula"
        name="nroCedula"
        value={user?.nroCedula || ""}
        readOnly
        />

        <label htmlFor="nombre">Nombre</label>
        <input
        type="text"
        id="nombre"
        name="nombre"
        value={user?.nombre || ""}
        onChange={handleChange}
        />

        <label htmlFor="apellido">Apellido</label>
        <input
        type="text"
        id="apellido"
        name="apellido"
        value={user?.apellido || ""}
        onChange={handleChange}
        />

        <label htmlFor="correo">Correo</label>
        <input
        type="email"
        id="correo"
        name="correo"
        value={user?.correo || ""}
        onChange={handleChange}
        />

        <label htmlFor="telefono">Teléfono</label>
        <input
        type="text"
        id="telefono"
        name="telefono"
        value={user?.telefono || ""}
        onChange={handleChange}
        />

        <label htmlFor="idRol">Rol</label>
        <select id="idRol" name="idRol" value={user?.idRol || ""} onChange={handleChange}>
        <option value="">Seleccione un rol</option>
        {roles.map((rol) => (
            <option key={rol.id} value={rol.id}>
            {rol.nombre}
            </option>
        ))}
        </select>

        <label htmlFor="idEquipo">Equipo</label>
        <select
        id="idEquipo"
        name="idEquipo"
        value={user?.idEquipo || ""}
        onChange={handleChange}
        >
        <option value="">Seleccione un equipo</option>
        {equipos.map((equipo) => (
            <option key={equipo.id} value={equipo.id}>
            {equipo.nombre}
            </option>
        ))}
        </select>

        <label htmlFor="idCargo">Cargo</label>
        <select
        id="idCargo"
        name="idCargo"
        value={user?.idCargo || ""}
        onChange={handleChange}
        >
        <option value="">Seleccione un cargo</option>
        {cargos.map((cargo) => (
            <option key={cargo.id} value={cargo.id}>
            {cargo.nombre}
            </option>
        ))}
        </select>

        <label htmlFor="fechaIngreso">Fecha de Ingreso</label>
        <input
        type="date"
        id="fechaIngreso"
        name="fechaIngreso"
        value={user?.fechaIngreso || ""}
        onChange={handleChange}
        />

        <label htmlFor="fechaNacimiento">Fecha de Nacimiento</label>
        <input
        type="date"
        id="fechaNacimiento"
        name="fechaNacimiento"
        value={user?.fechaNacimiento || ""}
        onChange={handleChange}
        />


        <label htmlFor="diasVacaciones">Días de Vacaciones</label>
        <input
        type="number"
        id="diasVacaciones"
        name="diasVacaciones"
        value={user?.diasVacaciones || 0}
        onChange={handleChange}
        />

        <label>
        <input
            type="checkbox"
            name="estado"
            checked={user?.estado || false}
            onChange={(e) => setUser({ ...user!, estado: e.target.checked })}
        />
        Activo
        </label>

        <label>
        <input
            type="checkbox"
            name="requiereCambioContrasena"
            checked={user?.requiereCambioContrasena || false}
            onChange={(e) =>
            setUser({ ...user!, requiereCambioContrasena: e.target.checked })
            }
        />
        Requiere cambio de contraseña
        </label>

        <label htmlFor="contrasena">Contraseña</label>
        <input
        type="password"
        id="contrasena"
        name="contrasena"
        value={user?.contrasena || ""}
        onChange={handleChange}
        />

        <button type="submit" className="submit-btn" disabled={saving}>
        {saving ? "Guardando..." : "Actualizar"}
        </button>
    </form>
    </div>


    </>
  );
};
