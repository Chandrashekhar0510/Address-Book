#! /bin/bash


for classFiles in `find . -type f -name *.class`
do
        echo "$classFiles"
done

java -cp ./classes/ com/addressBook/test/$1
