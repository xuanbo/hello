<%--
  Created by IntelliJ IDEA.
  User: xuan
  Date: 2015/12/26
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/assets/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="/assets/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/bootstrap/js/bootstrap.min.js"></script>
    <title>测试页面</title>
</head>
<body>

  <div style="text-align: center;">
    <c:if test="${not empty users}">
      <c:forEach items="${users}" var="e">
        <div>${e.getId()}----${e.getName()}----${e.getPassword()}</div>
      </c:forEach>
    </c:if>
  </div>

    name: <input id="name" name="name" placeholder="请输入用户名："/>
    password: <input id="password" name="password" placeholder="请输入密码："/>
    <button id="login" class="btn btn-primary">登录</button>

  <script>
    ;(function($){
      $(function(){
        $('#login').on('click', function () {
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
              contentType: "application/json",//必须有
              dataType: "json",//返回值，不必须
              url: "/login",
              data: data,
              success: function(result){
                alert(result.msg);
              }
            });
          };
        });

      });
    })(jQuery);
  </script>
</body>
</html>
