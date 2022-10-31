var main= {
    init : function (){
        var _this = this;
        $('#btn-save').on('click',function (){
            alert('뭐노 시발')
            _this.save();
        });
    },
    save: function (){
        var data = {
            title: $('#title').val(),
            author: $('#content').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data:JSON.stringify(data)
        }).done(function (){
            alert('글이 동록되었습니다')
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();