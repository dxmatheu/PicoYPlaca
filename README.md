# PicoYPlacaForStackBuilders
A predictor that given a lisence plata number, a date and a time tells if the car with that lisence plate can go out considering the Pico y Placa restrictions

This code was written for Android API 26 of higher. It was written in Android Studio so I recommend compiling the project with the same IDE. 
Project should run on anny Gradle Script interpreter. 
It was manually tested with Android Studio's emulator and a phisical device (Xiaomi Redmi 9 Pro with Android 10).

THIS PROJECT HAS TWO VERSIONS

UserFriendlyVersion:

is the first final and fully functional iteration of the project and implements what, for my criteria, could be the best Input method for the solution, 
hence the name, it still has room for improvement to avoid code repetition on ResultActivity, it has some unused commented code, Logs and does not implement getters.



VersionWithMailSpecifications:

is a branch from UserFriendlyVersion implementing a solution considering that the date input has to be a String. Has a cleaner code but also still has room for
improvement to augment sophistication.
