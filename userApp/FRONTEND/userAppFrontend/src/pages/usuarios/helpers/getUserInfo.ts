// api.ts
export async function getUserInfo(id: number) {
  const res = await fetch(`http://localhost:8080/api/user-info/${id}`);
  if (!res.ok) {
    throw new Error("Usuario no encontrado");
  }
  const data = await res.json();
  return data;
}
