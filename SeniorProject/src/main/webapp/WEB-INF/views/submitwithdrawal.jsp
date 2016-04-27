<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div>
            <div class="dash_titles">Submit A Withdrawal Request</div>

	<div class="dash_forms">
         <form:form action="submitWithdrawalRequest" commandName="withdrawal">
            
                <form:input type="text" placeholder="Amount" path="amount" />
            
                <form:input type="text" placeholder="Date" path="date" />
            
                <form:input type="text" placeholder="Type" path="type" />
                
                <div class="submit-button" style="margin-top: 10px;">
                    <input type="submit" value="Submit" />
                </div>
            
        </form:form>
    </div>

</div>