# Server Driven Compose POC

This project currently consists of one application. It is designed with view, material UI components, single activity multiple fragment, legacy navigation strategy etc. in mind to demonstrate a proof of concept that it is possible to migrate from a legacy code base to modern android development practices.

Second application will be added in future to demonstrate server driven compose with modern android development practices.

## Screenshots
![](.documentation/screenshots/dashboard_recording.gif)
![](.documentation/screenshots/dashboard.png)
![](.documentation/screenshots/profile.png)
![](.documentation/screenshots/settings.png)

## Widgets and Components concept

### Widget Contract

Widget basic structure
```json
{
  "type": "<string:non-nullable>",
  "header": "<object:nullable>",
  "components": "<array|slice:non-nullable>",
  "tag": "<object:nullable>"
}
```

#### List Widget

```json
{
  "type": "list",
  "components": [],
  "tag": "widget-1",
  "header": {
    "title": "Hello World Section"
  }
}
```

### Component Contract

Component basic structure
```json
{
  "type": "<string:non-nullable>",
  "data": "<object:non-nullable>",
  "action": "<object:nullable>"
}
```

#### Text Component
```json
{
  "type": "tile-text",
  "data": {
    "title": "hello, world",
     "subtitle": "hello, world"
  },
  "action": null
}
```

## TODO

 - [X] add more example widgets/components
   - [X] add carousel widget
   - [X] add tile image component
   - [X] add tile banner component
 - [ ] deeplink navigation for legacy app
 - [X] handle server driven actions
 - [X] second fragment host on top of main activity in legacy app
 - [ ] add new app designed with modern android development practices with server driven concept
 - [X] handle action & navigation with delegates
 - [ ] implement legacy back press behaviour
