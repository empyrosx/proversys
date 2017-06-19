<html>
<body>
<h2>Project list!</h2>

Projects available:

<ul>
<#list projectList as project>
    <li>${project_index + 1}. ${project.name}</li>
</#list>
</ul>
</body>
</html>