docker file for build environments.

loongnix: 

- build environment for loongnix/loongarch
- usage:
	* build the docker image: docker build -t loongos-build .
        * run the image: prepare a local directory with enough space and read/writable by uid:gid 1000:1000, change /home/loongson/loongos-data to this directory, then source run.sh. 


