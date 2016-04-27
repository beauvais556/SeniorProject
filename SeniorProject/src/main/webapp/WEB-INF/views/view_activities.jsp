<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="dash_titles">Activity Log</div>
<c:if test="${!empty activities}">
    <table class="tg">
    <tr>
        <th width="80">Action Performed</th>
        <th width="120">Date</th>
    </tr>
    <c:forEach items="${activities}" var="activity">
        <tr>
            <td>${activity.actionPerformed}</td>
            <td>${activity.date}</td>        
        </tr>
    </c:forEach>
    </table>
</c:if>