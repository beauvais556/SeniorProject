<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>User Loan Info</h3>
<c:if test="${!empty loanInfo}">
    <table class="tg">
    <tr>
        <th width="120">Available Amount</th>
        <th width="120">Credit Limit</th>
        <th width="120">Interest Rate</th>
        <th width="120">Payment Due Date</th>
    </tr>
        <tr>
            <td><c:out value="${loanInfo.availableAmt}"/></td>
            <td><c:out value="${loanInfo.creditLimit}"/></td>
            <td><c:out value="${loanInfo.interestRate}"/>%</td>
            <td><c:out value="${loanInfo.paymentDueDay}"/></td>         
        </tr>
    </table>
</c:if>