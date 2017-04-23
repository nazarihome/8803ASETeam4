from paramiko_scp

#client = scp.Client(host="104.198.152.153", user="nazarihome", password="mohMOH13579")

# and then
#client.transfer('README.md', '~/README.md')


def createSSHClient(server, port, user, password):
    client = paramiko.SSHClient()
    client.load_system_host_keys()
    client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    client.connect(server, port, user, password)
    return client

ssh = createSSHClient(host="104.198.152.153", user="nazarihome", password="mohMOH13579")
scp = SCPClient(ssh.get_transport())