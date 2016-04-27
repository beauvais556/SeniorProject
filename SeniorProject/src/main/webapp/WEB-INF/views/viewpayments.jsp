<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Payment History</h3>
<c:if test="${!empty payments}">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Amount</th>
        <th width="120">Date</th>
        <th width="60">Type</th>
    </tr>
    <c:forEach items="${payments}" var="payment">
        <tr>
            <td><c:out value="${payment.id}"/></td>
            <td><c:out value="${payment.amount}"/></td>
            <td><c:out value="${payment.date}"/></td>
            <td><c:out value="${payment.type}"/></td>         
        </tr>
    </c:forEach>
    </table>
</c:if>