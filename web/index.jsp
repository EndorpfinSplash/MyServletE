<%--
  Created by IntelliJ IDEA.
  User: Andrey_Z
  Date: 17.06.2018
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    <title>JSP Timing</title>
</head>
<body>

 <form name="FirstServlet" action="FirstServlettest" method="post">
     <input type="hidden" name="my_time" value="${System.currentTimeMillis()}"/>
     <p>Кнопка нажата через ${res1} секунд! </p>
     <p>Админ этого сервлета ${admServleta} аминь! </p>
     <input type="submit" name="button" value="вывести строку"/>

     <p>Servlet metadata: ${servletMetadata}  </p>

 </form>

 <h5>Счетчик времени от запуска приложения до нажатия кнопки</h5>
    <jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>

    <form name="Simple" action="timeaction" method="POST">
        <input type="hidden" name="time" value="${calendar.timeInMillis}"/>
        <input type="submit" name="button" value="Посчитать время"/>
    </form>

</body>
</html>
