SUMMARY = "Baloo provides searching and indexing infrastucture with an emphasis on files"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c \
"

inherit kde-kf5 cmake_auto_align_paths cmake_lib gtk-icon-cache

DEPENDS += " \
    ki18n \
    kconfig \
    kconfig-native \
    kidletime \
    kauth \
    kauth-native \
    kcrash \
    solid \
    kio \
    kdbusaddons \
    kitemmodels \
    kfilemetadata \
    kcoreaddons-native \
    \
    xapian-core \
"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "4d856340bd15547452f4369195ca77f3"
SRC_URI[sha256sum] = "8ddf85c6ae74dac868f37b562b80fdad753888f0c75b97ab26f01bdfc7bf5ea8"

SRC_URI += " \
    file://0001-fix-build-for-QT_NO_SESSIONMANAGER.patch \
    file://org.kde.baloo.fileindexer.xml \
"

CMAKE_ALIGN_SYSROOT[1] = "KF5Baloo, -S${libdir}, -s${OE_QMAKE_PATH_HOST_LIBS}"

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/icons \
    ${datadir}/kservices5 \
    ${OE_QMAKE_PATH_QML}/org/kde/baloo \
    ${OE_QMAKE_PATH_PLUGINS} \
"

FILES_${PN}-dbg += " \
    ${libdir}/*/.debug \
    ${OE_QMAKE_PATH_QML}/org/kde/baloo/.debug \
    ${OE_QMAKE_PATH_QML}/org/kde/baloo/experimental/.debug/ \
    ${OE_QMAKE_PATH_PLUGINS}/.debug \
    ${OE_QMAKE_PATH_PLUGINS}/kf5/*/.debug \
"
