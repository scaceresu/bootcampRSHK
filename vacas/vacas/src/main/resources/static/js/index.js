// Elementos del DOM
const modal = document.getElementById('modalEditar');
const btn = document.getElementById('btnEditar');
const span = document.getElementById('closeModal');
const submitBtn = document.getElementById('submitId');
const input = document.getElementById('usuarioId');

// Abrir modal al hacer click en "Editar Usuario"
btn.onclick = () => modal.style.display = 'block';

// Cerrar modal al hacer click en X
span.onclick = () => modal.style.display = 'none';

// Cerrar modal si se hace click fuera del contenido
window.onclick = (event) => {
    if (event.target == modal) modal.style.display = 'none';
}

// Redirigir a la URL dinámica al presionar "Editar"
submitBtn.onclick = () => {
    const id = input.value;
    if(id) {
        window.location.href = `/usuario/editar/${id}`;
    } else {
        alert("Por favor ingrese un ID válido");
    }
}

// Permitir enviar con Enter
input.addEventListener("keydown", function(e) {
    if(e.key === "Enter") submitBtn.click();
});
