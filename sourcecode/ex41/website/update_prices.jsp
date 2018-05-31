<%
	String contextPath = request.getContextPath();
%>
<br/><br/>
<table border="0" cellspacing="10" cellpadding="10" bgcolor="aaaaaa">

<form action="<%= contextPath %>/PriceUpdateServlet" method="POST">
 <tr>
  <td width="20%">
    &nbsp;
  <td>
    <font color="ffff00" font="Arial"><b>Enter percentage price reduction</b></font>
  </td>
  <td>
    <input type="text" name="percentage" size="4"/>
  </td>
  <td>
    <input type="submit" value="update"/>
  </td>
  <td width="20%">
    &nbsp;
  <td>
 </tr>
</form> 