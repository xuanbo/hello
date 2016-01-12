;(function($){
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
                            if (result.role == "admin"){
                                window.location.assign('/admin/index');
                            }else{
                                window.location.assign('/');
                            }
                        }else{
                            window.location.assign('/login?error');
                        }
                    }
                });
            }
        })
    });
})(jQuery);