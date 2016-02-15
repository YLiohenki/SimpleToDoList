<#macro page title="DefaultTitle">
<!DOCTYPE html>
    <html>
    <head>
        <title>${title}</title>
        <script src="../scripts/main.js">
        </script>
        <link rel="stylesheet" href="../css/application.css" type="text/css" charset="utf-8">
    </head>
    <body>
        <div id="views">
            <div id="tasks">
                <#nested/>
            </div>
        </div>
    </body>
    </html>
</#macro>