<%@page import="rbca.com.dao.Permission"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>

<%
Object roleObj = session.getAttribute("roleId");

if(roleObj == null){
    out.println("Please login first");
    return;
}

int roleId = Integer.parseInt(roleObj.toString());

boolean canViewSalary = Permission.canView(roleId,"employees","salary");
%>

<table border="1">
<tr>
 <th>name</th>

 <% if(canViewSalary){ %>
   <th>salary</th>
 <% } %>

</tr>
</table>

</body>
</html>
