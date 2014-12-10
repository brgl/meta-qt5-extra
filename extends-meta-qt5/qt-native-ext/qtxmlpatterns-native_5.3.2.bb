require recipes-qt/qt5/qt5-${PV}.inc
require qt-native-ext.inc

SRC_URI[md5sum] = "857e8040b2bf45c114a7d75ec6ef94ee"
SRC_URI[sha256sum] = "acab0307039e117475caf2c95e425ead09ab5ee08ce15205fb3c0af7d7ec1abb"

# older copyright year than what e.g. qtbase is using now
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=4193e7f1d47a858f6b7c0f1ee66161de \
                    file://LICENSE.GPL;md5=d32239bcb673463ab874e80d47fae504 \
                    file://LGPL_EXCEPTION.txt;md5=0145c4d1b6f96a661c2c139dfb268fb6 \
                    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e"
