#!/bin/bash
CLASSPATH=../target_code/


if [ "$#" -ne 1 ] && [ "$#" -ne 2 ]
then
        echo "Usage: `basename $0` <sourcecode.calphy> <optional: output> "
        exit 1
fi

java -jar calphyc.jar $1 $2

if [ "$#" -ne 2 ]
then
	javac -cp $CLASSPATH CalphyClass.java
	# rm CalphyClass.java
	exit 0
fi

javac -cp $CLASSPATH $2.java
# rm $2.java

exit 0