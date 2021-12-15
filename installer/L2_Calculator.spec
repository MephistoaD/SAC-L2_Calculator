Name:           L2_Calculator
Version:        0.1
Release:        1%{?dist}
Summary:        Calculate your Layer 2 packets of the OSI stack!
License:        FIXME
URL:            https://github.com/MarcMocker/SAC-L2_Calculator
Source:         L2_Calculator-0.1.tar.gz
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
mkdir -p %{buildroot}/opt/L2_Calculator
mkdir -p %{buildroot}/usr/local/bin
mkdir -p %{buildroot}/usr/share/applications
install -m 644 L2_Calculator.jar %{buildroot}/opt/L2_Calculator/L2_Calculator.jar
install -m 755 L2_Calculator %{buildroot}/usr/local/bin/L2_Calculator
install -m 644 icon.jpg %{buildroot}/opt/L2_Calculator/icon.jpg
install -m 644 L2_Calculator.desktop %{buildroot}/usr/share/applications/L2_Calculator.desktop
mkdir -p %{buildroot}/usr/share/licenses

%clean
rm -fr $RPM_BUILD_ROOT

%files
/usr/local/bin/L2_Calculator
/usr/share/applications/L2_Calculator.desktop
/opt/L2_Calculator
