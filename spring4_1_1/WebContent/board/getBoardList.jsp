<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 구현 - WebContent</title>
<jsp:include page="../common/commonUIglobal.jsp" flush="false" />
<script>
  function search() {
    console.log("조회 호출");
    $('#dg_board').datagrid({
      url:'jsonGetBoardList.sp4',
      /* toolbar : '#tb_board2' */
    });
  }
  function insert() {
	  console.log("입력창 호출");
	  $('#dlg_ins').dialog('open');
  }
  /* 입력 모달창에서 register 버튼 클릭  눌렀을 때*/
  function register() {
	  console.log("register 버튼 클릭!!");
  }
  
</script>

</head>
<body>
	<br/>
	<div id="tb_board2" style="padding:2px 5px;">
        <a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search" plain="true">조회</a>
        <a href="javascript:insert()" class="easyui-linkbutton" iconCls="icon-add" plain="true">입력</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">수정</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">삭제</a>
  </div>
	<table id="dg_board" class="easyui-datagrid" data-options= "title:'게시판', singleSelect:true, toolbar:'#tb_board2'" width="768px">
		<thead>
			<tr>
				<th data-options="field:'BM_NO'">번호</th>
				<th data-options="field:'BM_TITLE'">제목</th>
				<th data-options="field:'BS_FILE'">작성자</th>
				<th data-options="field:'BM_HIT'">조회수</th>
				<th data-options="field:'BM_DATE'">날짜</th>
			</tr>
		</thead>
		<tbody>
			
			<tr>
			</tr>
			
		</tbody>
	</table>
	<!-- ---------------------------[글 쓰기 화면 시작]--------------------------- -->
	<div id="dlg_ins" class="easyui-dialog" title="글쓰기" data-options="iconCls:'icon-save', closed:'false'" style="width:500px;height:500px;padding:10px">
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" label="번호:" labelPosition="top" data-options="prompt:'번호를 입력하세요.....',validType:'email'" style="width:100%;">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" label="제목:" labelPosition="top" style="width:100%;">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" label="작성자:" labelPosition="top" style="width:100%;">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" label="조회 수:" labelPosition="top" style="width:100%;">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" label="날짜:" labelPosition="top" style="width:100%;">
        </div>
        
        <div>
            <a href="javascript:register()" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">Register</a>
        </div>
    </div>
</body>
</html>