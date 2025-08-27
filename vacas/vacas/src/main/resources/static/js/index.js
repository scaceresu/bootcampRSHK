// ---------- Modal Editar ----------
const modalEditar = document.getElementById('modalEditar');
const btnEditar = document.getElementById('btnEditar');
const closeEditar = document.getElementById('closeModalEditar');
const submitEditar = document.getElementById('submitId');
const inputEditar = document.getElementById('usuarioId');

// Abrir modal editar
btnEditar.onclick = () => modalEditar.style.display = 'block';
// Cerrar modal editar
closeEditar.onclick = () => modalEditar.style.display = 'none';
// Cerrar modal al hacer click afuera
window.onclick = (e) => {
    if (e.target === modalEditar) modalEditar.style.display = 'none';
    if (e.target === modalGrupo) modalGrupo.style.display = 'none';
};
// Redirigir al editar
submitEditar.onclick = () => {
    const id = inputEditar.value;
    if (id) {
        window.location.href = `/usuario/editar/${id}`;
    } else {
        alert("Por favor ingrese un ID válido");
    }
};
// Enviar con Enter
inputEditar.addEventListener("keydown", (e) => {
    if (e.key === "Enter") submitEditar.click();
});


// ---------- Modal Consultar por Grupo ----------
const modalGrupo = document.getElementById('modalGrupo');
const btnGrupo = document.getElementById('btnGrupo');
const closeGrupo = document.getElementById('closeModalGrupo');
const submitGrupo = document.getElementById('submitGrupo');
const inputGrupo = document.getElementById('grupoNombre');

// Abrir modal grupo
btnGrupo.onclick = () => modalGrupo.style.display = 'block';
// Cerrar modal grupo
closeGrupo.onclick = () => modalGrupo.style.display = 'none';
// Redirigir al consultar grupo
submitGrupo.onclick = () => {
    const grupo = inputGrupo.value.trim();
    if (grupo) {
        window.location.href = `/usuario/consultar-por-equipo/${grupo}`;
    } else {
        alert("Por favor ingrese un grupo válido");
    }
};
// Enviar con Enter
inputGrupo.addEventListener("keydown", (e) => {
    if (e.key === "Enter") submitGrupo.click();
});
