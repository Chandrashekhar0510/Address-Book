#! /bin/bash

function compileJavaFile()
{
	javac -d ./classes/ -cp ./classes/ $1

	echo "file compiles successfully"
}

for javaFiles in `find . -type f -name *.java`
do
	#echo "$javaFiles"

	compileJavaFile $javaFiles
done
