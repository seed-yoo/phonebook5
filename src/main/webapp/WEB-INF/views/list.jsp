<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>

	<h1>전화번호부</h1>

	<h2>리스트</h2>

	<p>등록된 전화번호 리스트 입니다.</p>
	<br>

		<c:forEach items="${ requestScope.pList }" var="personVo" varStatus="status">
			<table border="1">
				<tr>
					<td>이름(name)</td>
					<td>${ personVo.name }</td>
				</tr>
				<tr>
					<td>핸드폰(hp)</td>
					<td>${ personVo.hp }</td>
				</tr>
				<tr>
					<td>회사(company)</td>
					<td>${ personVo.company }</td>
				</tr>
				<tr>
					<td>${ personVo.personId } 
					<a href="/phonebook5/phone/delete?no=${ personVo.personId }">[삭제]</a>
					</td>
					<td>${ personVo.personId } 
					<a href="/phonebook5/phone/modifyform2?no=${ personVo.personId }&name=${ personVo.name }&hp=${ personVo.hp }&company=${ personVo.company }">
							[수정]</a></td>
				</tr>
			</table>
		
		</c:forEach>
		
		
	<br>
	
	
	<a href="/phonebook5/phone/writeform">추가번호 등록</a>

</body>
</html>