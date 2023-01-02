FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "https://github.com/llvm/llvm-project/releases/download/llvmorg-14.0.6/llvm-project-14.0.6.src.tar.xz;name=llvm \
            file://rust-loongarch-support.patch;patchdir=${RUSTSRC} \
            file://llvm-loongarch.patch;patchdir=${RUSTSRC}"

SRC_URI[llvm.sha256sum] = "8b3cfd7bc695bd6cea0f37f53f0981f34f87496e79e2529874fd03a2f9dd3a8a"

addtask do_replace before do_patch after do_unpack

do_replace () {
    echo "replace llvm" 
    if [ -e ${RUSTSRC}/src/llvm-project.ori ]; then
        rm -rf  ${RUSTSRC}/src/llvm-project.ori
    fi
    mv ${RUSTSRC}/src/llvm-project  ${RUSTSRC}/src/llvm-project.ori
    mv ${RUSTSRC}/../llvm-project-14.0.6.src  ${RUSTSRC}/src/llvm-project
}
