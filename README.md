# LibraryManagementSystem

LIBRARY MANAGEMENT SYSTEM 
Kiran Kancheti
RDBMS:-MYSQL
WEB DEVOLOPMENT :-Java/J2EE/Java Script/CSS/HTML5
SERVER :- APACHE TOMCAT 6
IDE :- ECLLIPSE JUNO

Application was devoloped with an user –friendly GUI using CSS,
JavaScript, HTML5.The same CSS layout was applied to all the web pages in the project.
Designed GUI attractively,as GUI gives the real feel of the application.
MVC architecture pattern was implemented.
MYSQL was used as Relational Database.

SEARCH MODULE:
Inputs can be either of book_name,book_id,author name. Hence a radio button was used in UI as the
inputs are treated disjoint.The substring matching works for both book_name and author name.

CHECK-IN:-
Search can be performed by borrower card number,borrower name,isbn. Hint questions were added for
librarians for the easy understanding of the inputs to be provided using css appropriately.
Check boxes were provided as the librarians can check out multiple books at a time.
*The librarians will be notified, if the user needs to pay any fines w.r.t to the books which he is
returning. So that the librarians can warn the user about the fine which he needs to pay. For this
feature, a warning message with red color will be displayed.

CHECK OUT:-
Check out fails, if any of below conditions are not met.
1) Books are not available
2) Maximum number of books to be borrowed on the card exceeded.(Maximum allowed is 3)
3) Any fines to be paid. 

BORROWER MANAGEMENT:-
Will not allow to create the new user, if fname,lname,address matches.

LIBRARY FINES:-
Users will be allowed to pay the fines only if the books were returned back. Hence the check box for
paying the fine will not be displayed, in case the user had not returned the books.

HIGH LIGHTS:-
USER FRIENDLY GUI, where a naïve librarian can work on.Optimized queries for best performance.
Hint questions for librarians, for the input to be provided in the GUI using CSS.
While checking a book in, librarians will know, if the user does have any fines to be paid w.r.t to the
book which he is returning. A red warning message will be displayed, so that the librarian can warn
the user about the fine to be paid.
