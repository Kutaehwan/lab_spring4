<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/commonUIglobal.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JavaScript 실습</title>
  <script type="text/javascript">
  	function test() {
  		let age = prompt('당신의 나이는? ', 0);
  	  	alert('당신이 입력한 나이는 : ' + age);
  	    if (age >= 20) {
  	      document.write("당신은 성인입니다.");
  	    } else {
  	      document.write("당신은 미성년자입니다.");
  	    }
  	}
  </script>
</head>
<body>
하나 <br>
	<script type="text/javascript">test();</script>
<br>
둘
</body>
</html>