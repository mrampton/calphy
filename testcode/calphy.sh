#!/bin/bash
CLASSPATH=../target_code/

if [ "$#" -ne 1 ]
then
        echo "Usage: `basename $0` <calphycode.java> "
        exit 1
fi

cp $1.class $CLASSPATH
cd $CLASSPATH; java $1
rm $1.java
exit 0
