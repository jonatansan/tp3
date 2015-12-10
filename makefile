JC = javac
JFLAGS = -g
.SUFFIXES: .java .class
.java.class :	
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		Grille.java \
		JeuDeLaVie.java \
		Test.java


default: classes

classes: $(CLASSES:.java=.class)

benchmark:
	java JeuDeLaVie benchmark

test:
	java JeuDeLaVie test


clean: 
		$(RM) *.class
