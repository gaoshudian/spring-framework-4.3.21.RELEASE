
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  <a href="testMap">Test Map</a>
  <br/><a href="redirect">测试重定向</a>
  <br/><a href="testSessionAttributes">@SessionAttributes注解的用法</a>
  <br/><a href="testInitBinderparam?date=2019-10-31 18:27:30">@InitBinder注解的用法</a>
  <br/><a href="testModelAttribute">测试modelAttribute</a>
  <br/>
  <form action="/fileUpload" enctype="multipart/form-data" method="post">
    选择文件:<input type="file" name="file">
    <input type="submit" value="提交">
  </form>



  </body>
</html>
