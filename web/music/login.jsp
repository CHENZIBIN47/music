<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="header.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>MyMusic登入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="music/css/header.css" type="text/css" rel="Stylesheet" />
	<link href="music/css/login.css" type="text/css" rel="Stylesheet" />

  </head>
 <body>



<div id="login">
	<form id="formid"  name= "myform" method = 'post'  action = '/userdoLogin.action' onsubmit = "" >
		<table  width="100%" border="0">
			<tr>
				<td align="right">用户名:</td>
				<td colspan="2">
					<input type="text" name="username" class="username" value="<s:property value="#request.user.username"/>"/>
				</td>
				<td><p style="color:red"><s:property value="#request.mes"/> </p></td>
			</tr>
			<tr>
				<td align="right">密码:</td>
				<td colspan="2">
					<input type="password" name="password" class="password" value="<s:property value="#request.user.password"/>"/>
				</td>
				<td class="tis" ></td>
			</tr>
		
			<tr>
				<td></td>
				<td colspan="2"> <input type="submit" value="登录" class="btn2"  /></td>
				<td class="tis"></td>
			</tr>
		</table>
</form>
</div>
<div id="footer">
	<div>本网站属于私人定制网站----由cy、czb、ltj、lzc制作而成</div>
</div>
<script type="text/javascript" src="music/js/jquery.min.js"></script>
<script type="text/javascript" src="music/js/header.js"></script>
</body>

</html>
