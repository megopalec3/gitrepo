<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<sf:form method="POST" action="/spitter/new/user" modelAttribute="user">
        <table>
            <tr>
                <td><sf:label path="userName">Name:</sf:label></td>
                <td><sf:input path="userName"/></td>
            </tr>
            <tr>
                <td><sf:label path="password">Password:</sf:label></td>
                <td><sf:input path="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
</sf:form>