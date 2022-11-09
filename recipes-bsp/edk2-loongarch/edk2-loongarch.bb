# TODO: build edk2 bios from source

DESCRIPTION = "edk2 for loongarch recipe"

inherit deploy

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://License.txt;md5=2b415520383f7964e96700ae12b4570a"

SRC_URI = "file://QEMU_EFI.fd file://License.txt"

S = "${WORKDIR}"

do_install () {
    install ${WORKDIR}/QEMU_EFI.fd ${D}/QEMU_EFI.fd
}

FILES:${PN} = "/QEMU_EFI.fd"

do_deploy () {
}

do_deploy:class-target () {
    install ${WORKDIR}/QEMU_EFI.fd ${DEPLOYDIR}/QEMU_EFI.fd
}

addtask do_deploy after do_compile before do_build

BBCLASSEXTEND = "native"
