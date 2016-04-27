<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
 <h3>Withdrawal History</h3>
<c:if test="${!empty withdrawals}">
    <table class="tg">
    <tr>
        <th width="60">ID</th>
        <th width="60">Amount</th>
        <th width="60">Date</th>
        <th width="100">Approval Status</th>
        <th width="60">Type</th>
    </tr>
    <c:forEach items="${withdrawals}" var="withdrawal">
        <tr>
            <td><c:out value="${withdrawal.id}"/></td>
            <td><c:out value="${withdrawal.amount}"/></td>
            <td><c:out value="${withdrawal.date}"/></td>
            <td><c:out value="${withdrawal.approvalStatus}"/></td>
            <td><c:out value="${withdrawal.type}"/></td>         
        </tr>
    </c:forEach>
    </table>
</c:if>