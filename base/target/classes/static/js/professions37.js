$(function () {
    $("a[id^='prof']").click(function (event) {
        if (confirm($(this).attr('data-confirm-text'))) {
            let professionCode = $(this).attr('name').replace('prof_', '');
            $.ajax({
                url: '/professions/' + professionCode,
                type: 'DELETE',
                success: function (result) {
                    if (result.success) {
                        location.href = '/professions';
                    }
                }
            });
        }
        event.preventDefault();
    });
});