<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查询</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function() {

		//给修改按钮绑定事件
		$("#update").click(function() {
			var ids = $("input[id=ids]:checked");
			if (ids.length == 1) {
				//提交表单
				var f1 = $("#f1");
				f1.attr("action", "user/loadupdate.do");
				f1.submit();

			} else {
				alert("必须选自一个（只能有一个）进行修改");
			}
		});

		//给删除按钮绑定事件
		$("#delete").click(function() {
			if (confirm("您确定要删除用户吗")) {
				//提交表单
				var f1 = $("#f1");
				f1.attr("action","user/delete.do");
				f1.submit();
			}

		});

	});

	//checkboxfun 实现全选货全不选
	function checkboxfun(v) {
		//alert(v.checked);
		var ids = $("input[id=ids]");
		//遍历所有的checkbox
		ids.each(function(i) {
			//设置checked的值
			this.checked = v.checked;
		});
	}
</script>

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>查询用户</li>
		</ul>
	</div>
	<form action="user/find.do" method="post" id="f1" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>用户姓名</label> <input type="text" class="form-control"
					name="userName" placeholder="请输入用户姓名" />
			</div>
			<input type="submit" value="查询用户" class="btn btn-success" /> <a
				href="user/loadadd.do" class="btn btn-info">添加用户</a> <input
				type="button" id="update" value="修改用户" class="btn btn-primary" /> <input
				type="button" id="delete" value="删除用户" class="btn btn-danger" />
		</div>
		<div class="alert alert-warning alert-dismissible"
			style="display: ${errorinfo==null?'none':'block' };" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<div align="center" style="color: red;">${errorinfo }</div>
		</div>
		<div class="row" style="padding: 15px;">
			<table class="table ">
				<tr>
					<th><input type="checkbox" onclick="checkboxfun(this)" /></th>
					<th>编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>账号</th>
					<th>薪资</th>
					<th>角色</th>
					<th>查看</th>

				</tr>
				
				<c:forEach items="${users}" var="user">
					<tr>
					<td>
					<input type="checkbox" id="ids" name="userId" value="${user.userId}">
					</td>
						<td>${user.userId}</td>
						<td>${user.userName}</td>
						<td>${user.userSex}</td>
						<td>${user.userAge}</td>
						<td>${user.userAccount}</td>
						<td>${user.userSalary}</td>
						<td>${user.roleId}</td>
						<td>${user.userMark}</td>
					
					</tr>
				
				</c:forEach>

			</table>

		</div>
	</form>
</body>
</html>