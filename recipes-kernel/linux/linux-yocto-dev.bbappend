FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://disable-explicit-reloc-for-gcc12.patch \
            file://defconfig"
