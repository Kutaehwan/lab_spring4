<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/commonUIglobal.jsp" flush="false"/>
</head>
<body>
	<table class="easyui-datagrid" style="width:400px;height:250px"
        data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true">
    	<thead>
        	<tr>
            	<th data-options="field:'code',width:100">Code</th>
            	<th data-options="field:'name',width:100">Name</th>
            	<th data-options="field:'price',width:100,align:'right'">Price</th>
        	</tr>
    	</thead>
    	<tbody>
        <tr>
            <td>001</td><td>name1</td><td>2323</td>
        </tr>
        <tr>
            <td>002</td><td>name2</td><td>4612</td>
        </tr>
    </tbody>
	</table>
</body>
</html>