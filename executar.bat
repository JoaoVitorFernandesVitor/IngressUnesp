@echo off
setlocal

REM Caminho relativo até o JavaFX SDK incluído no projeto
set JAVAFX_LIB=javafx-sdk-24.0.1\lib

REM Executa o JAR com os módulos JavaFX, mantendo o diretório atual (raiz do projeto)
java --module-path "%~dp0%JAVAFX_LIB%" --add-modules javafx.controls,javafx.fxml -jar "%~dp0target\MainApp-1.0-SNAPSHOT.jar"

pause
