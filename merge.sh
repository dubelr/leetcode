#!/bin/bash

if command -v python &> /dev/null; then
    python ./script/table_generate.py
elif command -v python3 &> /dev/null; then
    python3 ./script/table_generate.py
else
    echo Python not installed.
    exit 1
fi

cat ./script/README_main.md ./script/README_table.md > README.md
rm -f ./script/README_table.md
exit 0
