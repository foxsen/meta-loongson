# TODO: build edk2 bios from source

DESCRIPTION = "edk2 for loongarch recipe"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://License.txt;md5=2b415520383f7964e96700ae12b4570a"

SRC_URI = "file://QEMU_EFI.fd file://License.txt"

S = "${WORKDIR}"

do_install () {
    install -m 0755 QEMU_EFI.fd ${DEPLOY_DIR_IMAGE}/
}

BBCLASSEXTEND = "native nativesdk"
