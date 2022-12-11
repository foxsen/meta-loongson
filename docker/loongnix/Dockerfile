FROM cr.loongnix.cn/library/debian:buster
ARG user=loongson
LABEL maintainer="loongson" email="loongson.cn"
#deal with invalid certificates
RUN rm -f /var/lib/apt/lists/pkg.loongnix.cn_loongnix_dists_DaoXiangHu-stable_*
RUN apt -o Acquire::AllowInsecureRepositories=true -o Acquire::AllowDowngradeToInsecureRepositories=true update
RUN apt --allow-unauthenticated upgrade -y
RUN apt --allow-unauthenticated install -y apt-utils 
RUN apt --allow-unauthenticated install -y vim tmux man \
	    file zstd chrpath cpio cpp diffstat g++ gcc gawk git make patch wget lz4 libelf-dev libpulse-dev cmake \
	    libmpc-dev libpulse-dev libncurses-dev libasound2-dev libattr1-dev libpcap-dev libcap-dev bison flex openssl \
            multipath-tools librados2 libibumad3 libibverbs1 libibverbs-dev libibumad-dev librados-dev sudo locales \
            autoconf automake python3-setuptools wget iproute2 iptables

RUN localedef -i en_US -c -f UTF-8 -A /usr/share/locale/locale.alias en_US.UTF-8

# yocto warns that make 4.2.1 shipped is buggy, upgrade to 4.4
RUN wget http://ftp.gnu.org/gnu/make/make-4.4.tar.gz
RUN tar xzf make-4.4.tar.gz && cd make-4.4 && ./configure --prefix=/usr && make install  && cd ../ && rm -rf make-4.4*

RUN useradd --create-home --no-log-init --shell /bin/bash ${user} \
    && adduser ${user} sudo \
    && echo "${user}:loongson" | chpasswd \
    && usermod -a -G sudo ${user} 
WORKDIR /home/${user}
USER ${user}

