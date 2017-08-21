<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- Ajax -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<form>
<label>UserId</label>
	<input type="text" id="userId" value="${userId }"/>
	<input type="button" id="btn" value="none" />
</form>

<script>
	$(function(){
		$("#btn").click(function(){
			
			$.ajax({
				type:'post',
				url:"test.do",
				
				success: function(data){
					alert(data);
				}
			});
		});
	});

	$(function(){
		$("#userId").autocomplete({
			source: function(request,response){
				$.ajax({
					type:'post',
					url:"getUserId.do",
					dataType:"json",
					data:{value:request.term},
				success:function(data){
						response(
								$.map(data,function(item){
									return{
										value:item.userId,
										label: item.userId
									}
								})
								)
					}
				});
			},
			minLength:2
		});
	});
	
</script>

</body>
</html>