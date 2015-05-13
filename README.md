# Calphy


### Building the compiler
```
$ cd grammar
$ make all
```
This compiles the Calphy compiler and packages it as a jar -- the jar is moved to the test_code directory
### Compiling and Running Calphy Code
```
$ pwd
calphy/grammar
$ cd ../test_code
$ ls
CalphyClass.class	calphy.sh		calphyc.sh		test1_energy.calphy	test3_projectile.calphy
Tester.calphy		calphyc.jar		other-tests		test2_Force.calphy
$ ./calphyc.sh test1_energy.calphy EnergyTest
$ ./calphy.sh EnergyTest
Extra work being done is: 12.000000
```
## Antlr
If you are encountering errors building the compiler, you may need to install Antlr
locally as described [here: Antrl4 Installation](https://theantlrguy.atlassian.net/wiki/display/ANTLR4/Getting+Started+with+ANTLR+v4)
