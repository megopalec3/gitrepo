<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title><tiles:insertAttribute name="title"/></title>
        <tiles:insertAttribute name="stylecss" />
    </head>
    <body>
        <div class="header_wrapper">
            <tiles:insertAttribute name="header" />
        </div>
        <div class="content_wrapper">
            <tiles:insertAttribute name="content" />
        </div>
        <div class="sidebar_wrapper">
            <tiles:insertAttribute name="sidebar" />
        </div>
        <div class="footer_wrapper">
            <tiles:insertAttribute name="footer" />
        </div>
        <tiles:insertAttribute name="scriptjs" />
    </body>
</html>