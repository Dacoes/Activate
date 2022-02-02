
// Call the dataTables jQuery plugin
$(document).ready(function() {
  document.getElementById("user_front_name").innerHTML = localStorage.usuario;
    cargarEvento();
});

function getHeaders() {
  return {
   'Accept': 'application/json',
   'Content-Type': 'application/json',
   'Authorization': localStorage.token,
   'Event_id': localStorage.verEvento
 };
}

async function cargarEvento() {

  const request = await fetch('http://localhost:8082/activate/event/' + Number(localStorage.verEvento), {
    method: 'GET',
    // headers: getHeaders()
  });
  const evento = await request.json();

  document.querySelector('#user_name').innerHTML = evento.titulo;
  document.querySelector('#event_description').innerHTML = evento.descripcion;
  fecha_evento = "Inicio:"+evento.fecha_inicio + "    Fin:"+evento.fecha_final
  document.querySelector('#calendario_evento').innerHTML = fecha_evento;
    
}

async function registraseEvento(){

  const request = await fetch('http://localhost:8082/activate/assist/create', {
    method: 'POST',
    headers: getHeaders()
  });
  alert("Registro Exitoso!");
  window.location.href = 'user.html'
}