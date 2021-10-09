import base64
import os
from github import Github
from pprint import pprint
username="amfoss"
g=Github()
user=g.get_user(username)
repostore=[]
for repo in user.get_repos():
	print(repo)
	repostore.append(repo)
url=""
win=""
splitchar='"'
for a in repostore:
	win=str(a)
	url=win.partition(splitchar)[2]
	url=url.strip("\")")
	command = "perceval git --json-line https://github.com/" + url + ">> commits.json"
	os.system(command)

