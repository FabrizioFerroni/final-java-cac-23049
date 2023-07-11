const form = document.getElementById('form');

// Nuevas Alertas
let status = document.getElementById("status").value;
let msg = document.getElementById("msg").value;
let nombre2 = document.getElementById("nombre2").value;
let apellido2 = document.getElementById("apellido2").value;
let codigo = document.getElementById("codigo").value;
let tema2 = document.getElementById("tema2").value;

if (form) {
    form.addEventListener('submit', sendForm);
}

function sendForm(e) {
    e.preventDefault();

    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const mensaje = document.getElementById('mensaje').value;

    if (nombre !== '' && apellido !== '' && mensaje !== '') {
       e.currentTarget.submit();
    } else {
     const Toast = Swal.mixin({
                toast: true,
                position: 'top-end',
                showConfirmButton: false,
                timer: 3000,
                timerProgressBar: true,
                didOpen: (toast) => {
                    toast.addEventListener('mouseenter', Swal.stopTimer)
                    toast.addEventListener('mouseleave', Swal.resumeTimer)
                }
            })

            Toast.fire({
                icon: 'warning',
                title: 'Upps... 😣',
                text: 'Tienes que completar todos los campos vacios'
            })
        form.classList.add('was-validated')
        form.classList.remove('needs-validation')
    }
}


if (status == "success") {
let user_new = toNomProp(nombre2) + ' ' + toNomProp(apellido2);
        swal.fire({
            title: 'Gracias ' + user_new + ' 😁',
            text: `${msg}: ${codigo}`,
            icon: 'success',
            showCancelButton: false,
            confirmButtonColor: '#157347',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Aceptar',
            cancelButtonText: 'Cancelar',
            customClass: {
                cancelButton: 'outnone',
                confirmButton: 'outnone',
            }
        });
}

function toNomProp(element) {
    element = element.split(" ").map((palabra) => {
        return palabra[0].toUpperCase() + palabra.substring(1);
    }).join(" ");

    return element;
}
/*
 let user_new = nombre + ' ' + apellido;
        swal.fire({
            title: 'Gracias ' + user_new + ' 😁',
            text: `Te has registrado con éxito, este es tu credencial de acceso: ${id.toLocaleUpperCase()}`,
            icon: 'success',
            showCancelButton: false,
            confirmButtonColor: '#157347',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Aceptar',
            cancelButtonText: 'Cancelar',
            customClass: {
                cancelButton: 'outnone',
                confirmButton: 'outnone',
            }
        }).then((result) => {
            if (result.isConfirmed) {
                form.classList.add('needs-validation')
                form.classList.remove('was-validated')
                form.reset();
            }
        });
        */