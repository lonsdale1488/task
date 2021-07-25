# task

Using this API (https://developer.marvel.com/docs) create an app with the following screens: 
1.	List of characters received from “v1/public/characters” endpoint
2.	Character details received from “/v1/public/characters/{characterId}” endpoint
Core features:
1.	The app should be able to work offline if requests were done previously.
2.	The app should have pagination on the list screen (would be good if the candidate will implement it without using any libraries).
3.	The app should work in both orientations (portrait and landscape) and persist its state through configuration changes. In landscape orientation app should show a list and details side by side, in the portrait orientation app should show a list screen and when the user clicks on an item - open the 2nd screen.
Architecture
The app should be written with MVVM with the Clean Architecture approach. 
Libraries: 
Must have libraries: 
1.	Kotlin coroutines
2.	Room
3.	Retrofit2
Candidates can also use any other libraries. 
