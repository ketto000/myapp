<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>update</title>
</head>
<body>
  <form id="memberUpdate" action="/member/memberUpdate" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <th>id</th><td><input type="text" value="${member.id}" name="id" /></td>
        </tr>
        <tr>
            <th>email</th><td><input type="text" value="${member.memberEmail}" name="memberEmail" /></td>
        </tr>
        <tr>
            <th>password</th><td><input type="text" value="${member.memberPassword}" name="memberPassword" /></td>
        </tr>
        <tr>
            <th>name</th><td><input type="text" value="${member.memberName}" name="memberName" /></td>
        </tr>
        <tr>
            <th>age</th><td><input type="text" value="${member.memberAge}" name="memberAge"  /></td>
        </tr>
        <tr>
            <th>mobile</th><td><input type="text" value="${member.memberMobile}" name="memberMobile" /></td>
        </tr>
        <tr>
            <td rowspan="2">
                <input type="button" id="submit_btn" value="전송" onclick="updateMember();"/>
                <input type="button" id="delete_btn" value="삭제" onclick="deleteMember('${member.id}')" />
            </td>
        </tr>
    </table>
  </form>

<%--        <tr>--%>
<%--            <th></th> <td><a href="/member?id=${member.id}">수정</a></td>--%>
<%--        </tr>--%>
<%--            <th>삭제</th>  <td><button onclick="deleteMember('${member.id}')">삭제</button></td>--%>
<%--        </tr>--%>


<script>
    const updateMember = () =>{
        document.getElementById('memberUpdate').submit();
    }


    const deleteMember = (id) => {
        console.log(id);
        location.href="/member/delete?=id"+id;
    }
</script>

</body>
</html>