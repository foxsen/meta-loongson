# meta-loongson

It is a yocto bsp layer for loongson machines. We make minimal changes to add support to upstream poky repository to support loongarch(mainly the qemuloongarch64 machine for now), combine with this layers, we can build a working os for loongarch64.

## steps to build an image for qemuloongarch64

1. clone the modified poky code.

```bash
git clone -b loongarch https://github.com/foxsen/poky
```

2. clone this repository in the poky top level directory

```bash
cd poky
git clone https://github.com/foxsen/meta-loongson
git checkout loongarch
```

3. setup the environment

```bash
export MACHINE=loongarch64
source oe-init-build-env
<make necessary changes, see the following notes>
bitbake core-image-minimal
```

For changes to configuration, you can refer to meta-loongson/conf/{bblayers.conf.sample,local.conf.sample}

4. run and test

If everything goes smooth, you can get a working image for loongarch. Test it with qemu:

```bash
runqemu
```

or

```bash
runqemu nographic serialstdio
```

5. generate sdk

bitbake -c populate_sdk core-image-minimal

## what does meta-loongson contains?

Again, I am trying hard to keep the modification minimal. 

1. Some upstream packages need some patches to support loongarch. They are:

    * libffi
    * diffutils
    * openssl 

2. We are using a custom linux kernel, because the latest yocto kernel is 5.19 which does not have full support for loongarch. This is not a perfect solution. We can try to add patches to the yocto 5.19 kernel, or waiting for newer kernel(upstream v6.1 should fully support loongarch64).

3. qemu-system-loongarch64 need a bios. For now the edk2-loongarch recipe provide its binary. Should be changed to build from source. Poky has ovmf recipe but it does not support loongarch yet.

4. conf and sample configurations




