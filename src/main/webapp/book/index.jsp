<%@page import="vn.aptech.entity.Category"%>
<%@page import="vn.aptech.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
	<form action="Controller" method="get">
		<input type="hidden" name="a" value="BookFilter"/>
		Category: <select name="category">
			<option value="0">Choose</option>
			<%
			if (request.getAttribute("categories") != null) {
				List<Category> cates = (List<Category>)request.getAttribute("categories");
				for(Category c : cates) {
			%>
			<option value="<%= c.getId() %>"><%= c.getName() %></option>
			<% 
				}
			}
			%>
		</select>
		<input type="submit" value="Filter"/>
	</form>
	<h1>Book List</h1>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Price</th>
				<th>Category</th>
			</tr>
		</thead>
		<tbody>
		<%
		if (request.getAttribute("books") != null) {
			List<Book> books = (List<Book>)request.getAttribute("books");
			for(Book b : books) {
		%>
			<tr>
				<td><%= b.getId() %></td>
				<td><%= b.getTitle() %></td>
				<td><%= b.getPrice() %></td>
				<td><%= b.getCategory().getName() %></td>
			</tr>
		<%
			}
		}
		%>
		</tbody>
	</table>
</body>
</html>