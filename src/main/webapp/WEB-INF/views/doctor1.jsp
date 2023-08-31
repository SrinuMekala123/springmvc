<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctors List</title>
</head>
<body>
<table>
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
<tr>
<td>${doc.did}</td>
<td>${doc.dname}</td>
<td>${doc.pid}</td>
<td>${doc.pname}</td>
<td>${doc.address}</td>
<td><a href="editemp/${doc.id}">Edit</a></td>  
   <td><a href="deleteemp/${doc.id}">Delete</a></td>

</tr>
</tbody>
</c:forEach>
</table>
</body>
</html>