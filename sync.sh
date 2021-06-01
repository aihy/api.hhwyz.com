#!/bin/bash -x

rsync -aPh /Users/zihao_wang/here/pros/api.hhwyz.com/ 169.254.1.2:/home/zihao_wang/api.hhwyz.com
#ssh 169.254.1.2 "cd /home/zihao_wang/api-hhwyz && git push"
