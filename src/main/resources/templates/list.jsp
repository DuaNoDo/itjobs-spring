<%@page import="java.util.List"%>
<%@page import="itjobs.bean.BoardDataBean"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ page import="itjobs.bean.IT_personal_mem_bean" %>
<%@ page import="itjobs.proc.*" %>
<%@ page import="java.sql.*" %>

<%@ page session="true" %>

<%String loginId=session.getAttribute("loginId").toString(); %>
<%
	if(loginId!=null || session.getAttribute("loginCompanyId")=="admin"){
%>
	
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>ITJobs</title>

	<link rel="stylesheet" href="../css/bootstrap.css">
	<meta name="keywords" content="IT,Jobs,ITJobs">
	<meta name="author" content="Won">
	<link rel="icon" type="../image/png" href="../assets/images/icon.png">

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- START: Styles -->

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i%7cWork+Sans:400,500,700" rel="stylesheet" type="text/css">
    
    <link rel="stylesheet" href="../assets/css/combined.css">

    <!-- END: Styles -->

	<script type="text/javascript"
		src="http://code.jquery.com/jquery-2.1.0.min.js">
	</script>

</head>

<body>

		


    <header class="header">
        <!--
        START: Navbar
    -->
        <nav class="navbar navbar-top navbar-sticky navbar-transparent navbar-white-text-on-top">
            <div class="container">
                <div class="nav-table">
                    <a href="../index.jsp" class="nav-logo">
                        <img src="../assets/images/logo-light.png" alt="" width="85" class="nav-logo-onscroll">
                        <img src="../assets/images/logo.png" alt="" width="85">
                    </a>
                    
                    <ul class="nav nav-right hidden-md-down" data-nav-mobile="#nav-mobile">
                    	<li>
                    		<table>
                    			<tr>
                    				<form method="get" action="../IT_search.jsp" name="search" >
	                    				<td style="border-bottom:1.5px solid rgba(0,0,0,0.3);">
		                    				<select name="sort" class="sort" style="font-color:#AAAAAA;" >
												<option value="adv_company">회사</option>
												<option value="adv_content">내용</option>
												<option value="adv_name">광고명</option>
											</select>
										</td>
	                    				<td style="border-bottom:1.5px solid rgba(0,0,0,0.3);">
	                    					<input class="form-control" type="text" name="keyword" placeholder="내용을 입력하세요" size="30" style="background:rgba(255,255,255,0.3); border-radius:8px;">
	                    				</td>
	                    				<td>
	                    					<input  TYPE="IMAGE" class="searchImg" src="../assets/images/search.png" weight="25px" height="25px" onclick="document.search.submit()"  align="absmiddle">
	                    				</td>
									</form>
								</tr>
                    		</table>
                    	</li>
                    	<%@ include file="IT_index_mem.jspf" %>
                        <li id="dropdown">
                            <a href="#">상세검색</a>
                            <div class="dropdown-content">
							    <a href="#">구인정보</a>
							    <a href="#">채용정보</a>
							</div>
						</li>
                    	<li>
                            <a href="list.jsp">커뮤니티</a>
                        </li>
                        
                        <li id="dropdown">
                            <a href="#IT_sign.jsp">마이페이지</a>
                            <div class="dropdown-content">
							    <a href="#">Link 1</a>
							    <a href="#">Link 2</a>
							    <a href="#">Link 3</a>
							</div>
						</li>             
                    </ul>
                </div>
            </div>
        </nav>
        <!-- END: Navbar -->
    </header>
    <div class="main">

        <!-- START: Header Title -->
        <div class="header-title header-title-full">
            <div class="bg-image">
                <div style="background-image: url('../assets/images/city1.jpg');"></div>
                <div class="bg-image-overlay" style="background-color: rgba(00, 00, 00, 0.2);"></div>
            </div>
            <div class="header-table">
                <div class="header-table-cell">
					<!-- 내용 넣을 곳 -->
<%!
    int pageSize = 10;
    SimpleDateFormat sdf = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<jsp:useBean id="bean" scope="page" class="itjobs.bean.BoardDataBean" />
<jsp:setProperty name="bean" property="*" />
<%
    String pageNum = request.getParameter("pageNum");

    if (pageNum == null) {
        pageNum = "1";
    }

    int currentPage = Integer.parseInt(pageNum);
    int startRow = (currentPage - 1) * pageSize + 1;
    int endRow = currentPage * pageSize;
    int count = 0;
    int number = 0;
    bean.setStart(startRow);
    bean.setEnd(pageSize);
    List<BoardDataBean> articleList = null; 
    
    IT_mybatis_Board_DAO dbPro = IT_mybatis_Board_DAO.getInstance();
    count = dbPro.getArticleCount();
    
    if (count > 0) {
        articleList = dbPro.getArticles(bean);
    }

	number = count-(currentPage-1)*pageSize;
%>

<p>글목록(전체 글:<%=count%>)</p>

<table>
  <tr>
    <td align="right" >
       <a href="writeForm.jsp">글쓰기</a>
    </td>
  </tr>
</table>

<% if (count == 0) { %>

<table>
<tr>
    <td align="center">
              게시판에 저장된 글이 없습니다.
    </td>
</table>

<% } else {%>
<form action="deleteBoard.jsp">
<table> 
    <tr height="30" > 
      <td align="center"  width="50">선택</td>
      <td align="center"  width="50"  >번 호</td> 
      <td align="center"  width="250" >제   목</td> 
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="150" >작성일</td> 
      <td align="center"  width="50" >조 회</td> 
      <td align="center"  width="100" >IP</td>    
    </tr>
<%  
   for (int i = 0 ; i < articleList.size() ; i++) {
       BoardDataBean article = articleList.get(i);
%>
   <tr height="30">
   <td><input type="checkBox" name="nums" value="<%=article.getNum()%>"></td>
    <td  width="50" > <%=number--%></td>
    <td  width="250" align="left">
<%
	int wid=0; 
	if(article.getRe_level()>0){
	   wid=5*(article.getRe_level());
%>
	  <img src="images/level.png" width="<%=wid%>" height="16">
	  <img src="images/re.png">
<%  }else{%>
	  <img src="images/level.png" width="<%=wid%>" height="16">
<%  }%>
           
      <a href="content.jsp?num=<%=article.getNum()%>&pageNum=<%=currentPage%>">
           <%=article.getSubject()%></a> 
<% if(article.getReadcount()>=20){%>
         <img src="images/hot.gif" border="0"  height="16"><%}%> </td>
    <td width="100" align="left"> 
       <a href="mailto:<%=article.getEmail()%>">
                     <%=article.getWriter()%></a></td>
    <td width="150"><%= sdf.format(article.getReg_date())%></td>
    <td width="50"><%=article.getReadcount()%></td>
    <td width="100" ><%=article.getIp()%></td>
  </tr>
<%}%>
</table>
<% if(session.getAttribute("loginCompanyId")=="admin") %>
<input type="submit">
</form>
<%}%>

<%
    if (count > 0) {
        int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage =1;
		
		if(currentPage % 10 != 0)
           startPage = (int)(currentPage/10)*10 + 1;
		else
           startPage = ((int)(currentPage/10)-1)*10 + 1;

		int pageBlock = 10;
        int endPage = startPage + pageBlock - 1;
        if (endPage > pageCount) endPage = pageCount;
        
        if (startPage > 10) { %>
          <a href="list.jsp?pageNum=<%= startPage - 10 %>">[이전]</a>
<%      }
        
        for (int i = startPage ; i <= endPage ; i++) {  %>
           <a href="list.jsp?pageNum=<%= i %>">[<%= i %>]</a>
<%      }
        
        if (endPage < pageCount) {  %>
        <a href="list.jsp?pageNum=<%= startPage + 10 %>">[다음]</a>
<%
        }
    }
%>

					<!-- 여기까지 내용 넣기 -->
                </div>
            </div>
        </div>

        <div id="header-title-scroll-down"></div>
		
        <!-- END: Header Title -->
    </div>




    <!-- START: Scripts -->

    <script src="assets/js/combined.js"></script>
    
    <!-- END: Scripts -->


</body>

</html>
<%
	}else{
%>
<script>
	alert("로그인한 유저만 가능합니다");
	history.go(-1);
	</script>
<% 
	}
%>



