CLASSPATH=.:../lib/antlr-4.5-complete.jar:/usr/local/lib/antlr-4.5-complete.jar
JAVAC=javac
TESTDIR=../testcode
TARGETCODE=../target_code
TARGETEXT="java"
sources = $(wildcard *.java)
classes = $(sources:.java=.class)
antlr4=java -Xmx500M -cp $(CLASSPATH) org.antlr.v4.Tool
grun=java org.antlr.v4.runtime.misc.TestRig
grammar=Calphy

.PHONY: all
all: antlr $(classes) compiler

Calphy.g4: Calphy.tokens
	$(antlr4) $(grammar).g4

Calphy.tokens:
	
MyListener.java:

.PHONY: antlr
antlr: Calphy.g4

.PHONY: gui
gui: antlr all
	$(grun) $(grammar) program test-code.calphy -gui

compiler:
	java Compiler test-code.calphy
	mv CalphyClass.$(TARGETEXT) $(TARGETCODE)/

calphyc.jar: Calphy.g4 MyListener.java
	jar cfm calphyc.jar MANIFEST.MF *.class TranslateTable.txt

.PHONY: targetcode
targetcode:
	rm -rf {.,../target_code}/CalphyClass*.$(TARGETEXT)
	javac $(TARGETCODE)/*.java

.PHONY: test
test: all
	ls $(TESTDIR)/test1*.calphy | xargs -I file java Compiler $(TESTDIR)/file

.PHONY: test1 test2 test3 test4 test5 test6 testsetup
testsetup: antlr $(classes)
	java Compiler $(TESTDIR)/test*.calphy
	mv CalphyClass.$(TARGETEXT) $(TARGETCODE)/
	javac -cp $(TARGETCODE) $(TARGETCODE)/CalphyClass.$(TARGETEXT)
	

.PHONY: tester
tester: antlr $(classes) targetcode
	-rm $(TARGETCODE)/{Calphy,Java}.out
	java Compiler $(TESTDIR)/Tester.calphy
	mv CalphyClass.$(TARGETEXT) $(TARGETCODE)/
	javac -cp $(TARGETCODE) $(TARGETCODE)/CalphyClass.$(TARGETEXT)
	cd $(TARGETCODE); java CalphyClass > Calphy.out; java Tester > Java.out
	echo "Diff Results:"
	@echo "<<< Java output  |  Calphy output >>>"
	@diff $(TARGETCODE)/{Java,Calphy}.out 

.PHONY: clean
clean :
	rm -f *.class $(grammar)*.java *.tokens

%.class : %.java
	$(JAVAC) $<
	
	
