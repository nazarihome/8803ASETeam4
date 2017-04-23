import plumbum
r = plumbum.machines.RemoteMachine("104.198.152.153",
 user="nazarihome", password="mohMOH13579")
fro = plumbum.local.path("README.md")
to = r.path("~/README.md")
plumbum.path.utils.copy(fro, to)