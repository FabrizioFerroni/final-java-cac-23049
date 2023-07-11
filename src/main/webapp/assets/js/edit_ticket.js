let cantidad = document.getElementById("cantidad");
let totalInput = document.getElementById("total");
let categoria = document.getElementById("categoria");

let valorTicket = 200;
let valorTicketDesc = 0;
const ESTUDIANTE = 0.2;
const TRAINEE = 0.5;
const JUNIOR = 0.85;


function changeTotal() {
    const typeLower = categoria.value.toLowerCase();
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
    total = cantidad.value * valorTicketDesc;
    totalInput.value = total;
    return total;
}