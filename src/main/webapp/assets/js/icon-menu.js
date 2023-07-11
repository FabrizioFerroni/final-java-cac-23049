(() => {
    const menuBtn = document.querySelector('.navbar-toggler');
    const icon = document.querySelector('.navbar-toggler-icon');
    const icon2 = document.querySelector('.fa-stream');


    menuBtn.addEventListener('click', function() {
        if (icon2.classList.contains('fa-stream')) {
            icon2.classList.remove('fa-stream');
            icon2.classList.add('fa-times');
        } else {
            icon2.classList.remove('fa-times');
            icon2.classList.add('fa-stream');
        }
    });
})();