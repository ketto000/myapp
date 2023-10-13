<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <h2>로그인페이지</h2>

    <form action="/member/login" method="post" enctype="multipart/form-data">
        <input type="text" name="memberEmail" placeholder="email">
        <input type="text" name="memberPassword" placeholder="password">
        <input type="submit" value="로그인">
    </form>
</body>
</html>