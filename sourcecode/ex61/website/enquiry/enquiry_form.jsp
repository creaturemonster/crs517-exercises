<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <title>Rainforest Enquiry Form</title>
     <link rel="stylesheet" href="../style/rainforest.css" type="text/css" />
  </head>
  <body>
    	<div id="contactPage">
        
		 <p>
    	    Please complete the form below with your enquiry.  (* required fields)
	     </p>

 		 <p>
    
      <!-- 
          TODO  Define a Spring <form> tag here with the modelAttribute attribute set to "enquiry"
       -->
      <form:form modelAttribute="enquiry">
    
    	   <table border="0" cellpadding="0">
            <tr>                                            
              <td><label for="name">* Contact name</label>  
              		<form:errors path="name" cssClass="validationErrors"/>
              <!--  TODO  Define a Spring form errors tag here with path="name"-->
              
             </td>
            </tr> 
            <tr>    
              <td>
			
			<!--  TODO Define a Spring form input tag here with a path attribute of "name" -->     
				<form:input path="name" size="45" />
             &nbsp;</td>
            </tr>
         
			<!--
			    TODO Examine the rest of this JSP page, noting the input fields
			
			 -->
		    
            <tr>
              <td><br><label for="email">* Email address</label> <form:errors path="email"  cssClass="validationErrors"/></td>
            </tr>
            <tr>
              <td><form:input path="email" size="45"/></td>
            </tr>
            <tr>
              <td><br><label for="telephone">Telephone number</label></td>
            </tr>
            <tr>
              <td><form:input path="telephone" size="45"/></td>
            </tr>
            <tr>
              <td><br><label for="message">* Enquiry Details</label> <form:errors path="enquiryDetails"  cssClass="validationErrors"/></td>
            </tr>
            <tr>
              <td><form:textarea path="enquiryDetails" cols="70" rows="5"/></td>
            </tr>
            <tr>
              <td><br><input type="submit" value="Submit Enquiry"/></td>
            </tr>
           </table>
		 </form:form>
        </p>
    </div>

  </body>
</html>