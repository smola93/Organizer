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