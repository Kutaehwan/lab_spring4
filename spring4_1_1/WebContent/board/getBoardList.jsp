<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%
   StringBuilder path = new StringBuilder(request.getContextPath());
   path.append("/");
   List<Map<String, Object>> boardList = null;
   boardList = (List<Map<String,Object>>)request.getAttribute("boardList");
   int size = 0;
   if(boardList!=null){
      size = boardList.size();
   }
   out.print("size : "+size);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 구현 - [WebContent]</title>
<link rel="stylesheet" type="text/css" href="<%=path.toString() %>themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path.toString() %>themes/icon.css">
<script type="text/javascript" src="<%=path.toString() %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path.toString() %>js/jquery.easyui.min.js"></script>
<script type="text/javascript">
      /* function serchButton(){
         $('#dg_board').datagrid({
             url:'jsonGetBoardList.sp4',
         });
      } */
    function boardSel() {
    	$('#dg_board').datagrid({
    		url : 'jsonGetBoardList.sp4'
    	    , onLoadSuccess : function(){
    	  		alert("조회 호출 성공");
    	    }
    	}); 
    }
	function boardIns() {
		alert("boardIns 호출 성공");
		$('#dlg_ins').dialog('open');
    }
	function boardUpd() {
	  
	}
	function boardDel() {
	  
	}

   $(document).ready(function(){
      $('#dg_board').datagrid({
         columns:[[
            {field:'BM_NO', title:'글번호', width:100, align:'center'},
            {field:'BM_TITLE', title:'제목', width:250, align:'center'},
            {field:'BS_FILE', title:'첨부파일', width:300, align:'center'},
            {field:'BM_HIT', title:'조회수', width:200, align:'center'},
            {field:'BM_DATE', title:'작성일', width:150, align:'center'}
         ]]
     });
     $('#btn_sel').bind('click', function() {
    	alert('조회');
    	boardSel();
     });
     $('#btn_ins').bind('click', function() {
     	alert('입력');
     	boardIns();
     });
     $('#btn_upd').bind('click', function() {
     	alert('수정');
     	boardUpd();
     });
     $('#btn_del').bind('click', function() {
     	alert('삭제');
     	boardDel();
     });
   });

   /* function search() {
      console.log("조회 버튼 호출 성공");
      $('#dg_board').datagrid({
         url : 'jsonGetBoardList.sp4'
      });
   } */
   

   /* function insert() {
      console.log("입력창 호출");
      $('#dlg_ins').dialog('open');
   } */
</script>
</head>

<body>
   <table id="dg_board" class="easyui-datagrid"
      data-options="title:'게시판', toolbar:'#tb_board'"
      style="width: 1000px; height: 350px;">
      <thead>
         <tr>
            <th>글번호</th>
            <th>글제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>날짜</th>
         </tr>
      </thead>
      <tbody>
      <%
      /* 조회결과가 없는거야? */
            if(size==0){
      %>
         <tr>
            <th colspan="5">조회결과가 없습니다.</th>
         </tr>
      <%
            }
      /* 조회결과가 있는데? */
            else{
               for(int i=0;i<size;i++){
                  Map<String, Object> rmap = boardList.get(i);
                  if(i==size) break;
      %>
         <tr>
            <th><%=rmap.get("BM_NO") %></th>
            <th><%=rmap.get("BM_TITLE") %></th>
            <th><%=rmap.get("BS_FILE") %></th>
            <th><%=rmap.get("BM_HIT") %></th>
            <th><%=rmap.get("BM_DATE") %></th>
         </tr>
      <%
               } ////////// end of for
            } /////////////end of else
      %>
      </tbody>
   </table>

   <!-- Button -->
   <div id="tb_board" style="padding: 2px 5px;">
      <!-- <a href="javascript:serchButton()" class="easyui-linkbutton" iconCls="icon-add" plain="true">조회</a> -->
      <a id="btn_sel" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">조회</a> 
      <a id="btn_ins" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">입력</a> 
      <a id="btn_upd" href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true">저장</a>
      <a id="btn_del" href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">삭제</a>
   </div>

   <!---------------------------- 글쓰기 화면 시작  ----------------------------> <!-- closed:'false' -->
   <div id="dlg_ins" class="easyui-dialog" title="글쓰기" data-options="iconCls:'icon-save'"
      style="width: 500px; height: 500px; padding: 10px;">
      <div style="margin-bottom: 20px">
         <input class="easyui-textbox" label="번호:" labelPosition="top"
            data-options="prompt:'번호를 입력하세요',validType:'email'"
            style="width: 100%;">
      </div>
      <div style="margin-bottom: 20px">
         <input class="easyui-textbox" label="제목:" labelPosition="top"   style="width: 100%;">
      </div>
      <div style="margin-bottom: 20px">
         <input class="easyui-textbox" label="작성자:" labelPosition="top" style="width: 100%;">
      </div>
      <div style="margin-bottom: 20px">
         <input class="easyui-textbox" label="조회 수:" labelPosition="top" style="width: 100%;">
      </div>
      <div style="margin-bottom: 20px">
         <input class="easyui-textbox" label="날짜:" labelPosition="top"   style="width: 100%;">
      </div>

      <div>
         <a href="#" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100%; height: 32px">Register</a>
      </div>
   </div>

   <!---------------------------- 글쓰기 화면 끝  ---------------------------->
</body>
</html>