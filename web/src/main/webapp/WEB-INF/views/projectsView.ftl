<html>
<body>
<h2>Project list!</h2>

<fieldset>
    <legend>Add User</legend>
    <form name="user" action="/projects" method="post">
        Name: <input type="text" name="name"/> <br/>
        <br/>
        <input type="submit" value="Save"/>
    </form>
</fieldset>


Projects available:

<ul>
<#list projects as project>
    <li>${project_index + 1}. ${project.name}</li>
</#list>
</ul>
</body>
</html>