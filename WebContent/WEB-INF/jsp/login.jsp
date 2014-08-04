<html>
<head>
	<title>Spring 3.0 MVC</title>
	<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
	<meta charset="utf-8">
</head>
<body>
	    ${message}
	<form action="${pageContext.request.contextPath}/login.do" method="POST">
		Name: <input type="text" name="name" /><br /> 
		Age: <input type="text" name="age" /><br />
		<input type="button" name="btnOK" value="Hi" onclick="this.form.submit();"/>
	</form>
</body>
</html>