<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Disabled Users List</h3>
<c:if test="${!empty disabledUsers}">
    <table class="tg">
    <tr>
        <th width="80">Account Number</th>
        <th width="60">Name</th>
        <th width="140">Address</th>
        <th width="60">Phone</th>
        <th width="80">Email</th>
        <th width="60">Employer</th>
        <th width="60">Salary</th>
        <th width="60">SSN</th>
        <th width="60">Enable</th>
        
    </tr>
    <c:forEach items="${disabledUsers}" var="disabledUser">
        <tr>
            <td>${disabledUser.userId}</td>
            <td>${disabledUser.firstName} ${disabledUser.lastName}</td>
            <td>${disabledUser.address}</td>
            <td>${disabledUser.phone}</td>
            <td>${disabledUser.email}</td>
            <td>${disabledUser.employer}</td>
            <td>${disabledUser.salary}</td>
            <td>${disabledUser.ssn}</td>
            <td><a href="<c:url value='/enable/${disabledUser.userId}' />" >Enable</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>