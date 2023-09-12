<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctors List</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
    $("#deleteid").click(function() {
    	 
    	 var recordId = $(this).data('id');
    	
    	 
    	 // Get the dynamic data from the input field
    	//alert("dynamicData"+recordId)
        // Make an AJAX GET request to your Spring MVC controller
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/deleteDoctor", // Replace with your controller's endpoint
            data: { "empid":recordId},
            success: function(data) {
                $("#result").text(data);
            },
            error: function() {
                $("#result").text("Error fetching data.");
            }
        });
    });
});

	

</script>

  
</head>
<body>
<table  id="doctorTable">
  <thead>
<tr>
<td>did</td>
<td>dname</td>
<td>Pid</td>
<td>pname</td>
<td>address</td>
<td>edit</td>
<td>delete</td>

</tr>
</thead>

<c:forEach items="${doctordata}" var="doc">


<tbody>
<tr id="tr_${doc.did}">
<td id ="did">${doc.did}</td>
<td>${doc.dname}</td>
<td>${doc.pid}</td>
<td>${doc.pname}</td>
<td>${doc.address}</td>
<td><a href="editemp/${doc.did}">Edit</a></td>  
 <%-- <td><a href="deleteemp/${doc.id}">Delete</a></td> --%>
   <td>
    <button id="deleteid"  data-id="${doc.did}">Delete</button>
    <div id="result"></div>
<!--    <input type="button" value="Delete"  onclick="deleteDoctor()"> -->
   </td>

</tr>
</tbody>
</c:forEach>
</table>
</body>
</html>