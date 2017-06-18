<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
<section>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
        </tr>
        </thead>
        <c:forEach items="${projectList}" var="project">
            <jsp:useBean id="project" scope="page" type="com.github.empyrosx.proversys.model.Project"/>
            <tr>
                <td><c:out value="${project.name}"/></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
