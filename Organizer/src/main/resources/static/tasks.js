// var myModal = document.getElementById('myModal')
// var myInput = document.getElementById('myInput')

// myModal.addEventListener('shown.bs.modal', function () {
//   myInput.focus()
// })
// var script = document.createElement('script');
// script.src = 'https://code.jquery.com/jquery-3.6.0.min.js';
// document.getElementsByTagName('head')[0].appendChild(script);

// $(".dropdown-menu li a").click(function(){

//     $(this).parents(".form-dropdown").find('.selection').text($(this).text());
//     $(this).parents(".form-dropdown").find('.selection').val($(this).text());
  
//   });

document.getElementById("form-checkbox").checked = true;

$('#filter-date').change(function(){
        $('#send-date').submit();
      });

$(document).ready(function() {
  $('#filter-type').on('change', function() {
    var $form = $(this).closest('form');
    $form.find('input[type=submit]').click();
  });
});