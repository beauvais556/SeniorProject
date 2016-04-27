<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Persons List</h3>
<c:if test="${!empty pendingUsers}">
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
        <th width="60">Approve</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${pendingUsers}" var="pendingUser">
        <tr>
            <td>${pendingUser.userId}</td>
            <td>${pendingUser.firstName} ${pendingUser.lastName}</td>
            <td>${pendingUser.address}</td>
            <td>${pendingUser.phone}</td>
            <td>${pendingUser.employer}</td>
            <td>${pendingUser.salary}</td>
            <td>${pendingUser.requestedAmt}</td>
            <td>${pendingUser.ssn}</td>
            <td><a href="<c:url value='/approve/${pendingUser.userId}' />" >Approve</a></td>
            <td><a href="<c:url value='/reject/${pendingUser.userId}' />" >Reject</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>