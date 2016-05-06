<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html xmlns:tiles="http://tiles.apache.org/tags-tiles">
    <head>
        <meta charset="UTF-8">
        <title><tiles:insertAttribute name="title"/></title>
        <tiles:insertAttribute name="stylecss" />
    </head>
    <body>
        MAIN!
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="content" />
        <tiles:insertAttribute name="footer" />
        <tiles:insertAttribute name="scriptjs" />
    </body>
</html>