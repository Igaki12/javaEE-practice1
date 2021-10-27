<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Human" %>
<%

request.setCharacterEncoding("UTF-8");
Human h = (Human)request.getAttribute("human");
String name = request.getParameter("user_name");
String gender = request.getParameter("gender");
String box = request.getParameter("form_box");

%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="style.css" />
    <script type="text/javascript" src="check.js"></script>
    <title>MySite</title>
  </head>

  <body>
    <header>
        <p class="title"> お問い合わせ
        </p>
      <nav>
        <ul>
          <li>
            <a href="top">トップ</a>
          </li>
          <li>ナビ2</li>
          <li>ナビ3</li>
          <li>
            <a href="profile">自己紹介</a></li>
            <li>
              <a href="form">お問い合わせ</a></li>
        </ul>
      </nav>
    </header>
    
    <p> <br>名前：<%=h.getName() %>、性別：<%=h.getGender() %>、内容：<%=h.getBox() %>で登録しました。<br></p>

    <footer>
      <p>2021 All Rights Reserved</p>
    </footer>


  </body>
</html>