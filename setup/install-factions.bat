@echo off
call mvn install:install-file -Dfile=Factions.jar -DgroupId=com.massivecraft -DartifactId=Factions -Dversion=1.4.5 -Dpackaging=jar -DgeneratePom=true
PAUSE