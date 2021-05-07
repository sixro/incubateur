<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Demo</title>

<!-- getmdl.io -->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.red-yellow.min.css" /> 
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<!-- Handlebars -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.min.js"></script>

<style>
.app-layout .mdl-layout__header-row .mdl-navigation__link:last-of-type  {
  padding-right: 0;
}

.app-menu {
    text-transform: uppercase;
    font-weight: bold;
}

#app-progressbar {
    width: 100%;
}

#app-progressbar {
    display: none;
}

.app-content-box {
    padding: 5px 50px;
}

.app-content-box .mdl-grid.entity {
    height: 150px;
}

.app-content-box .mdl-grid.entity h4 {
    margin-top: 0px;
    margin-bottom: 0px;
}

.app-content-box .mdl-grid.entity h6 {
    margin-top: 0px;
}

.page-content {
    padding:50px;
    padding-top: 10px;
}

.app-page {
    display: none;
}

</style>
</head>
<body class="app">
<div class="app-layout mdl-layout mdl-js-layout">
    <div id="app-progressbar" class="mdl-progress mdl-js-progress mdl-progress__indeterminate"></div>
    <header class="mdl-layout__header mdl-layout__header--waterfall">
        <!-- Top row, always visible -->
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <span class="mdl-layout-title">Demo</span>
            <div class="mdl-layout-spacer"></div>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable mdl-textfield--floating-label mdl-textfield--align-right">
            <label class="mdl-button mdl-js-button mdl-button--icon" for="waterfall-exp">
                <i class="material-icons">search</i>
            </label>
            <div class="mdl-textfield__expandable-holder">
                <input class="mdl-textfield__input" type="text" name="sample" id="waterfall-exp">
            </div>
          </div>
        </div>
        <#-- Additional links under the main bar, not visible on scroll
        <div class="mdl-layout__header-row">
          <div class="mdl-layout-spacer"></div>
          <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="">Link</a>
            <a class="mdl-navigation__link" href="">Link</a>
            <a class="mdl-navigation__link" href="">Link</a>
            <a class="mdl-navigation__link" href="">Link</a>
          </nav>
        </div>
          -->
    </header>
    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">Demo</span>
        <nav class="mdl-navigation">
            <#--
            <a class="mdl-navigation__link" href="">Link</a>
            <a class="mdl-navigation__link" href="">Link</a>
            <a class="mdl-navigation__link" href="">Link</a>
            <a class="mdl-navigation__link" href="">Link</a>
            -->
        </nav>
    </div>
<main class="mdl-layout__content">
<div class="page-content">

<div id="home" class="app-page" >
<h3>Home</h3>
<p>Welcome to Marlboro Country!</p>
</div><!-- home -->
    
<div id="books" class="app-page"  >
<h3>Books</h3>
<div class="sub-page-content">
</div>

<script id="books-template" type="text/x-handlebars-template">
{{#each entities}}
<div class="mdl-grid entity">
    <div class="mdl-cell mdl-cell--3-col" style="background-image: url('{{coverUrl}}'); overflow: hidden; background-size: cover; background-position: center;" /></div>
    <div class="mdl-cell mdl-cell--8-col">
        <h4>{{title}}</h4>
        <h6>by {{author}}</h6>
        <p>{{description}}</p>
    </div>
    <div class="mdl-cell mdl-cell--1-col">
        <button id="menu-{{@index}}" class="mdl-button mdl-js-button mdl-button--icon">
            <i class="material-icons">more_vert</i>
        </button>
        <ul class="mdl-menu mdl-js-menu" for="menu-{{@index}}">
            <li class="mdl-menu__item">Fast</li>
            <li class="mdl-menu__item" disabled>Medium</li>
            <li class="mdl-menu__item">Slow</li>
        </ul>
    </div>
</div>
{{/each}}
</script>

<script>
    $("#books").bind("onShow", function() {
        console.log("Handling '#books.onShow' event...");
        
        var entity = "books";
        
        $('#app-progressbar').show();
        $.get(
            "${rc.getContextPath()}/" + entity,
            function(data) {
                var source = document.getElementById(entity + "-template").innerHTML;
                var tpl = Handlebars.compile(source);
                var html = tpl({ entities: data });
                var contentContainer = document.querySelector('.sub-page-content');
                contentContainer.innerHTML = html;

                window.componentHandler.upgradeAllRegistered();
            }
        ).fail(function() {
            var snackbar = document.querySelector('#app-snackbar');
            var data = { message: 'Unable to load ' + entity };
            snackbar.MaterialSnackbar.showSnackbar(data);
        }).done(function() {
            $('#app-progressbar').hide();
        });

        console.log("... OK, '#books.onShow' event handled");
    });
</script>
</div><!-- home -->
    
<div id="albums" class="app-page"  >
<h3>Albums</h3>
<p>TODO</p>
</div><!-- home -->
    
<div id="credits" class="app-page" >
<h3>Credits</h3>
<p>TODO</p>
</div><!-- home -->
    
</div><#-- page-content -->
</main>

<div id="app-snackbar" class="mdl-js-snackbar mdl-snackbar">
    <div class="mdl-snackbar__text"></div>
    <button class="mdl-snackbar__action" type="button"></button>
</div>
</div>

<script id="menu-template" type="text/x-handlebars-template">
{{#each items}}
    <span class="mdl-navigation__link app-menu mdl-color-text--primary">{{label}}</span>
    {{#each items}}
    <a class="mdl-navigation__link" href="{{url}}">{{label}}</a>
    {{/each}}    
{{/each}}
</script>

<script>
    $(document).ready(function() {
        console.log("Starting application...");
        
        $('#app-progressbar').show();
        $.get(
            "${rc.getContextPath()}/menu",
            function(data) {
                var source = document.getElementById("menu-template").innerHTML;
                var menuTemplate = Handlebars.compile(source);
                var menuHTML = menuTemplate({ items: data });
                var menuContainer = document.querySelector(".app-layout .mdl-layout__drawer .mdl-navigation");
                menuContainer.innerHTML = menuHTML;
            }
        ).fail(function() {
            var snackbar = document.querySelector('#app-snackbar');
            var data = { message: 'Unable to load application menu' };
            snackbar.MaterialSnackbar.showSnackbar(data);
        }).done(function() {
            $('#app-progressbar').hide();
        });
        
        var urlParams = new URLSearchParams(window.location.search);
        if (urlParams.has("entity")) {
            var entity = urlParams.get("entity");
            console.log("Entity: " + entity);

            $('#app-progressbar').show();
            $.get(
                "${rc.getContextPath()}/" + entity,
                function(data) {
                    var source = document.getElementById(entity + "-template").innerHTML;
                    var tpl = Handlebars.compile(source);
                    var html = tpl({ entities: data });
                    var contentContainer = document.querySelector('.app-content-box');
                    contentContainer.innerHTML = html;
                    
                    window.componentHandler.upgradeAllRegistered();
                }
            ).fail(function() {
                var snackbar = document.querySelector('#app-snackbar');
                var data = { message: 'Unable to load ' + entity };
                snackbar.MaterialSnackbar.showSnackbar(data);
            }).done(function() {
                $('#app-progressbar').hide();
            });
        }
        
        $(window).bind("hashchange", function(event) {
            console.log("Hiding all application pages...");
            $('.app-page:visible').hide();
            var pageID = event.target.location.hash;
            if (!pageID)
                pageID = "#home";
            console.log("Showing application page '" + pageID + "'...");
            $(pageID).fadeIn("slow", function() {
                //var pageName = pageID.substr(1);
                //var eventDynamicPart = pageName.substr(0, 1).toUpperCase() + pageName.substr(1);
                //var eventID = "on" + eventDynamicPart + "Show";
                var eventID = "onShow";
                console.log("Triggering event '" + eventID + "' on page '" + pageID + "'...");
                $(this).trigger(eventID);
            });
            
            $(".mdl-layout__obfuscator.is-visible").click();
        });
        $(window).trigger("hashchange");        
    });
</script>
</body>
</html>
