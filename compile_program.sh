#!/bin/bash

cd src
javac Athena.java
for f in *.java; do
    filename="${f%.*}"
done
mv *.class ../bin