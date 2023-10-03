<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Manage Users</title>
</head>
<style>
    table,th, td {
        border: 1px solid black;
        padding: 10px;
    }
</style>
<body>
<jsp:directive.include file="header.jsp" />
Admin Dashboard
<h2><a href="userForm.jsp">Create New User</a></h2>
<c:if test="${not empty requestScope.success}">
    <div class="message">
        User created
    </div>

</c:if>
   <div>

       <table>
           <tr>
               <th>Index</th>
               <th>Id</th>
               <th>Email</th>
               <th>FullName</th>
               <th>Actions</th>
           </tr>
           <c:forEach var="user" items="${usersList}" varStatus="status">
               <tr>
                   <td>${status.index + 1}</td>
                   <td>${user.userId}</td>
                   <td>${user.email}</td>
                   <td>${user.fullName}</td>
                   <td><a href="#">Edit</a> <a href="#">Delete</a></td>
               </tr>
           </c:forEach>
       </table>


   </div>




<jsp:directive.include file="footer.jsp" />
<script>
    var messageContainer = document.querySelector(".message")
    if(messageContainer){
        setTimeout(function (){
            console.log(123)
            messageContainer.style.visibility = "hidden";
        },2000)
    }
</script>
</body>

</html>
