function getlink() {
    let aux = document.createElement('input');
    aux.setAttribute('value', window.location.href.split('?')[0].split('#')[0]);
    document.body.appendChild(aux);
    aux.select();
    document.execCommand('copy');
    document.body.removeChild(aux);
    let css = document.createElement('style');
    let estilo = document.createTextNode('#aviso {position:fixed; z-index: 9999999; top: 50%;left:50%;margin-left: -70px;padding: 20px; background: gold; color: #fff; border-radius: 8px;font-family: sans-serif;}');
    css.appendChild(estilo);
    document.head.appendChild(css);
    let aviso = document.createElement('div');
    aviso.setAttribute('id', 'aviso');
    let contenido = document.createTextNode('URL copiada');
    aviso.appendChild(contenido);
    document.body.appendChild(aviso);
    window.load = setTimeout('document.body.removeChild(aviso)', 2000);
}



let codigo2 = document.getElementById("codigo2").value;

const $imagen = document.querySelector("#codigo"),
        $boton = document.querySelector("#btnDescargar");
new QRious({
    element: $imagen,
    value: window.location.href.split('?')[0].split('#')[0], // La URL o el texto
    size: 500,
    backgroundAlpha: 0, // 0 para fondo transparente
    foreground: "#fff", // Color del QR
    level: "H", // Puede ser L,M,Q y H (L es el de menor nivel, H el mayor)
});
$boton.onclick = () => {
    const enlace = document.createElement("a");
    enlace.href = $imagen.src;
    enlace.download = `Ticket ${codigo2}`;
    enlace.click();
}