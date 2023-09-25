
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<jsp:directive.include file="header.jsp" />
<div>
    <h2>Login</h2>
    <form>
        <label for="inputMail">Email</label>
        <input type="email" name="email" id="inputMail">
        <label for="inputPassword">Password</label>
        <input type="password" name="password" id="inputPassword">
        <button type="submit">Submit</button>
    </form>
</div>
<jsp:directive.include file="footer.jsp" />
</body>
</html>
