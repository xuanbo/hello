(function($){
    $(function(){

        $('#signIn').on('click', function () {
            var name = $('#name').val();
            var password = $('#password').val();
            if (name == '' || password == ''){

            }else{
                var data = {
                    name: name,
                    password: password
                };
                data = JSON.stringify(data);

                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    dataType: "json",
                    url: "/login",
                    data: data,
                    success: function(result){
                        if (result.flag == 'true'){
                            window.location.assign('/');
                        }
                    }
                });
            }
        })
    });
})(jQuery)