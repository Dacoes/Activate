// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
$('#usuarios').DataTable();
});

function actualizarEmailDelUsuario() {
  document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}


async function cargarUsuarios() {

  const request = await fetch('/api/user', {
    method: 'GET',
    // headers: getHeaders()
  });
  const usuarios = await request.json();


  let listadoHtml = '';
  for (let usuario of usuarios) {
    let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>' + usuario.name + ' ' + usuario.lastName + '</td><td>'
                    + usuario.email+'</td><td>'+ " "
                    + '</td><td>' + botonEliminar + '</td></tr>';
    listadoHtml += usuarioHtml;
  }

  document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}

// function getHeaders() {
//   return {
//    'Accept': 'application/json',
//    'Content-Type': 'application/json',
//    'Authorization': localStorage.token
//  };
// }

async function eliminarUsuario(id) {
  if (!confirm('¿Desea eliminar este usuario?')) {
    return;
  }

  const request = await fetch('api/user/' + id, {
    method: 'DELETE',
    // headers: getHeaders()
  });

  location.reload()
}