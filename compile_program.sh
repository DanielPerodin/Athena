#!/bin/bash

cd src
javac InsightTester.java
for f in *.java; do
    filename="${f%.*}"
done
mv *.class ../bin