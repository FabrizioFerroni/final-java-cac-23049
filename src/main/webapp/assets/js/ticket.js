function getByID(id) {
    return document.getElementById(id);
}
// Declaracion de variables
let Nombre = getByID('nombre');
let Apellido = getByID('apellido');
const Email = getByID('correo');
const Cantidad = getByID('cantidad');
const Categoria = getByID('categoria');
const totalSpan = getByID('total');
const totalInput = getByID('total_input');

// Nuevas Alertas
let status = document.getElementById("status").value;
let msg = document.getElementById("msg").value;
let nombre2 = document.getElementById("nombre2").value;
let apellido2 = document.getElementById("apellido2").value;
let email2 = document.getElementById("email2").value;
let codigo2 = document.getElementById("codigo2").value;
let cantidad2 = document.getElementById("cantidad2").value;
let total2 = document.getElementById("total2").value;
let categoria2 = document.getElementById("categoria2").value;




Categoria.addEventListener('keydown', (e) => {
    e.preventDefault();
});
let valorTicket = 200;
let valorTicketDesc = 0;
const ESTUDIANTE = 0.2;
const TRAINEE = 0.5;
const JUNIOR = 0.85;


function selectCat(type) {
    // Se le asigna el valor de type al input de la cat
    Categoria.value = type;
}

const items = document.querySelectorAll('li');
items.forEach(item => {
    item.addEventListener('click', () => {
        const anterior = document.querySelector('.active');
        if (anterior) anterior.classList.remove('active');
        item.classList.add('active');
    })
});


function changeTotal() {
    const typeLower = Categoria.value.toLowerCase();
    switch (typeLower) {
        case 'estudiante':
            // Un estudiante tiene un descuento de 80%, en vez de hacer (200 * 80 / 100), es lo mismo que hacer (200 * 0.2)
            valorTicketDesc = valorTicket * ESTUDIANTE;
            break;

        case 'trainee':
            // Un trainee tiene un descuento de 50%, en vez de hacer (200 * 50 / 100), es lo mismo que hacer (200 * 0.5)
            valorTicketDesc = valorTicket * TRAINEE;
            break;

        case 'junior':
            // Un junior tiene un descuento de 15%, en vez de hacer (200 * 15 / 100), es lo mismo que hacer (200 * 0.85)
            valorTicketDesc = valorTicket * JUNIOR;
            break;

        default:
            valorTicketDesc = 0;
            break;
    }
    let total = 0;
    total = Cantidad.value * valorTicketDesc;
    totalSpan.innerText = total;
    totalInput.value = total;
    return total;
}

const form = document.getElementById('form');

if (form) {
    form.addEventListener('submit', sendForm);
}


function sendForm(e) {
    e.preventDefault();
    let nombre = Nombre.value;
    let apellido = Apellido.value;
    const email = Email.value;
    const cantidad = Cantidad.value;
    const categoria = Categoria.value;
    const descuento = valorTicketDesc;

    if (nombre !== '' && apellido !== '' && cantidad !== '' && categoria !== '' && email !== '') {
        // Permitir el envío del formulario
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

// Limpiar form
function borrar() {
    Nombre.value = '';
    Apellido.value = '';
    Email.value = '';
    Cantidad.value = '';
    const anterior = document.querySelector('.active');
    if (anterior) anterior.classList.remove('active');
    Categoria.value = '';
    valorTicketDesc = 0;
    totalSpan.innerText = 0;
    form.classList.add('needs-validation')
    form.classList.remove('was-validated')
}


if (status == "success") {
 let div = document.createElement("div");
        div.classList.add("border", "p-4", "rounded-2", "fs-6");
        div.innerHTML = `
        <h1 class="mt-0">Ticket</h1>
        <span class="">${msg}:</span>

        <div class="d-flex gap-2 justify-content-center mt-2">
            <span class="d-flex align-items-end fw-bold">Código de reserva: </span>
            <span class="d-flex align-items-start">${codigo2}</span>
        </div>

        <div class="d-flex gap-2 justify-content-center mt-2">
            <span class="d-flex align-items-end fw-bold">Nombre completo: </span>
            <span class="d-flex align-items-start">${toNomProp(nombre2)} ${toNomProp(apellido2)}</span>
        </div>

        <div class="d-flex gap-2 justify-content-center mt-2">
            <span class="d-flex align-items-end fw-bold">Correo electrónico: </span>
            <span class="d-flex align-items-start">${email2}</span>
        </div>

        <div class="d-flex gap-2 justify-content-center mt-2">
            <span class="d-flex align-items-end fw-bold">Cantidad: </span>
            <span class="d-flex align-items-start">${cantidad2}</span>
        </div>
        
        <div class="d-flex gap-2 justify-content-center mt-2">
            <span class="d-flex align-items-end fw-bold">Categoria: </span>
            <span class="d-flex align-items-start">${categoria2}</span>
        </div>
        <div class="d-flex gap-2 justify-content-center mt-2">
            <span class="d-flex align-items-end fw-bold">Total a pagar: </span>
            <span class="d-flex align-items-start">$${total2}</span>
        </div>
        `
        let user_new = toNomProp(nombre2) + ' ' + toNomProp(apellido2);
        swal.fire({
            title: 'Resumen del pedido de: ' + user_new + ' 😁',
            html: div,
            icon: 'success',
            showCancelButton: false,
            confirmButtonColor: '#157347',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Aceptar',
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

function cadenaAleatoria(longitud) {
    const banco = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    let aleatoria = "";
    for (let i = 0; i < longitud; i++) {
        aleatoria += banco.charAt(Math.floor(Math.random() * banco.length));
    }
    return aleatoria;
};