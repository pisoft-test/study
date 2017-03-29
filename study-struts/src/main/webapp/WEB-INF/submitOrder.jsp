<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>订单信息</h1>
		<form id="message" action="submitOrder" method="post">
			<label> 发件人姓名： </label> <input type="text" name="sender.name" value=""><br/>
			<label> 发件人电话： </label> <input type="text" name="sender.phone" value=""><br/>
			<label> 收件人电话： </label> <input type="text" name="receiver.phone" value=""><br/>
			<input type="submit" value="提交" id="submit">
		</form>
	</div>
</body>
</html>