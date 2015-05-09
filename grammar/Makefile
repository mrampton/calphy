CLASSPATH=.:../lib/antlr-4.5-complete.jar:/usr/local/lib/antlr-4.5-complete.jar
JAVAC=javac
TESTDIR=../testcode
TARGETCODE=../target_code
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
	$(grun) $(grammar) program test-code-2.calphy -gui

compiler:
	java Compiler test-code-2.calphy
	mv CalphyClass.java $(TARGETCODE)/

calphyc.jar: Calphy.g4 MyListener.java
	jar cfm calphyc.jar MANIFEST.MF *.class TranslateTable.txt

.PHONY: test
test: all
	ls $(TESTDIR)/test1* | xargs -I file java Compiler $(TESTDIR)/file

.PHONY: clean
clean :
	rm -f *.class $(grammar)*.java *.tokens

%.class : %.java
	$(JAVAC) $<
	
	
