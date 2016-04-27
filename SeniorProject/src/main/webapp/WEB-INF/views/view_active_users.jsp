<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Active Users List</h3>
<c:if test="${!empty activeUsers}">
    <table class="tg">
    <tr>
        <th width="80">Account Number</th>
        <th width="60">Name</th>
        <th width="140">Address</th>
        <th width="60">Phone</th>
        <th width="80">Email</th>
        <th width="60">Employer</th>
        <th width="60">Salary</th>
        <th width="60">Disable</th>
        
    </tr>
    <c:forEach items="${activeUsers}" var="activeUser">
        <tr>
            <td>${activeUser.userId}</td>
            <td>${activeUser.firstName} ${activeUser.lastName}</td>
            <td>${activeUser.address}</td>
            <td>${activeUser.phone}</td>
            <td>${activeUser.email}</td>
            <td>${activeUser.employer}</td>
            <td>${activeUser.salary}</td>
            <td><a href="<c:url value='/disable/${activeUser.userId}' />" >Disable</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>