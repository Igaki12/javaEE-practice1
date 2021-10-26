<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("user_name");
String gender = request.getParameter("gender");
String box = request.getParameter("form_box");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inquiries</title>
</head>
<body>
<p><%=name%>,<%=gender%>,<%=box%>で登録されました！</p>

</body>
</html>