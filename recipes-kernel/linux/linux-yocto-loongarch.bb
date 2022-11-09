SUMMARY = "An Loongarch kernel recipe that uses the linux-yocto and oe-core"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://github.com/loongson/linux.git;protocol=https;branch=loongarch-next;name=machine \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.19;destsuffix=${KMETA} \
           file://defconfig "

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION ?= "6.1-rc2"
LINUX_VERSION_EXTENSION:append = "-la"

SRCREV_machine = "9d3cf9851c031894528c54fe0d0470db56f96f86"
SRCREV_meta ?= "1cd6a86d7aa5d42ce72097d011c907bd4ea354ec"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "qemuloongarch64"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "1"

KERNEL_FEATURES:append = " ${KERNEL_EXTRA_FEATURES}"
KERNEL_FEATURES:append:qemuall=" cfg/virtio.scc features/drm-bochs/drm-bochs.scc cfg/net/mdio.scc"

