<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	StringBuilder path = new StringBuilder(request.getContextPath());
	path.append("/");
	// 이전 화면[read.jsp]에서 값을 받아오기
	String bm_no = request.getParameter("bm_no");
	String bm_group = request.getParameter("bm_group");
	String bm_pos = request.getParameter("bm_pos");
	String bm_step = request.getParameter("bm_step");
	String bm_writer = request.getParameter("bm_writer");
	String bm_content = request.getParameter("bm_content");
	String bm_title = request.getParameter("bm_title");
	out.print(bm_no+" , "+ bm_group+" , "+ bm_pos+" , "+ bm_step+" , "+bm_writer+" , "+bm_content);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=path.toString()%>themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path.toString()%>themes/icon.css">
<!-- jEasyUI JS 시작 -->
<script type="text/javascript" src="<%=path.toString()%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path.toString()%>js/jquery.easyui.min.js"></script>

</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#ubm_title").textbox('setValue', '<%=bm_title%>');
			$("#ubm_writer").textbox('setValue', '<%=bm_writer%>');
			$("#ubm_content").textbox('setValue', '<%=bm_content%>');
		});
	</script>
	<!--================== [[글 수정 화면]] ==================-->
	<form id="board_upd" method="post" action="boardUpdate.sp4">
    	<input type="hidden" name="bm_no" value="<%=bm_no%>">
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" id="ubm_title" name="bm_title" label="제목:" labelPosition="top" data-options="prompt:'제목'" style="width:400px;">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" id="ubm_writer" name="bm_writer" label="작성자:" labelPosition="top" data-options="prompt:'작성자'" style="width:250px;">
        </div>        
        <div style="margin-bottom:20px">
            <input class="easyui-textbox"  id="ubm_content" name="bm_content" label="내용:" labelPosition="top" data-options="prompt:'내용',multiline:true, width:500, height:120">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" id="ubm_email" name="bm_email" label="Email:" labelPosition="top" data-options="prompt:'Enter a email address...'" style="width:100%;">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox"  id="ubm_pw" name="bm_pw" label="비밀번호:" labelPosition="top" style="width:200;">
        </div>
    	</form> 
	<!-- 입력 화면 버튼 추가 -->
	<div id="ft_upd" align="right">
		<a href="javascript:updAction()" class="easyui-linkbutton" iconCls="icon-save">수정</a>
		<a href="javascript:$('#dlg_boardupd').dialog('close');" class="easyui-linkbutton" iconCls="icon-cancel">닫기</a>
	</div>
	<!-- 댓글쓰기  끝  -->
</body>
</html>