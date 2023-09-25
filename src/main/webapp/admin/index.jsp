<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
<jsp:directive.include file="header.jsp" />
Admin Dashboard
<div>
    <h2>Welcome Admin | <a href="logout">logout</a></h2>
</div>
<div>
    Quick Actions:
    <a>Create Customer</a>
    <a>Create User</a>
    <a>New Book</a>
    <a>New Category</a>
</div>
<div>
    <a>Recent Sales</a>
    <a>Recent Reviews</a>
</div>
<jsp:directive.include file="footer.jsp" />
</body>
</html>
