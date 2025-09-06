import { useEffect, useState, type FC } from "react";
import "../styles/Mypage.css";
import type { UserInfo } from "../interfaces/UserInfo";
import Vacations from "./Vacations";
import Security from "./Security";
import Antiquity from "./Antiquity";
import MainInfo from "./MainInfo";
import Navbar from "./NavBar";
import { fetchWithAuth } from "../../home/helpers/fetchDataLogged";
import { useNavigate } from "react-router-dom";

export const MyPage: FC = () => {
  const [user, setUser] = useState<UserInfo | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  const navigate = useNavigate()

  useEffect(() => {
    const fetchUser = async () => {
      try {
        const correo = localStorage.getItem("correo")
        console.log(correo)
        const data = await fetchWithAuth(`http://localhost:8080/api/user-info/${correo}`);
        setUser(data);
        console.log(data)
        navigate(`/inicio/`)
      } catch (err: unknown) {
        if (err instanceof Error) {
          setError(err.message);
        } else {
          setError("Ocurrió un error inesperado");
        }
      } finally {
        setLoading(false);
      }
    };
    fetchUser();
  }, []);

  if (loading) return <div className="loading">Cargando información...</div>;
  if (error) return <div className="error">Error: {error}</div>;

  return (
    
    <div className="dashboard-container">
      {/* Navbar */}
      <Navbar />

      {/* Contenido principal */}
      <main className="dashboard-content">
        <header className="welcome-header">
          <h1>
            Bienvenido, {user?.nombre} {user?.apellido} 👋
          </h1>
          <p>Aquí tienes un resumen de tu cuenta:</p>
        </header>
          {user && (
            <div className="dashboard-grid">
              <MainInfo
                nroCedula={user.nroCedula}
                rolNombre={user.rolNombre}
                equipoNombre={user.equipoNombre}
                cargoNombre={user.cargoNombre}
              />
              <Antiquity antiguedad={user.antiguedad} />
              <Vacations
                diasTotales={user.diasVacaciones}
                diasRestantes={user.diasVacaionesRestante}
              />
              <Security
                requiereCambioContrasena={user.requiereCambioContrasena}
                onChangePassword={() => alert("Redirigir a cambio de contraseña")}
              />
            </div>
          )}
      </main>
    </div>
  );
};