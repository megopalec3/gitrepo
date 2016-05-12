<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="submitUrl"  value="/user/new" />
<div>
    <sf:form method="POST" action="${submitUrl}" modelAttribute="user">
        <label for="userName">Name:</label>
        <sf:input path="userName" id="userName"/>
        <sf:errors path="userName" cssClass="error" />

        <label for="password">Password:</label>
        <sf:input path="password" id="password"/>
        <sf:errors path="password" cssClass="error" />

        <input type="submit" value="Create User" />
    </sf:form>
</div>
