<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${not empty requestScope.user}">
        <div>
            <img src="${avapath}"/>
            <h1>ID:${user.id}</h1>
            <h1>Name:${user.userName}</h1>
            <h1>Password:${user.password}</h1>
        </div>
    </c:when>
    <c:otherwise>
        <h1>No user found</h1>
    </c:otherwise>
</c:choose>