#!/usr/bin/env bash

RPM=/root/rpmbuild
ORIG=/root/installer

rm -rf $ORIG/*noarch*

rm -rf $RPM

rpmdev-setuptree


TAR=$RPM/SOURCES/L2_Calculator-0.1.tar.gz
FOLDER=L2_Calculator-0.1
cd $ORIG
tar -cvzf $TAR $FOLDER 2> /dev/null > /dev/null
cd ~

cp -b $ORIG/L2_Calculator.spec $RPM/SPECS/L2_Calculator.spec

# clean dir structure until here

rpmbuild -ba rpmbuild/SPECS/L2_Calculator.spec

mv $RPM/RPMS/noarch/* $ORIG/*
tree
