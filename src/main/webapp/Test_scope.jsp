<%--
  Created by IntelliJ IDEA.
  User: Tibame_T14
  Date: 2023/3/7
  Time: ¤U¤È 02:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5" %>
<%
    pageContext.setAttribute("customer", "peter1");
    request.setAttribute("customer", "peter2");
    session.setAttribute("customer", "peter3");
    application.setAttribute("customer", "peter4");
%>
<html>
<head><title>Test_scope.jsp</title></head>
<body>
pageContext.customer=<%=pageContext.getAttribute("customer")%><br>
request.customer =<%=request.getAttribute("customer")%><br>
session.customer =<%=session.getAttribute("customer")%><br>
application.customer=<%=application.getAttribute("customer")%><br>
</body>
</html>
