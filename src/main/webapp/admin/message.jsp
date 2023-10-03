<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
<jsp:directive.include file="header.jsp" />
<div>

<c:if test="${not empty requestScope.success}">
    <h2>
        ${requestScope.message}
    </h2>
</c:if>

</div>
<jsp:directive.include file="footer.jsp" />
</body>
</html>
