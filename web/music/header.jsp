<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="music/css/header.css" type="text/css" rel="Stylesheet" />
	<script type="text/javascript">
	

			function singername()
			{
				var textname = document.getElementById("vvv").value;
				var aaa = document.getElementById("aaa");
				aaa.href = "/songfindSong.action?sname="+textname;
				
			};
		
		

	</script>
	<style type="text/css">
		#out{
		
			
			position: absolute;
			margin-top:-30px;
			margin-left:174px;
			border:0px;
		}
	
	</style>
	
  </head>
  <body>
<div id="header">
	<img src="music/images/logo.jpg" class="logo"/>
	<ul class="header_ul">
		<li class="li"><a href="">音乐馆</a></li>
		<li><a href="" class="header_a">我的音乐</a></li>
		
	</ul>
	<div class="header_text">
		
		<input type="text" class="text" id="vvv" name="singerName" value=""/>
		
		<a class="btn" id="aaa" href="JavaScript:;" onclick="singername()"></a>
		
	</div>
	<div class="login">
		<ul>
			<s:if test="#session.username==null">
				<li><a href="music/regist.jsp" class="header_a2">注册</a></li>
				<li><a href="music/login.jsp" class="header_a">登录</a></li>
			</s:if>
			<s:else>
				<li><h3>欢迎用户：<s:property value="#session.username"/> </h3></li>
				<li><a href="" id="out" class="header_a">退出</a></li>

			</s:else>

		</ul>
	</div>	
</div>
<div id="header_song">
	<ul>
		<li><a href="/music/index.jsp" class="header_a">首页</a></li>
		<li><a href="/singerallSinger.action?result=before" class="header_a">歌手</a></li>
		<li><a href="" class="header_a">专辑</a></li>
		<li><a href="" class="header_a">排行榜</a></li>
	</ul>
</div>
  </body>
 
</html>
