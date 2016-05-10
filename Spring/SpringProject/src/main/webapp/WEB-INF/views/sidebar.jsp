<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="submitUrl"  value="/user/new" />
<form method="POST" action="${submitUrl}" modelAttribute="user">
    <label for="userName">Name:</label>
    <input name="userName" id="userName"/>
    <label for="password">Password:</label>
    <input name="password" id="password"/>
    <input type="submit" value="Submit"/>
</form>