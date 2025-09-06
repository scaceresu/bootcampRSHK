import type { JSX } from "react";
import { Navigate } from "react-router-dom";

interface Props {
  children: JSX.Element;
}

export const PrivateRoute = ({ children }: Props) => {
  const token = localStorage.getItem("token");

  if (!token) {
    // Si no hay token → redirige a login
    return <Navigate to="/login" replace />;
  }

  return children;
};
