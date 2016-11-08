<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="4 URL=http://localhost:8080/SpringMVCHibernate/; charset=UTF-8">
<title>Registration Success</title>
</head>
<body>
    <div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Registration Succeeded!</h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>Thank you for registering! Here's the review of your details:</h3>
                </td>
            </tr>
            <tr>
                <td>First name:</td>
                <td>${userForm.firstName}</td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td>${userForm.lastName}</td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td>${userForm.email}</td>
            </tr>
            <tr>
                <td>Country:</td>
                <td>${userForm.country}</td>
            </tr>
            <tr>
                <td>City:</td>
                <td>${userForm.city}</td>
            </tr>
            <tr>
                <td>Birthday:</td>
                <td>${userForm.birthDate}</td>
            </tr>
 
        </table>
    </div>
</body>
</html>
