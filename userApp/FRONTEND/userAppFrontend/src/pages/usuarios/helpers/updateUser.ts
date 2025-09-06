import { fetchWithAuth } from "../../home/helpers/fetchDataLogged";
import type { User } from "../interfaces/User";

export async function updateUser(data: User) {
  const correo = localStorage.getItem("correo");

  if (!correo) {
    throw new Error("No se encontró el correo en el localStorage");
  }

  try {
    const updatedUser: User = await fetchWithAuth(
      `http://localhost:8080/api/user-update/${correo}`,
      {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      }
    );

    return updatedUser; // 👈 ya es el objeto JSON (usuario actualizado)
  } catch (error) {
    console.error("Error en updateUser:", error);
    throw error;
  }
}
