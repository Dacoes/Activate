$(document).ready(function() {
   // on ready
});


async function iniciarSesion() {
  let datos = {};
  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPassword').value;

  const request = await fetch('http://localhost:8082/activate/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  const respuesta = await request.text();
  const peticion = JSON.parse(respuesta);

  if (respuesta != 'FAIL') {
    localStorage.token = peticion.Token;
    localStorage.usuario = peticion.Usuario;
    localStorage.email = datos.email;
    window.location.href = 'user.html'
  } else {
    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
  }

}
