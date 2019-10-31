<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 2019/10/28
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
      names: ${requestScope.names }
      <br/>user requestScope:${requestScope.user}
      <br/>user sessionScope:${sessionScope.user}
      <br/>date requestScope:${requestScope.date}
      <br/>
  </body>
</html>
