<%@page import="com.istc.bean.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
//以下代码测试能否获取在action中自定义的session，如果该段文字无乱码地正常显示则没有问题
String info="";
if(session.getAttribute("infofromAction2jsp")!=null){
	info=(String)session.getAttribute("infofromAction2jsp");
}
%>

<html>
<head>  
	<style type="text/css">
   		.errorLabel{color: red;}
	</style>
	<script type="text/javascript" src="js/validation-format.js"></script>
	<title>登录</title>
</head>
  
  <body>
	<form id="login" onsubmit="return false;">
		学号:<input type="text" name="id"></input><font color="red"><span id="error_id"></span></font><br/>
	   	密码:<input type="password" name="password" onkeypress="checkCapsLock(event)"/><font color="red"><span id="error_password"></span></font><br/>
		<input type="hidden" name="token" value="<%=session.getAttribute("token")%>">
		<input type="checkbox" name="remember" value="true">下次自动登录
	</form>
  <button onclick="getLoginValidation()">登录</button>
    <div id ="capStatus" style="visibility: hidden"><font color="red">已打开大写锁定</font></div>
<font color="red"><span id="errorMessages"></span></font>
  </body>
</html>