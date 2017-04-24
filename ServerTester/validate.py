import sys
if 'Failures: 1' in open('out.txt').read():
	print("1 Test Failed")
    sys.exit(1)
if 'Failures: 2' in open('out.txt').read():
	print("2 Tests Failed")
    sys.exit(1)
