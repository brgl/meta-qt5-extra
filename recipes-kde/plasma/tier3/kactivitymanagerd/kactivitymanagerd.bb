SUMMARY = "System service to manage user's activities"
LICENSE = "GPLv2 | GPLv3"
LIC_FILES_CHKSUM = " \
    file://COPYING.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
"

inherit kde-plasma

DEPENDS += " \
    kdbusaddons \
    ki18n \
    kcoreaddons \
    kconfig \
    kxmlgui \
    kwindowsystem \
    kio \
    kservice \
    kglobalaccel \
"

PV = "${PLASMA_VERSION}"
SRC_URI[md5sum] = "ad3ebd2e14a464e554f8c61809b5fbfa"
SRC_URI[sha256sum] = "4c53828d5ab9f2beab592b8690c769c8af20ee72af298d12a1e0b7d9dbededb5"
SRC_URI += "file://0001-replace-try_run-by-try_compile-in-compiler-feature-c.patch"

FILES_SOLIBSDEV = ""

FILES_${PN} += " \
	${datadir}/k*5 \
    ${libdir}/libkactivitymanagerd_plugin.so \
    ${OE_QMAKE_PATH_PLUGINS} \
"

FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/*/*/.debug \
"
