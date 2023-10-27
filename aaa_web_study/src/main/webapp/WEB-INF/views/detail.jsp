<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>detail</title>
</head>
<body>
    <table>
        <tr>
            <th>id</th> <td>${member.id}</td>
        </tr>
        <tr>
            <th>email</th> <td>${member.memberEmail}</td>
        </tr>
        <tr>
            <th>password</th> <td>${member.memberPassword}</td>
        </tr>
        <tr>
            <th>name</th> <td>${member.memberName}</td>
        </tr>
        <tr>
            <th>age</th>   <td>${member.memberAge}</td>
        </tr>
        <tr>
            <th>mobile</th> <td>${member.memberMobile}</td>
        </tr>
        <tr>
            <th>목록</th> <td><a href="/member/">목록</a></td>
        </tr>
            <th>삭제</th>  <td><button onclick="deleteMember('${member.id}')">삭제</button></td>
        </tr>
    </table>

<script>
    const deleteMember = (id) => {
        console.log(id);
        location.href="/member/delete?=id"+id;
    }
</script>






</body>
</html>