<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional///EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			Update Member ${member.name}
		</title>
	</head>
	<body>
		<form:form commandName="member" action="/member/update" method="POST">
			<p>
				<label> Name </label>
				<form:input path="name" size="50" />
				<form:errors path="name" />
				<input type="submit" value="Submit" />
			</p>
		</form:form>
	
	
		<table>
			<thead>
				Inteface
			</thead>
			<tbody>
				<tr>
					<td>
						Update
					</td>
					<td>
						<a href='/member/update/${member.id }'>
							<button type='button'>
								Go
							</button>
						</a>
					</td>
				</tr>
				<tr>
					<td>
						to Main
					</td>
					<td>
						<a href='/'>
							<button type='button'>
								Go
							</button>
						</a>
					</td>
				</tr>
				<tr>
					<td> 
						to List
					</td>
					<td>
						<a href='/member/list'>
							<button type='button'>
								Go
							</button>
						</a>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>