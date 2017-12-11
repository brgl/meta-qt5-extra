require ${BPN}.inc

SRC_URI += " \
    file://0001-Make-our-cross-build-find-parsetrigrams.patch \
    file://0002-make-build-of-hunspell-optional.patch \
"

FILES_${PN} += " \
    ${OE_QMAKE_PATH_PLUGINS}/kf5/sonnet \
"

FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/kf5/sonnet/.debug \
"

PACKAGECONFIG ??= "hunspell"
PACKAGECONFIG[hunspell] = "-DBUILD_HUNSPELL=ON,-DBUILD_HUNSPELL=OFF, hunspell"

