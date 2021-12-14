Name:           L2_Calculator
Version:        0.1
Release:        1%{?dist}
Summary:        Calculate your Layer 2 packets of the OSI stack!
License:        GPLv3+
URL:            https://github.com/MarcMocker/SAC-L2_Calculator
Source:         => the tarball in the source folder
Requires:       bash,java-11-openjdk
BuildArch:      noarch
Buildroot:      /tmp/L2_Calculator_Buildroot

%description
Calculator which calculates the total transmitted
bytes out of an amount of L3 bytes, the number of
Ethernet frames / AAL5 ATM or AAL3/4 ATM cells and
optional the padding.
For more information please visit the projects GitHub page:
https://github.com/MarcMocker/SAC-L2_Calculator

%prep
%setup -q

%build

%install
rm -fr $RPM_BUILD_ROOT
make install

%clean
rm -fr $RPM_BUILD_ROOT

%files
%license LICENSE

/usr/local/bin/L2_Calculator
