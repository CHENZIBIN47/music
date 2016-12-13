<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>MyMusic注册</title>
	<link href="music/css/header.css" type="text/css" rel="Stylesheet" />
	<link href="music/css/regist.css" type="text/css" rel="Stylesheet" />

</head>
<body>

<div id="registered">
	<form id="formid"  name= "myform" method = 'post'  action = '/userdoRegist.action' onsubmit = "return checkUser();" >
		<table  width="100%" border="0">
			<tr>
				<td align="right">用户名:</td>
				<td colspan="2"><input type="text" class="username" name="user.username"/></td>
				<td>&nbsp </td>
			</tr>
			<tr>
				<td align="right">密码:</td>
				<td colspan="2"><input type="password" class="password" value="" name="user.password"/></td>
				<td class="tis">&nbsp </td>
			</tr>
			<tr>
				<td align="right">确认密码:</td>
				<td colspan="2"><input type="password" class="repassword" value="" name="user.repassword"/></td>
				<td class="mtis">&nbsp </td>
			</tr>
			<tr>
				<td align="right">性别:</td>
				<td colspan="2" class="sex">
					<input type="radio" name="user.sex" value="男" /><div class="man"></div>
					<input type="radio" name="user.sex" value="女" /><div class="girl"></div>
				</td>
				<td class="tis">&nbsp </td>
			</tr>
			<tr>
				<td align="right">邮箱:</td>
				<td colspan="2"><input type="text" name="user.email" id="emailEle" class="username" value=""/></td>
				<%--<td style="color:red"><p id="errorEmail"></p></td>--%>
			</tr>
			<tr>
				<td align="right">出生日期:</td>
				<td colspan="2" class="sex">
					<select name="YYYY" id="yy">
						<option value="" class="data">请选择 年</option>
					</select>
					<select name="MM" id="mm">
						<option value="" class="data">选择 月</option>
					</select>
					<select name="DD" id="dd">
						<option value="" class="data">选择 日</option>
					</select>
				</td>
				<td class="tis">&nbsp </td>
			</tr>
			<tr>
				<td align="right">验证码:</td>
				<td><input type="text" class="vft"/></td>
				<td><img width="110px" src="images/verCode.png"/></td>
				<td class="tis">&nbsp </td>
			</tr>
			<tr>
				<td>&nbsp </td>
				<td colspan="2"> <input type="submit" value="注册" class="btn2"  /></td>
				<td class="tis">&nbsp </td>
			</tr>
		</table>
	</form>
</div>
<div id="footer">
	<div>本网站属于私人定制网站----由cy、czb、ltj、lzc制作而成</div>
</div>
<script type="text/javascript" src="music/js/jquery.min.js"></script>
<script type="text/javascript" src="music/js/header.js"></script>
<script type="text/javascript" src="music/js/regist.js"></script>


</body>
</html>