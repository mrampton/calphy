#!/bin/bash
CLASSPATH=../target_code/

if [ "$#" -ne 1 ]
then
        echo "Usage: `basename $0` <calphycode.java> "
        exit 1
fi

java -cp $CLASSPATH $1
rm $1.java
exit 0
