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
		var tv = new Object();
		tv.color = "black";
		tv.price = 300000;
		tv.info = function () {
			document.write("색상 : "+ tv.color +  "<br>");
			document.write("가격 : "+ tv.price +  "<br>");
		}
		tv.info();
		const today = new Date();
		const mon = today.getMonth(); // 월
		const date = today.getDate(); // 일
		const day = today.getDay(); // 요일
		const hours = today.getHours(); // 시
		const minutes = today.getMinutes(); // 분
		const seconds = today.getSeconds(); // 초
		
		document.write("오늘 날짜 : " + today + "<br>");
		document.write("월: " + mon + "<br>");
		document.write("일 : " + date + "<br>");
		switch (day) {
		case 0:
			document.write("일요일 "+ "<br>");
			break;
		case 1:
			document.write("월요일 "+ "<br>");
			break;
		case 2:
			document.write("화요일 "+ "<br>");
			break;
		case 3:
			document.write("수요일 "+ "<br>");
			break;
		case 4:
			document.write("목요일 "+ "<br>");
			break;
		case 5:
			document.write("금요일 "+ "<br>");
			break;
		case 6:
			document.write("토요일 "+ "<br>");
			break;
		case 7:
			document.write("일요일 "+ "<br>");
			break;

		default:
			break;
		}
		if (hours > 12) {
			if (hours == 12) {
				document.write("시 : " + "오후 "+hours +" 시" + "<br>");
			}
			/* hours = hours - 12; */
			document.write("오후 "+hours +" 시" + "<br>");	
		} else {
			document.write("오전"+hours +" 시"+ "<br>");
		}
		
		/* document.write("분 : " + minutes + "<br>"); */
		document.write("초 : " + seconds + "<br>");
			
	</script>
</body>
</html>