export async function getUpdateInfo(id: number) {
  const res = await fetch(`http://localhost:8080/api/user-update/${id}`);
  if (!res.ok) {
    throw new Error("Usuario no encontrado");
  }
  const data = await res.json();
  return data;
}