#!/usr/bin/env bash

JAR=L2_Calculator.jar
DESKTOP=L2_Calculator.desktop
EXECUTABLE=L2_Calculator
ICON=icon.jpg
PERMISSION=644 # permission for desktop entry, jar
EXEC_PERMISSION=755 # permission for binfile
BIN=/usr/local/bin
DESKTOP_DIR=/usr/share/applications
OPT=/opt/L2_Calculator

function install_desktop_entry() {
    #statements
    echo installing desktop entry...
    # place the desktop entry
    mv $DESKTOP $DESKTOP_DIR/$DESKTOP
    chmod $PERMISSION $DESKTOP_DIR/$DESKTOP
    # place the logo file:
    mkdir $OPT 2> /dev/null
    mv $ICON $OPT/$ICON
    echo done.
    # permission for desktop entry = 644
}

function install_executable() {
    #statements
    echo installing executable...
    mv $EXECUTABLE $BIN/$EXECUTABLE
    chmod $EXEC_PERMISSION $BIN/$EXECUTABLE
    echo done.

    # permission for executable: 755
}

function install_jar() {
    #statements
    echo installing jar...
    mkdir $OPT 2> /dev/null
    mv $JAR $OPT/$JAR
    chmod $PERMISSION $OPT/$JAR
    echo done.
}

echo install.sh

install_jar
install_executable
install_desktop_entry
