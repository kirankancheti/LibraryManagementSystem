<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page language="java" import="java.util.*, java.lang.*" %>

<%@ page import="com.vo.Book" %>
<head>
<title>LIBRARY MANAGEMENT SYSTEM</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/new.css">



</head>
<body>

<div id="header">
<h1>City Gallery</h1>
</div>

<div id="nav">
London<br>
Paris<br>
Tokyo<br>
</div>

<div id="section">

<h1>LIBRARY MANAGEMENT SYSTEM</h1>
<h2>SEARCH</h2>
<FORM ACTION="LibraryAction" METHOD="post">
             <input type="text" name="searchstring" value="searchstring"> <a href="#" class="hintanchor" onMouseover="showhint('Please enter the search string.', this, event, '150px')">[?]</a>
             <BR>
             <INPUT TYPE="radio" NAME="radios" VALUE="bname" CHECKED>
             Search by Book Name
            <BR>
            <INPUT TYPE="radio" NAME="radios" VALUE="author">
             Search by author
            <BR>
            <INPUT TYPE="radio" NAME="radios" VALUE="bookid">
             Search by isbn
            <BR>
            <INPUT TYPE="submit" VALUE="Submit">
        </FORM>
        
     <table align="right">
  <tr>
    <th>BOOK_ID</th>
    <th>TITLE</th>
    <th>AUTHOR_NAME</th>
    
    <th>BRANCH</th>
    <th>NUM_OF_COPIES</th>
  </tr> 
  <%Object o=session.getAttribute("booklist");
  ArrayList<Book> al=null;
  if( o != null && o instanceof ArrayList){
	   al=(ArrayList<Book>)o;
	   for (int i=0;i<al.size();i++)
       {

           Book b=al.get(i); %>
           
            <tr>
    <th><%=b.getBook_id() %></th>
    <th><%=b.getTitle() %></th>
    <th><%=b.getAuthorName() %></th>
    <th><%=b.getBranch_Id() %></th>
    <th><%=b.getNo_of_copies() %></th>
  </tr>
           <% 
           

       }
  }

  
 %>
 
 

</div>

<div id="footer">
Copyright © W3Schools.com
</div>

</body>