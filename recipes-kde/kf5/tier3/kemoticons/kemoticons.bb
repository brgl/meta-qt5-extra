SUMMARY = "Support for emoticons and emoticons themes"
LICENSE = "GPLv2 | LGPLv2.1"
LIC_FILES_CHKSUM = " \
	file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24 \
	file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
"

inherit kde-kf5 gettext

DEPENDS += "karchive kconfig kconfig-native kservice kcoreaddons kcoreaddons-native"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "fc4556f09c2e5fb536f6c06d72abacaa"
SRC_URI[sha256sum] = "ca1311f31ad6c924c5d513be3f0c7c5c57ad319cfe76234ae43c35d2e53304b9"

FILES_${PN} += " \
    ${datadir}/emoticons \
    ${datadir}/k*5 \
    ${OE_QMAKE_PATH_PLUGINS} \
"
FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/kf5/.debug \
    ${OE_QMAKE_PATH_PLUGINS}/kf5/*/.debug \
"
