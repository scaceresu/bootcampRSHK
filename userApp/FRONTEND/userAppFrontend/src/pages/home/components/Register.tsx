import { useState, type FC, type ChangeEvent, type FormEvent, useEffect } from "react";
import type { UserRegister } from "../interface/UserRegister";
import type { Cargo } from "../../usuarios/interfaces/Cargo";
import type { Rol } from "../../usuarios/interfaces/Rol";
import type { Equipo } from "../../usuarios/interfaces/Equipo";
import { sendRegisterUser } from "../helpers/sendRegisterUser";
import type { UserRegisterPayload } from "../interface/UserRegisterPayload";
import { useNavigate } from "react-router-dom";

// Tipos para los selects

// Tipo del usuario a registrar



export const Register: FC = () => {
  const [user, setUser] = useState<UserRegister>({
    nroCedula:0,
    nombre: "",
    apellido: "",
    correo: "",
    telefono: "",
    idRol: "",
    idEquipo: "",
    idCargo: "",
    fechaIngreso: "",
    fechaNacimiento: "",
    diasVacaciones: 0,
    estado: true,
    requiereCambioContrasena: false,
    contrasena: "",
  });

  const [loading, setLoading] = useState(false);
  const [cargos, setCargos] = useState<Cargo[]>([]);
  const [roles, setRoles] = useState<Rol[]>([]);
  const [equipos,setEquipos] = useState<Equipo[]>([]);

  const navigate = useNavigate()


//   Traer los datos para los select 
useEffect(() => {
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

  }, []);



  const handleChange = (e: ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    const { name, value, type, checked } = e.target;
    setUser({
      ...user,
      [name]: type === "checkbox" ? checked : value,
    });
  };

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();
    setLoading(true);
    try {

        const payload: UserRegisterPayload = {
            ...user,
            nroCedula: Number(user.nroCedula),
            idRol: user.idRol ? Number(user.idRol) : null,
            idEquipo: user.idEquipo ? Number(user.idEquipo) : null,
            idCargo: user.idCargo ? Number(user.idCargo) : null,
            diasVacaciones: user.diasVacaciones ? Number(user.diasVacaciones) : null,
            fechaIngreso: user.fechaIngreso || null,
            fechaNacimiento: user.fechaNacimiento || null,
        };


    console.log("====> PAYLOAD <-=====")
    console.log(payload)
      await sendRegisterUser(payload);
      alert("Usuario registrado con éxito");
      setUser({
        nroCedula:0,
        nombre: "",
        apellido: "",
        correo: "",
        telefono: "",
        idRol: 0,
        idEquipo: 0,
        idCargo: 0,
        fechaIngreso: "",
        fechaNacimiento: "",
        diasVacaciones: 0,
        estado: true,
        requiereCambioContrasena: false,
        contrasena: "",
      });
      navigate("/login")
    } catch (error) {
      alert((error as Error).message);
    } finally {
      setLoading(false);
    }
  };


//   use effect para rellenar los datos de los select 

    

  return (
    <div className="login-container">
      <h2 className="login-title">Registrar Usuario</h2>
      <form className="login-form" onSubmit={handleSubmit}>
        <input
          className="login-input"
          type="text"
          name="nroCedula"
          placeholder="nroCedula"
          value={user.nroCedula}
          onChange={handleChange}
          required
        />
        <input
          className="login-input"
          type="text"
          name="nombre"
          placeholder="Nombre"
          value={user.nombre}
          onChange={handleChange}
          required
        />
        <input
          className="login-input"
          type="text"
          name="apellido"
          placeholder="Apellido"
          value={user.apellido}
          onChange={handleChange}
          required
        />
        <input
          className="login-input"
          type="email"
          name="correo"
          placeholder="Correo"
          value={user.correo}
          onChange={handleChange}
          required
        />
        <input
          className="login-input"
          type="text"
          name="telefono"
          placeholder="Teléfono"
          value={user.telefono}
          onChange={handleChange}
        />

        <select
          className="login-input"
          name="idRol"
          value={user.idRol}
          onChange={handleChange}
          required
        >
          <option value="">Seleccione un rol</option>
          {roles.map((rol) => (
            <option key={rol.id} value={rol.id}>
              {rol.nombre}
            </option>
          ))}
        </select>

        <select
          className="login-input"
          name="idEquipo"
          value={user.idEquipo}
          onChange={handleChange}
        >
          <option value="">Seleccione un equipo</option>
          {equipos.map((equipo) => (
            <option key={equipo.id} value={equipo.id}>
              {equipo.nombre}
            </option>
          ))}
        </select>

        <select
          className="login-input"
          name="idCargo"
          value={user.idCargo}
          onChange={handleChange}
        >
          <option value="">Seleccione un cargo</option>
          {cargos.map((cargo) => (
            <option key={cargo.id} value={cargo.id}>
              {cargo.nombre}
            </option>
          ))}
        </select>

        <input
          className="login-input"
          type="date"
          name="fechaIngreso"
          value={user.fechaIngreso}
          onChange={handleChange}
        />
        <input
          className="login-input"
          type="date"
          name="fechaNacimiento"
          value={user.fechaNacimiento}
          onChange={handleChange}
        />
        <input
          className="login-input"
          type="number"
          name="diasVacaciones"
          value={user.diasVacaciones}
          onChange={handleChange}
        />

        <label>
          <input
            type="checkbox"
            name="estado"
            checked={user.estado}
            onChange={handleChange}
          />
          Activo
        </label>

        <label>
          <input
            type="checkbox"
            name="requiereCambioContrasena"
            checked={user.requiereCambioContrasena}
            onChange={handleChange}
          />
          Requiere cambio de contraseña
        </label>

        <input
          className="login-input"
          type="password"
          name="contrasena"
          placeholder="Contraseña"
          value={user.contrasena}
          onChange={handleChange}
          required
        />

        <button className="login-btn" type="submit" disabled={loading}>
          {loading ? "Registrando..." : "Registrar"}
        </button>
      </form>
    </div>
  );
};
