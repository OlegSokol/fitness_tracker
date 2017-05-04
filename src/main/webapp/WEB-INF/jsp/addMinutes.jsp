<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Add Minutes Exercised</h1>

    Language : <a href="?language=en">English</a> | <a href="?language=uk">Ukrainian</a>

    <form:form commandName="exercise">
        <table>
            <tr>
                <td><spring:message code="goal.text"/></td>
                <td><form:input path="minutes"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Enter Exercise"/>
                </td>
            </tr>
        </table>
    </form:form>

    <h1>Our goal for the day is: ${goal.minutes}</h1>
</body>
</html>