<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <h2>로그인성공</h2>

    <h2>${sessionScope.loginEmail} 님 환영합니다.</h2>

    <a href="/member/">회원목록  조회</a>
    <input type="button" value="내정보 수정하기" onclick="update()">
    <input type="button" value="로그아웃" onclick="logout()">

</body>
    <script>
        const update = () =>{
            location.href="/member/update";
        }
        const logout = () =>{
            location.href="/member/logout";
        }
    </script>



</html>