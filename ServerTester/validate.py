import sys
if 'Failures: 1' in open('out.txt').read():
    sys.exit(1)
if 'Failures: 2' in open('out.txt').read():
    sys.exit(1)
