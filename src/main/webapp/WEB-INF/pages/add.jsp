<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ include file="/WEB-INF/pages/Head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
   <form method="post" enctype="multipart/form-data">
	      品牌名<input name="name"></br>
	      品牌描述<input name="description"></br>
                 品牌logo <input name="logo" type="file" onchange="change(this)"></br>
           <img id="img" src="" heigth="100" width="100"></br>      
   <input type="submit">
   </form>
   <script type="text/javascript">
   		function change(obj) {
			var reader=new FileReader();
			reader.onload=function(e){
				var img=document.getElementById("img");
				img.src=e.target.result;
			}
			reader.readAsDataURL(obj.files[0]);
		}
   </script>
</body>
</html>