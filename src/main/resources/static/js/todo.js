$('.add-todo').on('keypress', function (e) {
    e.preventDefault
    if (e.which === 13) {
        if ($(this).val() != '') {
            var todo = $(this).val();
            $.post("/todos/" + todo)
                .done(function (result) {
                    $('.add-todo').val('');

                    var markup = '<tr><td>' + todo + '</td></tr>'
                    $('#todos-table').append(markup);
                })
                .fail(function (jqXHR, textStatus, errorThrown) {
                    alert('Todos cannot be added !');
                })
        }
    }
});