<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%File f = new File("/form");
   String path = f.getName(); 
   File c = new File("js/check.js");
   String pathC = c.getName();
   
   %>
    

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="style.css" />
    
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

    <form action="<%=path %>" method="post" class="form-contents" >
      <h3>名前</h3><input type="text" name="user_name" id="name">
      <h3 id="gender-t">性別</h3><input type="radio" name="gender"  id="gender0" value ="1">
      <p id="gender-m">男性</p><input type="radio" name="gender"  id="gender1" value ="2">
      <p id="gender-f">女性</p>
      <h3 id="form-title">問合内容</h3><textarea name="form_box" id ="form-box" 
      onfocus="if (this.value == 'ここに記入してください') this.value = '';" onblur="if (this.value == '') this.value = 'ここに記入してください';">ここに記入してください</textarea>
      <h3 id="file-title">添付ファイル</h3><input type="file" name="file" id="form-file">
      <input name="btn_submit" value="送信" type="submit" id ="submit_btn">
      
      </form>
<script> 
    function check() {
        if (contact.user_name.value == "") {
            alert("名前を入力してください");
            return false;
          }
          if(contact.gender.value == "") {
            alert("性別を選んでください");
            return false;
          }
          if (contact.form_box.value == "ここに記入してください" || contact.form_box.value == ""){
            alert("問い合わせ内容を入力してください");
            return false;
          }
          return true;
        }

      console.log(document.getElementById("submit_btn"));    
      const button = document.getElementById('submit_btn');
      if(button.onclick) { check();}
      </script>
    

    <footer>
      <p>2021 All Rights Reserved</p>
    </footer>

    
  </body>
</html>

