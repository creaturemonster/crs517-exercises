<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

  
     <table border="1" cellpadding="5">
         <tr><th>Title</th><th>Director</th><th>Stock</th></tr> 
        <c:forEach var="tempRecording" items="${VIDEO_LIST}">
          <tr>
            <td>${tempRecording.title}</td>
            <td>${tempRecording.director}</td>
            <td>${tempRecording.stockCount}</td>
          </tr>
        </c:forEach>
     </table>
