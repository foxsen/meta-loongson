require rust-source-append.inc

#enable LoongArch target
EXTRA_OECMAKE += "-DLLVM_EXPERIMENTAL_TARGETS_TO_BUILD='LoongArch' "
