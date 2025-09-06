import { useState } from 'react';
import { loginUser } from "../helpers/LoginUser";
import "../styles/Login.css"
import { useNavigate } from 'react-router-dom';

export const Login = () => {
  const [correo, setCorreo] = useState("");
  const [contrasena, setContrasena] = useState("");
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const handleSubmit = async (e: React.FormEvent) => {
      e.preventDefault();

      try {
        setLoading(true);
        await loginUser({ correo, contrasena });
        alert("Login exitoso");
        navigate("/inicio");
      } catch (error) {
        alert((error as Error).message);
      } finally {
        setLoading(false);
      }
  };

  return (
    <div className="login-container">
      <h2 className="login-title">Iniciar Sesión</h2>
      <form className="login-form" onSubmit={handleSubmit}>
        <input
          className="login-input"
          type="email"
          placeholder="Correo"
          value={correo}
          onChange={(e) => setCorreo(e.target.value)}
        />

        <input
          className="login-input"
          type="password"
          placeholder="Contraseña"
          value={contrasena}
          onChange={(e) => setContrasena(e.target.value)}
        />

        <button className="login-btn" type="submit" disabled={loading}>
          {loading ? "Iniciando..." : "Iniciar Sesión"}
        </button>
      </form>
      <p className="login-link" onClick={() => navigate("/registrar")}>¿No tienes cuenta? Regístrate</p>
    </div>
  );
};
