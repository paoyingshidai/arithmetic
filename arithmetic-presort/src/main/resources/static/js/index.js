
function handleClick() {
    alert('点击时间')
}

(function(document, window, $) {

    $('#abtn').on('click', function() {
        btnClick();
    })

})(document, window, jQuery);

function btnClick() {
    console.log($('#button').val().trim());
}