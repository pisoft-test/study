<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Test Getter</h2>
	<table>
		<tr>
			<th>省</th>
			<th>市</th>
			<th>区</th>
		</tr>

		<s:iterator value="currentActionParam" var="address">
			<td>${address.province }</td>

		</s:iterator>
	</table>
</body>
</html>