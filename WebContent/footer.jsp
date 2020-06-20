<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%!
    int pagecount=0;
    void addCount(){
    	pagecount++;
    }
    %>
    <%addCount(); %>
<br><br>
<center id="footer">
<p>The site has been visited <%=pagecount %> times.</p>
<p>Copyright  &#169;  2020</p>
</center>
</body>
</html>