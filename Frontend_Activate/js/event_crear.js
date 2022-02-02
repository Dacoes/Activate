$(document).ready(function() {
    document.getElementById("user_front_name").innerHTML = localStorage.usuario;
    // on ready
 });

function getHeaders() {
  return {
   'Accept': 'application/json',
   'Content-Type': 'application/json',
   'Authorization': localStorage.token
 };
}

async function registrarEvento() {
    let datos = {};
    datos.titulo = document.getElementById('input_titulo').value;
    datos.descripcion = document.getElementById('input_descripcion').value;
    datos.ubicacion = document.getElementById('input_ubicacion').value;
    datos.fecha_inicio = document.getElementById('input_inicio').value;
    datos.fecha_final = document.getElementById('input_fin').value;

    if(datos.titulo=="" || datos.descripcion=="" || datos.fecha_inicio=="" || datos.fecha_fin=="" || datos.ubicacion=="" ){
        alert("Debe completar todos los campos");
    }else{
  
        const request = await fetch('http://localhost:8082/activate/event/create', {
            method: 'POST',
            headers: getHeaders(),
            body: JSON.stringify(datos)
        });
        console.log(datos);
        alert("Evento creado con exito!");
        window.location.href = 'user.html';
    }
  
}
  