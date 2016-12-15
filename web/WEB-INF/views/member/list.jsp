<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Sample Member List</title>
	</head>
	<body>
		<a href="<c:url value='/member/form'/>">Add</a>
		<h2>Member List</h2>
		<ul>
			<c:forEach items="${list}" var="member">
				<li>
					<a href="/member/${member.id}">
						${member.name}
					</a>
				</li>
			</c:forEach>
		</ul>
		<table>
			<thead>
				Interface
			</thead>
			<tbody>
				<tr>
					<td>
						To Main
					</td>
					<td>
						<a href='/'>
							<button>
								Go
							</button>
						</a>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>