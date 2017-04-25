from sys import argv

script, user_name=argv

promt='>'

print ("Hi %s, I'am the %s script." % (user_name, script))
print ("I'd like to ask you a few questions.")
print ("Do you like me %s?" % user_name)
likes=input(promt)

print ("Where do you live %s?" % user_name)
lives=input(promt)

print ("What kind of computer do you have?")
computer=input(promt)

print ("""
Alright, so you said %s about liking me.
You live in %s. Not sure where that is.
And you have a %s computer. Nice.
""" % (likes, lives, computer))