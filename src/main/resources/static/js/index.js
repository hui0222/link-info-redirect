var main = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });

        $('[name=btn-delete]').on('click', function() {
            _this.del($(this).val());
        });

        $('[name=btn-detail]').on('click', function() {
            _this.detail($(this).val());
        });
    },
    save: function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v2/board/insert',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/board/list'
        }).fail(function() {
            alert(JSON.stringify(error));
        })
    },
    del: function (deleteId) {

        $.ajax({
            type: 'GET',
            url: '/api/v1/board/delete/'+deleteId,
            contentType: 'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/board/list'
        }).fail(function() {
            alert(JSON.stringify(error));
        })
    },
    detail: function (detailId) {
        window.location.href = '/board/detail/'+detailId;
    },
};

main.init();