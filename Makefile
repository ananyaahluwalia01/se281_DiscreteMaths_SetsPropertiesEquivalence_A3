package= nz.ac.auckland.softeng281.a3
bin = bin
ifeq ($(OS),Windows_NT)
	src = src\main\java
	src_test = src\test\java
    	classpath = $(bin);lib\junit-4.13.1.jar;lib\hamcrest-core-1.3.jar
    	package_path = nz\ac\auckland\softeng281\a3
    	build_path = $(src)\$(package_path)\SetOfStrings.java  $(src)\$(package_path)\StringRelation.java  $(src_test)\$(package_path)\StringRelationTest.java $(src_test)\$(package_path)\SetOfStringsTest.java $(src)\$(package_path)\SetUI.java  $(src)\$(package_path)\SetControl.java $(src_test)\$(package_path)\TestsForMarking.java  
    	clean_command = rd /s /q
	find = where
else
	src = src/main/java
	src_test = src/test/java
    	classpath = $(bin):lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar
    	package_path = nz/ac/auckland/softeng281/a3
    	build_path = $(src)/$(package_path)/SetOfStrings.java  $(src)/$(package_path)/StringRelation.java  $(src_test)/$(package_path)/StringRelationTest.java $(src_test)/$(package_path)/SetOfStringsTest.java $(src)/$(package_path)/SetUI.java  $(src)/$(package_path)/SetControl.java $(src_test)/$(package_path)/TestsForMarking.java 
    	clean_command = rm -rfv
	find = which
endif

all: dependencies clean build test-marking

dependencies:
	$(find) java javac

clean:
	$(clean_command) $(bin)

build: clean
	javac -cp $(classpath) -d $(bin)  $(build_path)
test-set: clean build
	java -cp $(classpath) org.junit.runner.JUnitCore $(package).SetOfStringsTest

test-relation: clean build
	java -cp $(classpath) org.junit.runner.JUnitCore $(package).StringRelationTest
	
run: clean build 
	java -cp $(classpath) $(package).SetControl
	
test-marking: clean build
	java -cp $(classpath) org.junit.runner.JUnitCore $(package).TestsForMarking
	
