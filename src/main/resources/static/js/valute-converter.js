$(function () {

    // Запрос у API списка валют для размещения его на странице
    $.ajax({
        url: '/converter/getList',
        type: 'POST',
        success: function (valutesListDto) {
            for (var i = 0; i < valutesListDto.codes.length; i++) {
                $('#sourceValuteCode').append('<option>' + valutesListDto.codes[i] + '</option>');
            }
        }
    });

    // Вывод всплывающего окна при неверном вводе суммы
    function errorMessageWrongValue() {
        $('#overlay').fadeIn(300, function () {
            $('#wrongValue')
                .css('display', 'block')
                .animate({opacity: 1}, 300);
            window.getSelection().removeAllRanges();
        });
    }

    // Вывод всплывающего окна при отсутствии выбора валюты
    function errorMessageWrongValuteCode() {
        $('#overlay').fadeIn(300, function () {
            $('#wrongCode')
                .css('display', 'block')
                .animate({opacity: 1}, 300);
            window.getSelection().removeAllRanges();
        });
    }

    // Закрытие всплывающего окна ошибки ввода суммы
    $('#wrongValueModalClose, #overlay').click(function () {
        $('#wrongValue').animate({opacity: 0}, 300, function () {
            $(this).css('display', 'none');
            $('#overlay').fadeOut(300);
        });
    });

    // Закрытие всплывающего окна ошибки выбора валюты
    $('#wrongValuteCodeModalClose, #overlay').click(function () {
        $('#wrongCode').animate({opacity: 0}, 300, function () {
            $(this).css('display', 'none');
            $('#overlay').fadeOut(300);
        });
    });

    // Проверка правильности ввода суммы при снятии фокуса с поля ввода
    $('#valueToConvert').blur(function () {
        let value = $(this).val();
        if (!value || !($.isNumeric(value) && value >= 0)) {
            $(this).css("border-color", "red");
            errorMessageWrongValue();
        } else {
            $(this).css("border", "");
        }
    });

    // Проверка правильности выбора валюты и снятие красной рамки в случае, если ранее она была назначена
    $('#sourceValuteCode').change(function () {
        let code = $(this).val();
        if (code) {
            $(this).css("border", "");
        }
    })

    // Проверка правильности ввода суммы и выбора валюты, если все нормально, то запрос курса валюты и расчет конвертированной суммы
    // В случае ошибок вызвать соответствующее всплывающее окно и подсветить красной рамкой соответствующее поле
    // Повторная проверка поля ввода суммы нужна на случай игнорирования пользователем сообщения после неправильного ввода,
    // в этом случае неверное значение может остаться в поле, а проверка при уходе фокуса с поля уже не будет проводиться
    $('#getRate').click(function () {
        let valuteCode = $('#sourceValuteCode').val();
        let value = $('#valueToConvert').val();
        if (!valuteCode) {
            $('#sourceValuteCode').css("border-color", "red");
            errorMessageWrongValuteCode();
            $('#receivedRate').text('');
        } else if (!value || !($.isNumeric(value) && value >= 0)) {
            $('#valueToConvert').css("border-color", "red");
            errorMessageWrongValue();
        } else {
            $('#sourceValuteCode').css("border", "");
            $.ajax({
                url: '/converter/getRate?code=' + valuteCode,
                type: 'POST',
                success: function (valuteRateDto) {
                    let price = valuteRateDto.rate * value;
                    if (!price) {
                        alert('Сервер вернул неверную стоимость данной валюты. Возможно, это вызвано ошибкой сервера, ' +
                            'или же сервер прекратил поставку информации по данной валюте. Попробуйте обновить страницу.');
                    } else {
                        $('#receivedRate').text('Стоимость ' + value + ' ' + valuteCode + ' в рублях на сегодня составляет '
                            + price.toFixed(2));
                    }
                }
            });
        }
    });
});