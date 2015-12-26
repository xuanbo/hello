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

</body>
</html>
