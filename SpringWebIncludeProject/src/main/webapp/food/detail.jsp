<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
    <table class="table">
      <tr>
        <td class="text-center" colspan="3">
          <img src="http://www.menupan.com${vo.poster }" style="width: 800px;height: 200px">
        </td>
      </tr>
      <tr>
        <td class="text-center" colspan="3"><h3>${vo.name }</h3></td>
      </tr>
      <tr>
        <td class="text-center" colspan="3">${vo.content }</td>
      </tr>
    </table>
   

  
    <table class="table">
      <tr>
       <td class="text-right">
         <input type=button class="btn-sm btn-warning" value="좋아요">
         <input type=button class="btn-sm btn-success" value="찜하기">
         <a href="../food/list.do" class="btn-sm btn-info">목록</a>
       </td>
      </tr>
    </table>
  </div>
</body>
</html>