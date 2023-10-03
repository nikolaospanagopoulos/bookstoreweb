<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
<jsp:directive.include file="header.jsp" />
Admin Dashboard
<div>
    <h2>Create new user</h2>
    <form id="userform" action="createuser" method="post">
        <div style="display: flex;flex-direction: column;width: 50%;">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email">
            <label for="fullname">Full Name:</label>
            <input type="text" id="fullname" name="fullname">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password">
            <button type="submit">Submit</button>
        </div>
    </form>
</div>

<jsp:directive.include file="footer.jsp" />
<script>
    var fieldFullname = document.getElementById("fullname");
    var fieldPassword = document.getElementById("password");
    var fieldEmail = document.getElementById("email");
    var form = document.getElementById("userform");

    function fieldIsEmpty(field){
        return field.trim().length === 0 || field.length === 0;
    }

    function validateForm(){
        form.addEventListener("submit",function (e){
            e.preventDefault();
            if(fieldIsEmpty(fieldFullname.value) || fieldIsEmpty(fieldEmail.value) || fieldIsEmpty(fieldPassword.value)){
                alert("One of the fields in empty")
                return false;
            }
            if(fieldPassword.value.trim().length <=5){
                alert("Password field should be at least 6 characters long");
                return false;
            }
            form.submit();
        })

    }
    validateForm();




</script>
</body>
</html>
