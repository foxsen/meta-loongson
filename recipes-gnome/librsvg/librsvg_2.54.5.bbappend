FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://librsvg-2.54.5-loongarch-support.patch \
            file://cargo-checksum-change.patch"

