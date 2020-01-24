# delilah


## Introduction

The goal of this project is to provide a template of a webapplication useful to build a *backoffice applications* in a fast way.  
The main idea behind this is that in my career I found that usually in a *backoffice app* there are a lot of repetitive behaviour for the most part of the application and only a small part requires a custom "approach".  
The "repetitive behaviour" often is based on the hated [CRUD](https://en.wikipedia.org/wiki/Create,_read,_update_and_delete) functions.  
So I think that mixing something able to handle those "repetitive behaviours", with something else specifically built for a custom use case, could heavily improve the development of your *backoffice*.  

In order to do that, **delilah** is based on a very strong assumption: the layout is specifically defined and you have to understand it. Any customization of this part could lead to a really pain in the ass experience. So, if you need to change the layout, **delilah** is probably not for you.


## Layout

The idea is to have a layout like this:

```
---------------------------------------------------------
   LOGO                <SEARCH>                         |
---------------------------------------------------------
 MAINMENU      | CONTENT                                |
               |                                        |
               |                                        |
               |                                        |
               |                                        |
               |                                        |
               |                                        |
               |                                        |
               |                                        |
               |                                        |
               |                                        |
               |                                        |
               |                                        |
---------------------------------------------------------
```

## Logo

Pretty obvious.


## Search

The idea is that the user should have a unique field to make a search. This lead to a design problem that we have to fix... more on this later.


## MainMenu

The main menu contains all the contents available in the application.


## Content

A content can be a custom page or an entity page.  
If it is a custom page, you are responsible of writing everything.  
If it is an entity, you have to develop a specific controller that will help you to write everything you need to create the basic experience of the layout of **delilah**. So even the global search mentioned above.

