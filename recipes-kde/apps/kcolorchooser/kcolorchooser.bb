SUMMARY = "A very small utility to select a color"
LICENSE = "MIT"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=838c366f69b72c5df05c96dff79b35f2 \
"

inherit kde-apps gtk-icon-cache

DEPENDS += "\
    kauth-native \
    kconfig-native \
    kcoreaddons-native \
    ki18n \
    kwidgetsaddons \
    kxmlgui \
"

PV = "${KDE_APP_VERSION}"
SRC_URI[md5sum] = "0cf04a5362610c84fae2b930896466f6"
SRC_URI[sha256sum] = "8d17463c72325d1f39490052ca9efb45441355ccc3bf683716e53057ce16bae3"

FILES_${PN} += " \
    ${datadir}/icons \
"
