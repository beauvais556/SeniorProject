<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Users List</h3>
<c:if test="${!empty users}">
    <table class="tg">
    <tr>
        <th width="80">Account Number</th>
        <th width="60">Name</th>
        <th width="140">Address</th>
        <th width="60">Phone</th>
        <th width="80">Email</th>
        <th width="60">Employer</th>
        <th width="60">Salary</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.userId}</td>
            <td>${user.firstName} ${user.lastName}</td>
            <td>${user.address}</td>
            <td>${user.phone}</td>
            <td>${user.email}</td>
            <td>${user.employer}</td>
            <td>${user.salary}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>