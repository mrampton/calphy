CLASSPATH=.:/usr/local/lib/antlr-4.5-complete.jar
JAVAC=javac
sources = $(wildcard *.java)
classes = $(sources:.java=.class)
antlr4=java -Xmx500M -cp $(CLASSPATH) org.antlr.v4.Tool
grun=java org.antlr.v4.runtime.misc.TestRig

.PHONY: all
all: antlr $(classes)

.PHONY: antlr
antlr:
	$(antlr4) Calphy.g4

.PHONY: gui
gui: antlr all
	$(grun) Calphy program test-code.calphy -gui

compiler: all
	java Compiler test-code.calphy

.PHONY: clean
clean :
	rm -f *.class Calphy*.java *.tokens

%.class : %.java
	$(JAVAC) $<
	
	