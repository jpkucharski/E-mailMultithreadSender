<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration_Page</title>
<style type="text/css">
table {
	border: 1px solid black;
	/* 	border-collapse: collapse; */
}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

</head>
<body>
	<div>
		<br>
		<form action="AdministrationServlet" method="get">
			<table>
				<tr>
					<th>Message box:</th>
				</tr>
				<tr>
					<td>Subject:</td>
					<td><input type="text" name="subject" size="70"></td>
				</tr>
				<tr>
					<td>Message text:</td>
					<td><textarea rows="10" cols="50" name="emailText"></textarea>
					</td>
				</tr>
			</table>
			<br>
			<br>
			<table>
				<tr>
					<th>Choice the parameters for target customers:</th>
				</tr>
				<tr>
					<th>Interests:</th>
				</tr>
				<tr>
					<td>Engineering</td>
					<td><input type="checkbox" id="Checkbox" value="1"
						name="checkbox1"></td>
				</tr>
				<tr>
					<td>Art</td>
					<td><input type="checkbox" id="Checkbox" value="2"
						name="checkbox2"></td>
				</tr>
				<tr>
					<td>Entertainment</td>
					<td><input type="checkbox" id="Checkbox" value="3"
						name="checkbox3"></td>
				</tr>
				<tr>
					<td>Literature</td>
					<td><input type="checkbox" id="Checkbox" value="4"
						name="checkbox4"></td>
				</tr>
				<tr>
					<th>Age of target group:</th>
				</tr>
				<tr>
					<td>Age:</td>
					<td><select name="age">
							<option value="">-</option>
							<option value="age16to20">16-20</option>
							<option value="age21to25">21-25</option>
							<option value="age26to30">26-30</option>
							<option value="age31to35">31-35</option>
							<option value="age36to40">36-40</option>
							<option value="age41to45">41-45</option>
							<option value="age46to50">46-50</option>
							<option value="age51to55">51-55</option>
							<option value="age56to60">56-60</option>
					</select></td>
				</tr>

			</table>
			<br>
			<br>
			<input id='submit' type="submit" value="Send"> <br>
			<br>
		</form>
	</div>
</body>
</html>