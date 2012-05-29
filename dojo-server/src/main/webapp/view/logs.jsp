<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <meta http-equiv="refresh" content="5">
        <meta http-equiv="Content-Type" content="text/html;">
		<title>Logs for ${playerName}</title>
        <link rel="stylesheet" type="text/css" href="/resources/style/dojo.css">
    </head>
	<body>
    <h3>Logs</h3>
        <jsp:include page="releaseInfo.jsp"/>
	    Logs for ${playerName}:<br>
	    <table id="table-logs">
	        <thead>
	            <th>Scenario</th><th>Score</th><th>Description</th><th>Log type</th>
	        </thead>
            <c:forEach items="${releaseLogs}" var="releaseLog" varStatus="statusRelease">
                <tr>
                    <td colspan=4>Release ${releaseLog.releaseNumber}</td>
                </tr>

                <c:forEach items="${releaseLog.records}" var="playerRecord" varStatus="statusRecord">
                <tr>
                    <td><a href="/scenario/${playerRecord.scenario.id}">${playerRecord.scenario.id}</a></td><td>${playerRecord.score}</td><td>${playerRecord.description}</td><td>${playerRecord.type}</td>
                </tr>
                </c:forEach>
            </c:forEach>
	    </table>
	</body>
</html>