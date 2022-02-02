
// Call the dataTables jQuery plugin
$(document).ready(function() {
    document.getElementById("user_front_name").innerHTML = localStorage.usuario;
    cargarEventos();
});

// function getHeaders() {
//   return {
//    'Accept': 'application/json',
//    'Content-Type': 'application/json',
//    'Authorization': localStorage.token
//  };
// }

async function cargarEventos() {

  const request = await fetch('http://localhost:8082/activate/event/events/all', {
    method: 'GET',
    // headers: getHeaders()
  });
  const eventos = await request.json();

  let listadoHtml = '';
  for (let evento of eventos) {
      
      let eventoHtml = '<div class="card">'
                        +  '<img src="dist/img/cards/img1.jpg">'
                        +  '<h4>' +evento.titulo+ '</h4>'
                        +  '<p>' +evento.descripcion+ '</p>'
                        +  '<i class="nav-icon far fa-calendar-alt"> ' +evento.fecha_inicio+ ' | ' +evento.fecha_final+'</i>'
                        +  '<i class="nav-icon fas fa-map-marked-alt"> Mi_casa</i>'
                        +  '<a onclick="verEvento(event)" href="event.html">Leer más</a>'
                        +  '<span id="demo" hidden="hidden">' + evento.id + '</span>'
                      + '</div>';

      listadoHtml += eventoHtml;   
  }
  document.querySelector('#lista_eventos').innerHTML = listadoHtml;
    
}

function verEvento(event){
  // console.log(event.target);
  const hijo = event.target.nextElementSibling.innerHTML;
  // console.log(hijo);
  localStorage.removeItem('verEvento');
  localStorage.verEvento = hijo;
}