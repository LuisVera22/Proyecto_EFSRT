
document.getElementById('open-cart').addEventListener('click', function() {
    document.getElementById('cart-modal').style.display = 'block';
});


document.getElementsByClassName('close')[0].addEventListener('click', function() {
    document.getElementById('cart-modal').style.display = 'none';
});


window.onclick = function(event) {
    var modal = document.getElementById('cart-modal');
    if (event.target == modal) {
        modal.style.display = "none";
    }
};


document.getElementById('pay-button').addEventListener('click', function() {
    alert('Implementación de pago aquí');
});
