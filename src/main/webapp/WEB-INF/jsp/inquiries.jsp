<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Human" import="model.Output" import="java.util.*"
import="java.io.*" %>
<%
request.setCharacterEncoding("UTF-8");

File f = new File("/inquiries");
String path = f.getPath();
%>
<% List<Output> output_list = (List<Output>)request.getAttribute("output_list"); %>

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
    
<%
if((Human)request.getAttribute("human") != null) {

Human h = (Human)request.getAttribute("human");
String name = request.getParameter("user_name");
String gender = request.getParameter("gender");
String box = request.getParameter("form_box");
%>
    
    <p> <br>名前：<%=h.getName() %>、性別：<%=h.getGender() %>、内容：<%=h.getBox() %>で登録しました。<br></p>
    
<%} %>

    
    
    <br><h3>履歴</h3><br>
    <% for (Output output : output_list) {
    	String id = output.getId();
    	String gender = "性別不明";
    	if (output.getGender().equals("1")){
    		gender = "男性";
    	}
    	if (output.getGender().equals("2")){
    		gender = "女性";
    	}
    	%>
    <p><%=output.getId() %>名前：<%=output.getName() %>  性別：<%=gender %> <br>内容：<%=output.getContents() %></p>
    <input type="button" value="削除" name="delete-btn" onclick="location.href='<%=path %>?action=delete&object=<%=output.getId() %>'">
    <input type="button" value="更新" name="update-btn" onclick="location.href='<%=path %>?action=update&object=<%=output.getId() %>'">
    <br>
    
    <%if(request.getParameter("id") != null && request.getParameter("id").equals(id)){%>
    <p>更新されました！</p>
    <%} %>
    

<%} %>
    <footer>
      <p>2021 All Rights Reserved</p>
    </footer>


  </body>
</html>