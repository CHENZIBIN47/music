<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<title>MyMusic添加歌曲</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link href="music/css/header.css" type="text/css" rel="Stylesheet" />
<link href="music/css/login.css" type="text/css" rel="Stylesheet" />
<style>

	#textid{
		width:400px;
		height:30px;
		
	
	
	}
	#songs{
		text-align:right;
		padding-right:20px;
	
	}

	td{
	padding-top:20px;
	
	}
	#addsong table{
		width:800px;
		margin: 0 auto;
	}
	#sub{
		width:100px;
		height:30px;
		background:green;
		
		
	
	}
	#subid{
		padding-left:100px;
	}
	
	
</style>

  </head>
  
  <body>
<div id="header">
	<img src="music/images/logo.jpg" class="logo"/>
	<ul class="header_ul">
		<li class="li"><a href="javascript:;">音乐馆</a></li>
		<li><a href="javascript:;" class="header_a">我的音乐</a></li>
		
	</ul>
	<div class="header_text">
		<input type="text" class="text" value=""/>
		<input type="button" class="btn">
	</div>
	<div class="login">
		<ul>
			<li><span>您好：</span></li>
			<li><a href="" class="header_a">注销</a></li>
		</ul>
	</div>	
</div>


<div id="addsong">
	<form id="formid"  name= "myform" method = 'post'  action ="<s:url value="/songadd.action"/>" onsubmit = "return checkUser();" >
		<table  width="100%" border="0">
			<tr>
				<td id="songs">歌名</td>
				<td><input type="text" id="textid" name="song.songname"></td>
							
			</tr>
		
			<tr>
				<td id="songs">歌手</td>
				<td><input type="text" id="textid" name="song.singername"></td>
				<td><p style="color:red"></p></td>
			</tr>
			
			<tr>
				<td id="songs">路径</td>
				<td><input type="text" id="textid" name="song.path"></td>
			</tr>
			
			<tr>
				<td id="songs">所属专辑</td>
				<td><input type="text" id="textid" name="song.album"></td>
			</tr>
			
			<tr>
				<td id="songs">类型</td>
				<td><input type="text" id="textid" name="song.songtype"></td>
			</tr>
		
			<tr>
				<td id="songs">热度</td>
				<td><input type="text" id="textid" name="song.heat"></td>
			</tr>
		
			<tr>
				<td></td>
				<td id="subid"><input type="submit" value="提交" id="sub"></td>
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
