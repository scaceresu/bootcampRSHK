import type { LoginData } from "../interface/LoginData";
import type { LoginResponse } from "../interface/LoginResponse";

export const loginUser = async (loginData: LoginData): Promise<LoginResponse> => {
  const response = await fetch("http://localhost:8080/api/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json" 
    },
    body: JSON.stringify(loginData),
  });

  if (!response.ok) {
    throw new Error("Correo o contraseña incorrectos");
  }

  const data: LoginResponse = await response.json();

  // Guardamos el token que nos envía el backend
  localStorage.setItem("token", data.token);
  localStorage.setItem("correo", data.correo);

  return data;
};
