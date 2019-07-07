<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:useBean id="kuma" class="wade.JourneyService"/>
<html>
    <head>
        <meta charset="UTF-8">
        <title>留言版</title>
    </head>
    <body>
        <table style="text-align: left; width: 100%;" border="1">
            <tr>
                <td>名稱</td><td>訊息</td>
            </tr>
            <c:forEach var="message" items="${kuma.journeys}">
                <tr>
                    <td>${message.locationname}</td><td>${message.country}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>  