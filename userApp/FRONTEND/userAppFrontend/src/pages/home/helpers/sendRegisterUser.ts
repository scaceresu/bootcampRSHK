import { type UserRegisterPayload } from '../interface/UserRegisterPayload';


// ✅ Definir la URL aquí
const API_URL = "http://localhost:8080/api/registrar";

export const sendRegisterUser = async (user: UserRegisterPayload ): Promise<void> => {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  });

  if (!response.ok) {
    // leer texto primero
    const text = await response.text();
    let errorMessage = "Error al registrar usuario";

    // si hay contenido y es JSON, parsearlo
    if (text) {
      try {
        const errorData = JSON.parse(text);
        errorMessage = errorData.message || errorMessage;
      } catch {
        errorMessage = text; // si no es JSON, usar texto
      }
    }

    throw new Error(errorMessage);
  }
};
