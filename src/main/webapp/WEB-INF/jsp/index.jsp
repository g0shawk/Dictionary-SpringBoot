<%--
  Created by IntelliJ IDEA.
  User: Slavko Hojsak
  Date: 06/09/2022
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h1>
    <title>Dictionary v1.0 - Spring</title>
</h1>
<div align="left">
    <h2>Dictionary v1.0 - Spring</h2>
    <form action="list" method="post">
        Select a Language:&nbsp;
        <select name="language">
            <option value="">Language</option>
            <c:forEach items="${languages}" var="language">
                <option value="${language.languageName}">${language.languageName}</option>
            </c:forEach>
        </select>
        &nbsp;&nbsp;&nbsp;
        <input type="submit" value="Submit"/>
    </form>

    <form>
        <table width="75%">
            <tr>
                <td width="8%">Selected Language:</td>
                <td width="52%">
                    <input type="text" name="name"/>
                </td>
            </tr>
        </table>
    </form>

    <form>
        <table width="75%">
            <tr>
                <td width="8%">Selected Language Code:</td>
                <td width="52%">
                    <input type="text" name="name"/>
                </td>
            </tr>
        </table>
    </form>


    <form>
        <table width="75%">
            <tr>
                <td width="8%">Mother Language Code:</td>
                <td width="52%">
                    <input type="text" name="name"/>
                </td>
            </tr>
        </table>
    </form>

    <form>
        <table width="75%">
            <tr>
                <td width="8%">Message:</td>
                <td width="52%">
                    <input type="text" name="name"/>
                </td>
            </tr>
        </table>
    </form>

    <br/><br/>

    <form>
        <table width="75%">
            <tr>
                <td width="8%">Search Text:</td>
                <td width="52%">
                    <input type="text" name="name"/>
                </td>
            </tr>
        </table>
        <!--p>
            <input type="submit" name="Submit" value="Submit name" />
            <input type="reset" name="Reset" value="Reset form" />
        </p-->
    </form>

    <br/><br/>


    <form action="/TBD" method="get">
        <button type="button">Read Entire Dictionary</button>
    </form>

    <br/><br/>


    <form action="/TBD" method="get">
        <button type="button">PLAY</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button">SPEAK</button>
    </form>

    <br/><br/>

    <form action="/TBD" method="post">
        <button type="button">Insert Expression</button>
    </form>
    <form action="/TBD" method="post">
        <button type="button">Delete Expression</button>
    </form>
    <form action="/TBD" method="post">
        <button type="button">Edit Expression</button>
    </form>

    <br/><br/>
    <form action="/TBD" method="post">
        <button type="button">Create Dictionary</button>
    </form>

    <form action="/TBD" method="post">
        <button type="button">Delete Dictionary</button>
    </form>

    <form action="/TBD" method="post">
        <button type="button">Delete All Dictionaries</button>
    </form>

    <br/><br/>
    <form action="/TBD" method="post">
        <button type="button">Backup</button>
    </form>

    <form action="/TBD" method="post">
        <button type="button">Restore</button>
    </form>

    <form action="/TBD" method="post">
        <button type="button">Save to .txt</button>
    </form>

</div>
</body>
</html>
