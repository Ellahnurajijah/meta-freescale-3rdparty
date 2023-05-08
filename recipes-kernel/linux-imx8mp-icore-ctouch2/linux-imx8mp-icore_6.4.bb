# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.4.0"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/next/linux-next.git;branch=${SRCBRANCH};protocol=https \
           file://0001-arm64-dts-freescale-Add-Engicam-i.Core-MX8M-Plus-C.T.patch \
           file://0002-dt-bindings-arm-fsl-Add-Engicam-i.Core-MX8M-Plus-C.T.patch \
           file://${THISDIR}/files/fsl-ctouch-display-enable.cfg \
"

LOCALVERSION = "-2.2.0+yocto"
SRCBRANCH = "master"
SRCREV = "44c026a73be8038f03dbdeef028b642880cf1511"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(imx8mp-icore-ctouch2-of10)"

KBUILD_DEFCONFIG ?= "defconfig"

S = "${WORKDIR}/git"
