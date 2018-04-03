(function ($) {

    $.confirm = function (params) {

        if ($('#confirmOverlay').length) {
            // A confirm is already shown on the page:
            return false;
        }

        var buttonHTML = '';
        $.each(params.buttons, function (name, obj) {

            // Generating the markup for the buttons:

            buttonHTML += '<a href="#" class="button ' + obj['class'] + '">' + name + '</a>';

            if (!obj.action) {
                obj.action = function () {
                };
            }
        });

        var imgsrc = '';

        if (params.image==null) {
            imgsrc = "assets/img/qtmark.png";
        } else {
            imgsrc = params.image;
        }

        var markup = [
            '<div id="confirmOverlay">',
            '<div id="confirmBox">',
            '<h1>', params.title, '</h1>',
            '<img src="',imgsrc, '" class="gritter-image" style="width: 150px;height: 150px;">',
            '<p>', params.message, '</p>',
            '<div id="confirmButtons">',
            buttonHTML,
            '</div></div></div>'
        ].join('');

        $(markup).hide().appendTo('body').fadeIn();

        var buttons = $('#confirmBox .button'),
                i = 0;

        $.each(params.buttons, function (name, obj) {
            buttons.eq(i++).click(function () {

                // Calling the action attribute when a
                // click occurs, and hiding the confirm.

                obj.action();
                $.confirm.hide();
                return false;
            });
        });
    }

    $.confirm.hide = function () {
        $('#confirmOverlay').fadeOut(function () {
            $(this).remove();
        });
    }

})(jQuery);