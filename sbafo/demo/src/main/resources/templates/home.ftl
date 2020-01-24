<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>S.B.A.F.O. Demo</title>

    <link rel="stylesheet" href="https://unpkg.com/material-components-web@latest/dist/material-components-web.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Mono">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <style>
        /* Ensure layout covers the entire screen. */
        html {
            height: 100%;
        }

        .demo-main {
            padding-left: 16px;
        }

        section {
            padding-left: 16px;
        }
        
        /* Stack toolbar and content on top of each other. */
        .demo-body {
            display: flex;
            flex-direction: column;
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            min-height: 100%;
        }

        /* Place drawer and main next to each other. */
        .demo-content {
            display: flex;
            flex: 1 1 auto;
            height: 100%;
            box-sizing: border-box;
        }
        
        :root {
            --mdc-theme-primary: #ff0000;
        }
        
        .mdc-permanent-drawer {
            width: 250px;
        }
    </style>
</head>
<body class="mdc-typography demo-body">
    <header class="mdc-toolbar mdc-toolbar--fixed">
        <div class="mdc-toolbar__row">
            <section class="mdc-toolbar__section mdc-toolbar__section--align-start">
                <span class="mdc-toolbar__title catalog-title">SBAFO Demo</span>
            </section>
        </div>
    </header>

    <div class="demo-content mdc-toolbar-fixed-adjust">
        <nav class="mdc-permanent-drawer">
            <section>
                <div class="mdc-list-group">
                <#list mainMenu.menus as menu>
                    <#if menu.label != "-" >
                    <h3 class="mdc-list-group__subheader">${menu.label}</h3>
                    </#if>
                    <nav class="mdc-list">
                    <#list menu.items as item>
                        <a class="mdc-list-item" href="${rc.getContextPath()}${item.url}">
                            <i class="material-icons mdc-list-item__start-detail" aria-hidden="true">${item.icon}</i>${item.label}
                        </a>
                    </#list>
                    </nav>
                    <#if menu?has_next><hr class="mdc-list-divider"></#if>
                </#list>
                </div>
            </section>
        </nav>
        <main class="demo-main">
            <h1 class="mdc-typography--display1">Permanent Drawer</h1>
            <p class="mdc-typography--body1">It sits to the left of this content. Date: ${time?date}
                <br>
                Time: ${time?time}
                <br>
                Message: ${message}</p>

        </main>
    </div>

    <script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.js"></script>
    <script type="text/javascript">
        window.mdc.autoInit();
    </script>
</body>
</html>