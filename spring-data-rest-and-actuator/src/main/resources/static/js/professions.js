$(function () {
    fillData();
});

function fillData() {
    $.get('/api/professions', function (result) {
        let profDataElement = $('#profData');
        let rowsData = '';
        for (let i = 0; i < result._embedded.professions.length; i++) {
            let profession = result._embedded.professions[i];
            rowsData += '<tr><td>' + profession.code + '</td>' +
                '<td>' + profession.name + '</td>' +
                '<td><a href="/profession/edit?code=' + profession.code
                + '"><img title="' + $('#localizedMessages').attr('data-edit')
                + '" src="/images/prof_edit.png"/></a>' +
                '<a data-id="prof_' + profession.code + '" href="profession.html" data-confirm-text="'
                + $('#localizedMessages').attr('data-confirm-text') + '"><img title="' + $('#localizedMessages').attr('data-delete')
                + '" src="/images/prof_delete.png"/></a>' +
                '</td></tr>';
        }
        profDataElement.html(rowsData);

        $('a[data-id^=prof_]').one('click', function (event) {
            if (confirm($(this).attr('data-confirm-text'))) {
                let profCode = $(this).attr('data-id').replace('prof_', '');
                $.ajax({
                    url: '/api/professions/' + profCode,
                    type: 'DELETE',
                    success: function () {
                        location.href = '/professions';
                    }
                });
            }
            event.preventDefault();
        });
    });
}