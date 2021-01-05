<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <%@include file="/common/common_lib.jsp"%>
    <%-- common_lib.jsp의 내용을 지금 기술되는 부분에 코드를 복사해서 붙여 넣기 --%>
    

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">
    
  </head>

  <body>

    <div class="container">
      <form class="form-signin" action="<%=request.getContextPath() %>/loginController" method="POST">
        <h2 class="form-signin-heading">로그인 페이지</h2>
        <label for="user_id" class="sr-only">user_id</label>
        <input type="text" id="user_id" name="userid" value="brown" class="form-control" placeholder="아이디를 입력하세요" required autofocus><br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="pass" value="brownpass" class="form-control" placeholder="비밀번호를 입력하세요" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> ID 저장하기
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
      </form>
      
    </div> <!-- /container -->
  </body>
</html>
