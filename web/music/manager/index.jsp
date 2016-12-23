<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="music/manager/css/style.css" />
	<link href="music/css/header.css" type="text/css" rel="Stylesheet" />
	<script type="text/javascript" src="music/manager/js/jquery-1.6.min.js"></script>
	<script type="text/javascript" src="music/manager/js/index.js"></script>
	<style type="text/css">

		.table_list{
		border-collapse:collapse;
		}
		.table_list td{
		width:200px;
		text-align:center;
		border:1px solid #d8d8d8;
		padding:5px 0;
		}
		.table_list th{
		border:1px solid #d8d8d8;
		padding:5px 0;
		}
		.table_list a{
		color:#ffb300;
		text-decoration: none;
		}
		#aaa{
			margin-top:50px;
			padding-left:400px;
		
		}
		.table_list input{
			border: 0;
			background: white;
			
			}
			.table_user{
				margin-left:-100px;
				border-collapse:collapse;
			
			}
			.table_user th{
		border:1px solid #d8d8d8;
		padding:5px 0;
		}
			.table_user td{
		width:200px;
		text-align:center;
		border:1px solid #d8d8d8;
		padding:5px 0;
		}
				
	
	</style>
	<script type="text/javascript" src="music/js/jquery.min.js"></script>
<script>
$(function(){
var a=1;
 $(".change").click(function(){
	if(a==1){
	$(this).html("保存");
    $(this).parent().siblings().children().removeAttr("disabled");
	$(this).parent().siblings().children().css("border","1px solid #bdbdbd");
	a=3;
	}else{
	$(this).html("修改");
    $(this).parent().siblings().children().attr("disabled",true);
	$(this).parent().siblings().children().css("border","0");
	a=1;
	}
  });
});
</script>


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

<div class="nav-down">
	
	<div class="leftmenu1">
       
    	<ul>
        	<li>
            	<a class="a_list a_list1">歌曲管理</a>
                <div class="menu_list menu_list_first">
                	<a href="">添加歌曲</a>
                    <a href="">查看歌曲</a>
                </div>
            </li>
            <li>
            	<a class="a_list a_list2">歌手管理</a>
                <div class="menu_list">
                	<a href="">添加歌手</a>
                    <a href="/singerallSinger.action?result=after">查看歌手</a>
                </div>
            </li>
             <li>
            	<a class="a_list a_list3">专辑管理</a>
                <div class="menu_list">
                	<a href="">添加专辑</a>
                    <a href="">查看专辑</a>
                </div>
            </li>
            <li>
            	<a class="a_list a_list3">用户管理</a>
                <div class="menu_list">
                	
                    <a href="/userfindAll.action">查看用户</a>
                </div>
            </li>
        
        </ul>
    </div>
	
  
</div>
	<div id="aaa">
	<table class="table_list">
		    <%--<c:forEach items="${allSong }" begin="1" end="1">
		 	<tr>
				<th>歌曲</th>
				<th>歌手</th>
				<th>专辑</th>
				<th>操作</th>	
			</tr>
			</c:forEach>--%>
	<%--		<c:forEach items="${allSong }" var="as">
		
			<tr>
				<td><input type="text" name="input1" value="${as.songname }" disabled="true" class="q"/></td>
				<td><input type="text" name="input1" value="${as.singername }" disabled="true" /></td>
				<td><input type="text" name="input1" value="${as.album }" disabled="true" /></td>
				<td><a href="<c:url value='/SongServlet?method=delSong&songname=${as.songname }'/>">删除</a>|
				<a href="<c:url value='/music/manager/modify_song.jsp?songname=${as.songname }&singername=${as.singername }&albumname=${as.album }&songid=${as.songid }'/>">修改</a></td>	
			</tr>
			</c:forEach>
		  </table>
	
	<table class="table_list">
		<c:forEach items="${allsinger }" begin="1" end="1">
			<tr>
				<th>歌手</th>
				<th>性别</th>
				<th>歌手热度</th>
				<th>操作</th>	
			</tr>
			</c:forEach>
		<c:forEach items="${allsinger }" var="als">

		<tr>
			<td>${als.singername }</td>
			<td>${als.sex }</td>
			<td>${als.singerattention }</td>
			<td><a href="<c:url value='/SingerServlet?method=delSinger&singername=${als.singername }'/>">删除</a>|
				<a href="<c:url value='/music/manager/modify_singer.jsp?singername=${als.singername }&sex=${als.sex }&singerattention=${als.singerattention }&singerid=${als.singerid }'/>">修改</a>
			</td>
			
		</tr>
		</c:forEach>
	
	</table>
	
	<table class="table_list">
		<c:forEach  items="${allalbum }" begin="1" end="1">
			<tr>
				<th>专辑</th>
				<th>歌手</th>
				<th>操作</th>	
			</tr>
			</c:forEach>
			<c:forEach items="${allalbum }" var="aa">
				<tr>
					<td>${aa.albumname }</td>
					<td>${aa.singername }</td>
					<td><a href="<c:url value='/AlbumServlet?method=delAlbum&albumname=${aa.albumname }'/>">删除</a>|
						<a href="<c:url value='/music/manager/modify_album.jsp?albumname=${aa.albumname }&singername=${aa.singername }'/>">修改</a></td>
				
				</tr>
			</c:forEach>
	
	</table>
	
	<table class="table_user">
		<c:forEach  items="${allUser }" begin="0" end="0">
			<tr>
				<th>用户名</th>
				<th>密码</th>
				<th>性别</th>	
				<th>邮箱</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</c:forEach>
		<c:forEach items="${allUser }" var="au">
			<tr>
				<td>${au.username }</td>
				<td>${au.password }</td>
				<td>${au.sex }</td>
				<td>${au.email }</td>
				<c:choose>
					<c:when test="${au.state }"><td>已激活</td></c:when>
					<c:otherwise><td>未激活</td></c:otherwise>
				
				</c:choose>
				<td><a href="<c:url value='/UserServlet?method=delUser&username=${au.username }'/>">删除</a>
				
				</td>
			
			</tr>
		
		</c:forEach>--%>



				<table class="table_list">
					<s:if test="singerList">
					<tr>
						<th>歌手</th>
						<th>性别</th>
						<th>简介</th>
						<th>操作</th>
					</tr>
					</s:if>
					<s:iterator value="singerList" var="singer">
						<tr>
							<td><s:property value="#singer.singername"/></td>
							<td><s:property value="#singer.sex"/></td>
							<td><s:property value="#singer.singerinfo"/></td>
							<td><a href="#">删除</a>|
								<a href="#">修改</a>
							</td>

						</tr>


					</s:iterator>
				</table>

				<table class="table_user">
					<s:if test="userList">
						<tr>
							<th>用户名</th>
							<th>密码</th>
							<th>性别</th>
							<th>邮箱</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</s:if>


					<s:iterator value="userList" var="user">

						<tr>
							<td><s:property value="#user.username"/></td>
							<td><s:property value="#user.password"/></td>
							<td><s:property value="#user.sex"/></td>
							<td><s:property value="#user.email"/></td>
							<s:if test="#user.state">
								<td>已激活</td>
							</s:if>
							<s:else>
								<td>未激活</td>
							</s:else>

							<td>
								<a id="delUser" href="userdelUser.action?uid=<s:property value="#user.userid"/>" onclick="if(confirm('是否删除？')==false)return false">删除</a>

							</td>

						</tr>

					</s:iterator>
	
	</table>
	</div>
  </body>


</html>
