import { useState, type FC } from "react";
import { useNavigate } from "react-router-dom";
import "../styles/Mypage.css";
import { logoutButton } from "../../home/helpers/logout";

const Navbar: FC = () => {
  const navigate = useNavigate();
  const [perfilDropdown, setPerfilDropdown] = useState(false);
  const [configDropdown, setConfigDropdown] = useState(false);

  const togglePerfilDropdown = () => setPerfilDropdown(!perfilDropdown);
  const toggleConfigDropdown = () => setConfigDropdown(!configDropdown);


  function handleLogout(){
    logoutButton(navigate)
  }

  return (
    <nav className="navbar">
      <div className="navbar-logo" onClick={() => navigate("/inicio")}>MiDashboard</div>
      <div className="navbar-links">
        {/* Dropdown Mi Perfil */}
        <div className="dropdown">
          <button onClick={togglePerfilDropdown}>Mi Perfil</button>
          <div className={`dropdown-content ${perfilDropdown ? "show" : ""}`}>
            <button onClick={() => navigate("/update")}>Actualizar Perfil</button>
          </div>
        </div>

        {/* Dropdown Configuración */}
        <div className="dropdown">
          <button onClick={toggleConfigDropdown}>Configuración</button>
          <div className={`dropdown-content ${configDropdown ? "show" : ""}`}>
            <button onClick={() => navigate("/settings")}>Ajustes</button>
            <button onClick={() => navigate("/settings/delete")}>Eliminar Cuenta</button>
          </div>
        </div>

        <button onClick={() => handleLogout() }>Cerrar Sesión</button>
      </div>
    </nav>
  );
};

export default Navbar;
