#!/bin/bash

#Template Script with skeleton code for NativeScript app build. Copies App_Resources and package.json to the main code base
#and then tries to run tns run
#a work in progress
#more features to be added
#code to be refined
#This script will be invoked later by the Java code ---> Not sure yet --> POC

#takes in two parameters source folder and destination folder


echo "Hello, $USER"
#Copy App_Resources
echo "Copying App_Resources"

src="$1/App_Resources"
desti="$2/app/"
next=0
if cp -avR $src $desti
then
    echo "Success Copying App_Resources"
    next=1
else
    echo "Failure, exit status $?"
    next=0
fi

#Copy package.json
if [ $next -eq "1" ]
then
    src="$1/package.json"
    desti="$2/package.json"
    if cp -avR $src $desti
    then
        echo "Success Copying package.json"
        next=1
    else
        echo "Failure, exit status $?"
        next=0
    fi
else
    echo "Failed to copy package.json"
fi

#Run tns info if above commads worked
#TODO: tns info will be replaced by tns run
if [ $next -eq "1" ]; then
    echo "Running tns info"
    cd $2
    tns info
else
    echo "Failed to run tns info"
fi
