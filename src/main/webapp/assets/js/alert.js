let status = document.getElementById("status").value;
let msg = document.getElementById("msg").value;

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


if (status == "warning") {
    Toast.fire({
        icon: 'warning',
        title: 'Upps... 😣',
        text: msg
                // text: 'Tienes que completar todos los campos vacios'
    })
}

if (status == "success") {
    Toast.fire({
        icon: 'success',
        title: 'Éxito 😁',
        text: msg
    });
    
   // setTimeout( function() { window.location.href = "/iniciarsesion"; }, 3500 );
}

if (status == "failed") {
    Toast.fire({
        icon: 'error',
        title: 'Upps... 😣',
        text: msg
    })
}