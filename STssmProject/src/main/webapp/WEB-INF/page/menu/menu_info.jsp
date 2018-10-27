<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
	var info='${info}';
	
	if(info.length>0){
		alert(info)
	}
	window.parent.location="list.do";

</script>
</body>
</html>