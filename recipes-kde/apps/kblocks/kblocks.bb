SUMMARY = "KBlocks - Falling Blocks Game"
LICENSE = "GPL-2.0 & GFDL-1.2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING.DOC;md5=ad1419ecc56e060eccf8184a87c4285f \
"

inherit kde-apps gtk-icon-cache

DEPENDS += " \
    kauth-native \
    kconfig-native \
    kcoreaddons-native \
    kdoctools-native \
    kcrash \
    kdbusaddons  \
    kwidgetsaddons  \
    ki18n \
    kconfigwidgets \
    kxmlgui \
    libkdegames \
"

PV = "${KDE_APP_VERSION}"
SRC_URI[sha256sum] = "7c8126851db68a163e6e1c3ef1bb29270f5bd10f0bfbea6959b56d389862541b"

FILES_${PN} += " \
    ${datadir}/config.kcfg \
    ${datadir}/knsrcfiles \
    ${datadir}/kxmlgui5 \
"
