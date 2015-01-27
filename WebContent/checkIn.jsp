<%@page import="sun.awt.image.PixelConverter.Bgrx"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page language="java" import="java.util.*, java.lang.*" %>

<%@ page import="com.vo.Loans" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/normalize.css"/>


<title>LIBRARY MANAGEMENT SYSTEM</title>
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


<script type="text/javascript" >
    function  changeBG () {
    if(document.getElementById("feild1").getAttribute(value) == true)
       document.getElementById("rowB").setAttribute(background-color,yellow) ;
       }
</script>



</head>
<body>
<div id="framecontent" >
<div class="innertube" style="background-image: url(stonecenter2.jpg);border: 2px solid;border-radius: 25px">
<h1 align="center">LIBRARY MANAGEMENT SYSTEM</h1>
 
    <table style="margin: auto;" cellpadding="10" cellspacing="10">
      <tr><th><a href="Index.jsp">SEARCH</a></th>
      <th><a href="checkIn.jsp">CHECK-IN </a></th>
      <th><a href="checkOut.jsp">CHECK-OUT </a></th>
      <th><a href="BorrowerManagement.jsp">BORROWER MANAGEMENT </a></th>
      <th><a href="LibraryFines.jsp">LIBRARY FINES </a></th></tr>
      </table>
 

</div>
</div>

<div id="maincontent">
<div class="innertube">
 <FORM ACTION="CheckIn" METHOD="post">
             <input type="text" name="searchstring" value="searchstring"> <a href="#" class="hintanchor" onMouseover="showhint('Please enter the search string.', this, event, '150px')">[?]</a>
             <BR>
             <INPUT TYPE="radio" NAME="radios" VALUE="bocid" CHECKED>
             Search by Borrower Card Number
            <BR>
            <INPUT TYPE="radio" NAME="radios" VALUE="bname">
             Search by Borrower Name
            <BR>
            <INPUT TYPE="radio" NAME="radios" VALUE="bookid">
             Search by isbn
            <BR>
            <INPUT TYPE="submit" VALUE="Submit">
        </FORM>
        
        
   <h3 align="center">LOAN DETAILS</h3>     
      <FORM ACTION="checkInUpdate" METHOD="post">   
     <table  style="margin: auto;" cellpadding="10" cellspacing="10">
  <tr>
     <th>CHECK_IN</th>
     <th>LOAN_ID</th>
    <th>BOOK_ID</th>
     <th>FNAME</th>
      <th>LNAME</th>
    <th>BRANCH</th>
    <th>CARD NUM</th>
    
    <th>DATE OUT</th>
    <th>DUE DATE</th>
  </tr> 
  <%Object o=session.getAttribute("loanlist");
  ArrayList<Loans> lns=null;
  if( o != null && o instanceof ArrayList){
	   lns=(ArrayList<Loans>)o;
	   if( lns!=null){	
			 java.util.Date td=new java.util.Date();
             java.sql.Date sqlDate = new java.sql.Date(td.getTime());
             Calendar cal = Calendar.getInstance();
             cal.setTime(sqlDate);
             cal.add(Calendar.DAY_OF_YEAR,0);
             cal.set(Calendar.HOUR_OF_DAY, 0);
             cal.set(Calendar.MINUTE, 0);
             cal.set(Calendar.SECOND, 0);
             cal.set(Calendar.MILLISECOND, 0);
             java.sql.Date today = new java.sql.Date(cal.getTimeInMillis());
	   for (int i=0;i<lns.size();i++)
       {

           Loans l=lns.get(i); 
           
           if(l.getDue_date().before(today)){
        	   l.setColor("red");
        	   
           }
           else{
        	   l.setColor("transparent");
           }
           %>
         
           
            <tr bgcolor=<%= l.getColor()%>>
            
   <th><input  type="checkbox"  value="<%=l.getLoanId() %>" name="mailId" ></th>
   <th><%=l.getLoanId() %></th>
    <th><%=l.getBook_id() %></th>
      <th><%=l.getFname() %></th>
        <th><%=l.getLname() %></th>
    <th><%=l.getBranch_Id() %></th>
    <th><%=l.getCardNum() %></th>
    <th><%=l.getDate_out() %></th>
    <th><%=l.getDue_date() %></th>
   
   
  
  </tr>
           <% 
           

       }%>
	 
	
		<%  session.removeAttribute("loanlist");
	   }
	 %>  <tr><th> <INPUT TYPE="submit" VALUE="CHECK IN"><th></tr> 
	 
	  <% 
  }

  
 %>
 
 </table>
 </FORM>
        
</div>


</div>

</body>
</html>