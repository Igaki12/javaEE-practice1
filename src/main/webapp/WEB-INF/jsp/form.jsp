<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
        <ul class="nav-list">
          <li class="nav-list-item">
            <a href="top.jsp">トップ</a>
          </li>
          <li class="nav-list-item">ナビ2</li>
          <li class="nav-list-item">ナビ3</li>
          <li class="nav-list-item">
            <a href="profile.jsp">自己紹介</a></li>
            <li class="nav-list-item">
              <a href="form.jsp">お問い合わせ</a></li>
        </ul>
      </nav>
    </header>

    <form action="/Web_project2/InquiriesServlet" method="post" class="form-contents" enctype="multipart/form-data" >
      <h3>名前</h3><input type="text" name="user_name" id="name">
      <h3 id="gender-t">性別</h3><input type="radio" name="gender"  id="gender0" value ="0">
      <p id="gender-m">男性</p><input type="radio" name="gender"  id="gender1" value ="1">
      <p id="gender-f">女性</p>
      <h3 id="form-title">問合内容</h3><textarea name="form_box" id="form-box">ここに記入してください</textarea>
      <h3 id="file-title">添付ファイル</h3><input type="file" name="file" id="form-file">
      <input name="btn_submit" value="送信" type="submit" id ="submit-btn">
    </form>

    <footer>
      <p>2021 All Rights Reserved</p>
    </footer>


  </body>
</html>

