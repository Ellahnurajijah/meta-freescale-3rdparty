require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"

PV = "v2023.04+git${SRCPV}"

SRCREV = "698c2bd364ce4122a0d0db82b5a8d842186b2fa4"
SRCBRANCH = "master"
SRC_URI = "git://github.com/u-boot/u-boot.git;branch=${SRCBRANCH};protocol=https"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit deploy ${@oe.utils.ifelse(d.getVar('UBOOT_PROVIDES_BOOT_CONTAINER') == '1', 'imx-boot-container', '')}

DEPENDS += "bison-native dtc-native python3-setuptools-native"

PROVIDES += "u-boot"
BOOT_TOOLS = "imx-boot-tools"

COMPATIBLE_MACHINE = "(imx8mp-icore-ctouch2-of10)"