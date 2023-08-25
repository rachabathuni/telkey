# telkey
A Telugu keyboard for Android to type in RTS script.

Apart from handling various UI elements and events, the core of the application is in the engine that accepts English characters and translates them into Telugu Unicode characters. A state machine keeps track of the characters entered and uses a mapping table to map them to appropriate Telugu characters. 

For example:
If you want to write: "తెలుగులో రాయండి", you would type "telugulO rAyaMDi"

![Telkey Screenshot](https://raw.githubusercontent.com/rachabathuni/telkey/master/images/telkey.png)

