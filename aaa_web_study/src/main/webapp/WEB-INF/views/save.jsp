<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/aaa.js"></script>
    <!-- servlet-context -->
</head>
<body>
    <h2>회원가입</h2>
<form action="/member/save" method="post">

    <input type="text" name="memberEmail" placeholder="이메일" id="memeberEmail" onblur="emailCheck()"><br>
    <p id="check_result"></p>
    <input type="text" name="memberPassword" placeholder="비밀번호"><br>
    <input type="text" name="memberName" placeholder="이름"><br>
    <input type="text" name="memberAge" placeholder="나이"><br>
    <input type="text" name="memberMobile" placeholder="전화번호"><br>
    <input type="submit" value="회원가입"><br>
</form>
<script>
    //이메일 입력값을 가져오고
    //입력값을 서벌로 전송하고 똑같은 이메일이 있는지 체크한 후
    //사용 가능 여부를 이메일 입력창 아래에 표시



   const emailCheck = () => {
        const email = document.getElementById("memeberEmail").value;

        var checkResult =  document.getElementById("check_result");
       console.log(email);
        $.ajax({
            type:"post",
            url: "/member/email_check",
            data: {
                "memberEmail" : email,
            },
            success: function(res) {
                if (res == "ok") {
                    console.log("요청성공1", res);
                    checkResult.style.color = "green";
                    checkResult.innerHTML = "사용가능한 이메일";
                } else {
                    console.log("요청성공2", res);
                    checkResult.style.color = "red";
                    checkResult.innerHTML = "사용 불가능한 이메일";
                }
            },
            error: function (err) {
                    console.log("에러발생", err);
                }
            });
    }
</script>
</body>
</html>