// const usuarios = 
// [
//   {
//     id: 1,
//     name: "Miguel",
//     lastName: "Mosquera",
//     email: "gmail@gmail"
//   },
//   {
//     id: 2,
//     name: "Ana",
//     lastName: "Banana",
//     email: "gmail@gmail"
//   }  
// ];


// Call the dataTables jQuery plugin
$(document).ready(function() {
  document.getElementById("user_front_name").innerHTML = localStorage.usuario;
  cargarUsuarios();
$('#usuarios').DataTable();
});

// function getHeaders() {
//   return {
//    'Accept': 'application/json',
//    'Content-Type': 'application/json',
//    'Authorization': localStorage.token
//  };
// }

function actualizarEmailDelUsuario() {
  document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}


async function cargarUsuarios() {

  const request = await fetch('http://localhost:8082/activate/users/all', {
    method: 'GET',
    // headers: getHeaders()
  });
  const usuarios = await request.json();

  let listadoHtml = '';
  for (let usuario of usuarios) {
    let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>' + usuario.name + ' ' + usuario.lastName + '</td><td>'
                    + usuario.email+'</td><td>'+ " "
                    + '</td>' + '</tr>';
    listadoHtml += usuarioHtml;
  }

  document.querySelector('#example1 tbody').innerHTML = listadoHtml;

}


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