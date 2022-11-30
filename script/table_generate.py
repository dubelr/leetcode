# script from @sodinfeliz https://github.com/sodinfeliz/LeetCode/tree/master/script

import re
from pathlib import Path

def extract(path: Path):
    num, title = str(path.stem).split(sep='_', maxsplit=1)
    title = title.replace('_', ' ')
    lines = open(str(path), 'r').read().splitlines()[1:4]
    qlink = re.findall('^Link: (.*)', lines[0])[0]
    diff = re.findall('^Difficulty: (.*)', lines[1])[0]
    tags = re.findall('^Tags: (.*)', lines[2])[0]

    return num, title, qlink, diff, tags


def main():
    src_paths = list(Path('java/').glob('*.java'))
    src_paths.sort(reverse=False)

    with open('./script/README_table.md', 'w') as f:
        f.write('\n| # | Title | Solution | Difficulty | Tags |\n')
        f.write('|---| ----- | -------- | ---------- | ---- |\n')
        
        for path in src_paths:
            num, title, qlink, diff, tags = extract(path)
            f.write(f'| {num} | [{title}]({qlink}) | [Java](./java/{path.name}) | {diff} | {tags} |\n')

main()