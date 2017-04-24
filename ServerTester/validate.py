import mmap
f = open('out.txt')
s = mmap.mmap(f.fileno(), 0, access=mmap.ACCESS_READ)
if s.find('Failures: 1') != -1:
    print sys.exit(1)
if s.find('Failures: 2') != -1:
    print sys.exit(1)