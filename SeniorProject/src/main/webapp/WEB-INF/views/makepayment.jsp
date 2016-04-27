<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div>
            <div class="dash_titles">Make A Payment</div>
            
	<div class="dash_forms">
         <form:form action="makePayment" commandName="payment"  style="text-align:center;">
            
                <form:input type="text" placeholder="Amount" path="amount" />
            
                <form:input type="text" placeholder="Type" path="type" />
            
                <form:input type="text" placeholder="Date" path="date" />
                
                <div class="submit-button" style="margin-top: 10px;">
                    <input type="submit" value="Make Payment" />
                </div>
            
        </form:form>
     </div>
</div>