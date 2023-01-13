<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%	
RequestDispatcher dispatcher;
dispatcher=request.getRequestDispatcher("/WEB-INF/Views/Login.jsp");
dispatcher.forward(request, response); %>
</body>
</html>