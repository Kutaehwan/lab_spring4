<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
   StringBuilder path = new StringBuilder(request.getContextPath());
path.append("/");
List<Map<String, Object>> boardList = null;
boardList = (List<Map<String, Object>>) request.getAttribute("boardList");
int size = 0;
if (boardList != null) {
   size = boardList.size();
}
out.print("size : " + size);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 구현 - [WEB-INF]</title>
<!-- jEasyUI 시작 -->
<link rel="stylesheet" type="text/css" href="<%=path.toString()%>themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path.toString()%>themes/icon.css">

<!-- jEasyUI JS 시작 -->
<script type="text/javascript" src="<%=path.toString()%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path.toString()%>js/jquery.easyui.min.js"></script>
<script type="text/javascript">
   function searchButton() {
      console.log("조회 버튼 호출 성공");
      $('#dg_board').datagrid({
         url : 'jsonGetBoardList.sp4'
         , onDblClickCell : function(index, field, value) {
        	 if("BS_FILE" == field) {
        		 location.href="download.jsp?bs_file=" + value;
        	 }
         }
      });
   }

   function insert() {
      $('#dlg_ins').dialog('open');
   }
   
   function insertAction() {
	   $('#board_ins').submit();
	}

   function insertButton() {
      document.f_test.submit();
      alert('저장되었습니다.');
      $('#dlg_ins').dialog('close');
   }
   
   function closeAction() {
	   $('#dlg_ins').dialog('close');
   }
</script>
<script type="text/javascript">
   $(document).ready(function() {
      $('#dg_board').datagrid({
         columns : [ [ {
            field : 'BM_NO',
            title : '글번호',
            width : 100,
            align : 'center'
         }, {
            field : 'BM_TITLE',
            title : '제목',
            width : 350,
            align : 'left'
         }, {
            field : 'BM_DATE',
            title : '작성일',
            width : 200,
            align : 'center'
         }, {
            field : 'BS_FILE',
            title : '첨부파일',
            width : 100,
            align : 'center'
         }, {
            field : 'BM_HIT',
            title : '조회수',
            width : 200,
            align : 'center'
         } ] ]
      });
   });
</script>
</head>

<body>
   <table id="dg_board" class="easyui-datagrid" data-options="title:'게시판', toolbar:'#tb_board'" style="width: 1000px; height: 350px;">
      <tbody>
         <%
            /* 조회결과가 없는거야? */
         if (size == 0) {
         %>
         <tr>
            <td colspan="5">조회결과가 없습니다.</td>
         </tr>
         <%
            }
         /* 조회결과가 있는데? */
         else {
         for (int i = 0; i < size; i++) {
            Map<String, Object> rmap = boardList.get(i);
            if (i == size)
               break;
         %>
         <tr>
            <td><%=rmap.get("BM_NO")%></td>
            <!-- 너 댓글이니? -->
            <td>
            <%
            	String imgPath = "\\board\\";
            	if (Integer.parseInt(rmap.get("BM_POS").toString()) > 0) {
            		for (int j=0; j<Integer.parseInt(rmap.get("BM_POS").toString()); j++) {
            			out.print("&nbsp;&nbsp;");
            		}
            	
            %>
            	<!-- HTML 땅이다. -->
            	<img src="<%= imgPath %>reply.gif" board="0">
            <%
            	}/////////////////// end of if
            %>
            <a href="./getBoardDetail.sp4?bm_no=<%=rmap.get("BM_NO") %>" style="text-decoration: none"><%=rmap.get("BM_TITLE")%></a></td>
            <td><%=rmap.get("BM_DATE")%></td>
            <td>
            <%
            	if(rmap.get("BS_FILE") == null || rmap.get("BS_FILE").toString().length() == 0) {
            %>
            	<%="" %>
            <%
            	}
            	else {
            %>
            	<a href="./download.jsp?bs_file=<%=rmap.get("BS_FILE") %>" style="text-decoration: none"><%=rmap.get("BS_FILE")%></a>
            <%
            	}
            %>
            </td>
            <td><%=rmap.get("BM_HIT")%></td>
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
      <a href="javascript:searchButton()" class="easyui-linkbutton" iconCls="icon-add" plain="true">조회</a>
      <a href="javascript:insert()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">입력</a>
      <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true">저장</a>
      <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">삭제</a>
   </div>


   <div id="dlg_ins" class="easyui-dialog" title="글쓰기" data-options="iconCls:'icon-save', closed:'false', footer:'#ft_ins'"
      style="width: 500px; height: 500px; padding: 10px">
<!--       <form name="f_test" action="./getBoardList.sp4" method="get"> -->
      <form id="board_ins" action="./boardInsert.sp4" method="post" enctype= "multipart/form-data">
         <div style="margin-bottom: 20px">
            <input name="bm_no" class="easyui-textbox" label="번호:" labelPosition="top" data-options="prompt:'번호를 입력하세요'" style="width: 100%;">
         </div>
         <div style="margin-bottom: 20px">
            <input name="bm_title" class="easyui-textbox" label="제목:" labelPosition="top" style="width: 100%;">
         </div>
         <div style="margin-bottom: 20px">
            <input name="bm_date" class="easyui-textbox" label="작성일:" labelPosition="top" style="width: 100%;">
         </div>
         <div style="margin-bottom: 20px">
            <input name="bs_file" class="easyui-filebox" label="첨부파일:" labelPosition="top" style="width: 100%;">
         </div>
         <div style="margin-bottom: 20px">
         	<input name="bm_hit" class="easyui-textbox" label="조회 수:" labelPosition="top" style="width: 100%;">
         </div>
      
         <div>
            <button type="submit" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100%; height: 32px">작성</button>
         </div>
      </form>
   </div>
   <div id="ft_ins">
		<a href="javascript:insertAction()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">저장</a>
		<a href="javascript:closeAction()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">취소</a>
	</div>
</body>
</html>