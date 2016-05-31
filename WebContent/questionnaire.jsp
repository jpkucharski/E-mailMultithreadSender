<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Questionnaire</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
 <a style="float: right" href="administration.jsp" >Admin</a> 
	<h2>
		Welcome and fill out our questionnaire :)
		</h1>
		<br>
		<form action="QuestionnaireServlet" method="post">
			<table>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName" size="30"
						required="required"></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName" size="30"
						required="required"></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><input type="email" name="eMail" size="30"
						required="required"></td>
				</tr>

				<tr>
					<td>Age:</td>
					<td><select required name="age">
							<option value="">-</option>
							<option value="16-20">16-20</option>
							<option value="21-25">21-25</option>
							<option value="26-30">26-30</option>
							<option value="31-35">31-35</option>
							<option value="36-40">36-40</option>
							<option value="41-45">41-45</option>
							<option value="46-50">46-50</option>
							<option value="51-55">51-55</option>
							<option value="56-60">56-60</option>
					</select></td>
				</tr>
			</table>
			<br>
			<table style="width: 30%">
				<tr><th>Interests:</th></tr>
				
				
				<tr>
					<td>Engineering</td>
					<td><input type="checkbox" id="Checkbox" value="1" name="checkbox1"></td>
				</tr>
				<tr>
					<td>Art</td>
					<td><input type="checkbox" id="Checkbox" value="2" name="checkbox2"></td>
				</tr>
				<tr>
					<td>Entertainment</td>
					<td><input type="checkbox" id="Checkbox" value="3" name="checkbox3"></td>
				</tr>
				<tr>
					<td>Literature</td>
					<td><input type="checkbox" id="Checkbox" value="4" name="checkbox4"></td>
				</tr>
			</table>
			<br> <input id='submit' type="submit" value="Submit">
		</form>
</body>
</html>