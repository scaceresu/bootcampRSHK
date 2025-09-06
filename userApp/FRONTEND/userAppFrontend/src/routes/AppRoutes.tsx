import type { FC } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { MyPage } from "../pages/usuarios/Components/MyPage";
import { UpdateProfile } from "../pages/usuarios/Components/UpdateProfile";
import { Login } from "../pages/home/components/Login";
import { PrivateRoute } from "./PrivateRoute";
import { Register } from "../pages/home/components/Register";

export const AppRoutes: FC = () => {
  return (
    <BrowserRouter>
      <Routes>
        {/* Ruta pública */}
        <Route path="/login" element={<Login />} />
        <Route path="/registrar" element={<Register/>} />

        {/* Rutas protegidas */}
        <Route
          path="/inicio"
          element={
            <PrivateRoute>
              <MyPage />
            </PrivateRoute>
          }
        />
        <Route
          path="/update"
          element={
            <PrivateRoute>
              <UpdateProfile />
            </PrivateRoute>
          }
        />
      </Routes>
    </BrowserRouter>
  );
};
