<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page language="java" import="java.util.*, java.lang.*" %>

<%@ page import="com.vo.Book" %>
<html>
<head>
<title>LIBRARY MANAGEMENT SYSTEM</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/normalize.css">



<style type="text/css">

#hintbox{ /*CSS for pop up hint box */
position:absolute;
top: 0;
background-color: lightyellow;
width: 150px; /*Default width of hint.*/ 
padding: 3px;
border:1px solid black;
font:normal 11px Verdana;
line-height:18px;
z-index:100;
border-right: 3px solid black;
border-bottom: 3px solid black;
visibility: hidden;
}

.hintanchor{ /*CSS for link that shows hint onmouseover*/
font-weight: bold;
color: navy;
margin: 3px 8px;
}

</style>

<script type="text/javascript">

/***********************************************
* Show Hint script- © Dynamic Drive (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit http://www.dynamicdrive.com/ for this script and 100s more.
***********************************************/
		
var horizontal_offset="9px" //horizontal offset of hint box from anchor link

/////No further editting needed

var vertical_offset="0" //horizontal offset of hint box from anchor link. No need to change.
var ie=document.all
var ns6=document.getElementById&&!document.all

function getposOffset(what, offsettype){
var totaloffset=(offsettype=="left")? what.offsetLeft : what.offsetTop;
var parentEl=what.offsetParent;
while (parentEl!=null){
totaloffset=(offsettype=="left")? totaloffset+parentEl.offsetLeft : totaloffset+parentEl.offsetTop;
parentEl=parentEl.offsetParent;
}
return totaloffset;
}

function iecompattest(){
return (document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body
}

function clearbrowseredge(obj, whichedge){
var edgeoffset=(whichedge=="rightedge")? parseInt(horizontal_offset)*-1 : parseInt(vertical_offset)*-1
if (whichedge=="rightedge"){
var windowedge=ie && !window.opera? iecompattest().scrollLeft+iecompattest().clientWidth-30 : window.pageXOffset+window.innerWidth-40
dropmenuobj.contentmeasure=dropmenuobj.offsetWidth
if (windowedge-dropmenuobj.x < dropmenuobj.contentmeasure)
edgeoffset=dropmenuobj.contentmeasure+obj.offsetWidth+parseInt(horizontal_offset)
}
else{
var windowedge=ie && !window.opera? iecompattest().scrollTop+iecompattest().clientHeight-15 : window.pageYOffset+window.innerHeight-18
dropmenuobj.contentmeasure=dropmenuobj.offsetHeight
if (windowedge-dropmenuobj.y < dropmenuobj.contentmeasure)
edgeoffset=dropmenuobj.contentmeasure-obj.offsetHeight
}
return edgeoffset
}

function showhint(menucontents, obj, e, tipwidth){
if ((ie||ns6) && document.getElementById("hintbox")){
dropmenuobj=document.getElementById("hintbox")
dropmenuobj.innerHTML=menucontents
dropmenuobj.style.left=dropmenuobj.style.top=-500
if (tipwidth!=""){
dropmenuobj.widthobj=dropmenuobj.style
dropmenuobj.widthobj.width=tipwidth
}
dropmenuobj.x=getposOffset(obj, "left")
dropmenuobj.y=getposOffset(obj, "top")
dropmenuobj.style.left=dropmenuobj.x-clearbrowseredge(obj, "rightedge")+obj.offsetWidth+"px"
dropmenuobj.style.top=dropmenuobj.y-clearbrowseredge(obj, "bottomedge")+"px"
dropmenuobj.style.visibility="visible"
obj.onmouseout=hidetip
}
}

function hidetip(e){
dropmenuobj.style.visibility="hidden"
dropmenuobj.style.left="-500px"
}

function createhintbox(){
var divblock=document.createElement("div")
divblock.setAttribute("id", "hintbox")
document.body.appendChild(divblock)
}

if (window.addEventListener)
window.addEventListener("load", createhintbox, false)
else if (window.attachEvent)
window.attachEvent("onload", createhintbox)
else if (document.getElementById)
window.onload=createhintbox

</script>

</head>
<body style="background-image: url(ZenBG (2).jpg)" >

<div id="framecontent" >
<div class="innertube" style="background-image: url(stonecenter2.jpg); border: 1px solid black;background-color:#b0c4de;border: 2px solid;border-radius: 25px">
<h1 align="center" color="blue">LIBRARY MANAGEMENT SYSTEM</h1>
 
    <table style="margin: auto;" cellpadding="10" cellspacing="10">
      <tr><th><a href="index1.jsp" >HOME</a></th>
      <th><a href="Index.jsp" >SEARCH</a></th>
      <th><a href="checkIn.jsp">CHECK-IN </a></th>
      <th><a href="checkOut.jsp">CHECK-OUT </a></th>
      <th><a href="BorrowerManagement.jsp">BORROWER MANAGEMENT </a></th>
      <th><a href="LibraryFines.jsp">LIBRARY FINES </a></th></tr>
      </table>
      
     

</div>
</div>

<div id="maincontent">
<div class="innertube" >


 <FORM ACTION="LibraryActionMultiple" METHOD="post">
           
             <INPUT TYPE="text" NAME="bname" VALUE="" CHECKED> <a href="#" class="hintanchor" onMouseover="showhint('Please enter the search string.', this, event, '150px')">[?]</a>
             Search by Book Name
            <BR><br>
            <INPUT TYPE="text" NAME="author" VALUE=""> <a href="#" class="hintanchor" onMouseover="showhint('Please enter the search string.', this, event, '150px')">[?]</a>
             Search by author
            <BR><br>
            <INPUT TYPE="text" NAME="bookid" VALUE=""> <a href="#" class="hintanchor" onMouseover="showhint('Please enter the search string.', this, event, '150px')">[?]</a>
             Search by isbn
            <BR><br>
            <INPUT TYPE="submit" VALUE="Submit">
        </FORM>
        
 


     <table align="right">
  <tr>
    <th>BOOK_ID</th>
    <th>TITLE</th>
    <th>AUTHOR_NAME</th>
    
    <th>BRANCH</th>
    <th>|NUM_OF_COPIES</th>
    <th>|AVAILABLE NO OF COPIES</th>
  </tr> 
  <%Object o=session.getAttribute("booklist");
  ArrayList<Book> al=null;
  if( o != null && o instanceof ArrayList){
	   al=(ArrayList<Book>)o;
	   if( al!=null){
	   for (int i=0;i<al.size();i++)
       {

           Book b=al.get(i); %>
           
            <tr>
    <th><%=b.getBook_id() %></th>
    <th><%=b.getTitle() %></th>
    <th><%=b.getAuthorName() %></th>
    <th><%=b.getBranch_Id() %></th>
    <th><%=b.getNo_of_copies() %></th>
    <th><%=b.getAvail_no_of_copies() %></th>
  </tr>
           <% 
           

       }
	 session.removeAttribute("booklist");
		
	   }
	  
  }

  
 %>
 </table>
</div>
</div>
 

</body>

</html>