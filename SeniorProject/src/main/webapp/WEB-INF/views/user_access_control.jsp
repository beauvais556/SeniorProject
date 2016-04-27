<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Persons List</h3>
<c:if test="${!empty userList}">
    <table class="tg">
    <tr>
        <th width="60">User ID</th>
        <th width="60">Name</th>
        <th width="140">Address</th>
        <th width="60">Phone</th>
        <th width="60">Employer</th>
        <th width="60">Salary</th>
        <th width="60">Requested Amount</th>
        <th width="60">SSN</th>
        <th width="60">Disable</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.userId}</td>
            <td>${user.firstName} ${user.lastName}</td>
            <td>${user.address}</td>
            <td>${user.phone}</td>
            <td>${user.employer}</td>
            <td>${user.salary}</td>
            <td>${user.requestedAmt}</td>
            <td>${user.ssn}</td>
            <td><a href="<c:url value='/disable/${user.userId}' />" >Disable</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>