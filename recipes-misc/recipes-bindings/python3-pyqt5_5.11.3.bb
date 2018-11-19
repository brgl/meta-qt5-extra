SUMMARY = "Python Qt5 Bindings"
AUTHOR = "Phil Thomson @ riverbank.co.uk"
HOMEPAGE = "http://riverbankcomputing.co.uk"
SECTION = "devel/python"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyqt/PyQt5_gpl-${PV}.tar.gz"
SRC_URI[md5sum] = "aac3428e90eca5df68c5764282fd9b98"
SRC_URI[sha256sum] = "c9b57d15601d436faf35dacf8e0acefa220194829a653e771e80b189b3261073"

PE = "1"

inherit qmake5 python3native

DEPENDS += "sip3-native sip3 qtbase python3"
DEPENDS_append_class-target = "qtsvg"

S = "${WORKDIR}/PyQt5_gpl-${PV}"
B = "${S}"

DISABLED_FEATURES = "PyQt_Desktop_OpenGL"

DISABLED_FEATURES_append_arm = " PyQt_qreal_double"

PYQT_MODULES = "QtCore QtGui QtNetwork QtWidgets QtSvg"
PYQT_MODULES_class-native = "QtCore"
PYQT_MODULES_aarch64 = "QtCore QtGui QtNetwork QtWidgets QtSvg"

# full paths
SYSROOTDIR = "${STAGING_DIR_HOST}"
SYSROOTDIR_class-native = "${STAGING_DIR_NATIVE}"
INCLUDEDIR = "${STAGING_INCDIR}"
INCLUDEDIR_class-native = "${STAGING_INCDIR_NATIVE}"
LIBDIR = "${STAGING_LIBDIR}"
LIBDIR_class-native = "${STAGING_LIBDIR_NATIVE}"
PYTHONEXEC="${bindir}/${PYTHON_PN}"
PYTHONEXEC_class-native="${PYTHON}"

do_configure() {
    echo "py_platform = linux" > pyqt.cfg
    echo "py_inc_dir = ${INCLUDEDIR}/python${PYTHON_BASEVERSION}${PYTHON_ABI}" >> pyqt.cfg
    echo "py_pylib_dir = ${LIBDIR}/python${PYTHON_BASEVERSION}" >> pyqt.cfg
    echo "py_pylib_lib = python${PYTHON_BASEVERSION}${PYTHON_ABI}" >> pyqt.cfg
    echo "pyqt_module_dir = ${D}/${PYTHON_SITEPACKAGES_DIR}" >> pyqt.cfg
    echo "pyqt_bin_dir = ${D}/${bindir}" >> pyqt.cfg
    echo "pyqt_sip_dir = ${D}/${datadir}/sip/PyQt5" >> pyqt.cfg
    echo "pyuic_interpreter = ${PYTHONEXEC}" >> pyqt.cfg
    echo "pyqt_disabled_features = ${DISABLED_FEATURES}" >> pyqt.cfg
    echo "qt_shared = True" >> pyqt.cfg
    QT_VERSION=`${OE_QMAKE_QMAKE} -query QT_VERSION`
    echo "[Qt $QT_VERSION]" >> pyqt.cfg
    echo "pyqt_modules = ${PYQT_MODULES}" >> pyqt.cfg
    echo yes | python3 configure.py --verbose --qmake ${OE_QMAKE_QMAKE} --configuration pyqt.cfg --sysroot ${SYSROOTDIR}
}

PARALLEL_MAKEINST = ""

do_install() {
     oe_runmake install
}

do_install_class-native() {
     oe_runmake install
}

RDEPENDS_${PN}_append_class-target = " python3-core python3-sip3"

FILES_${PN} += " \
    ${libdir}/${PYTHON_DIR}/site-packages \
    ${datadir}/sip/PyQt5 \
"

BBCLASSEXTEND += "native nativesdk"

