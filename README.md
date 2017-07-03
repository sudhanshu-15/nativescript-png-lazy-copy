# nativescript-png-lazy-copy

Copying pngs to NativeScript/Android project based on screen resolutions (*hdpi, mdpi, xhdpi* etc) can get annoying. Motivated by boredom and laziness, wrote this piece of code to copy pngs to designated folders. This code was written keeping in mind Material Icons pngs downloadable from https://material.io/icons/

The function takes input the filename pattern (eg. ic_autorenew for ic_autorenew_black_24dp), the file destination folder address (it will recursively search for all files matching the filename pattern) and the file destination folder address (eg. user/xx/project-name/app/App_Resources for NativeScript projects).
