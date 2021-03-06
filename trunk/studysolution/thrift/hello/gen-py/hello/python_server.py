#!/usr/bin/env python

import sys
sys.path.append('./gen-py')

#from hello import UserExchange
#from hello.ttypes import *

from ttypes import * 
import UserExchange
import thread 

from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer

users = []

class UserExchangeHandler:
	def __init__(self):
		pass
		#self.log = {}

	def ping(self):
		print 'ping()'

	def add_user(self, user):
		if user.firstname == None:
			raise InvalidValueException(1,'no firstname exception')
		if user.lastname == None:
			raise InvalidValueException(2, 'no lastname exception')
		if user.user_id <= 0:
			raise InvalidValueException(3, 'wrong user_id')
		if user.sex != SexType.MALE and user.sex != SexType.FEMALE:
			raise InvalidValueException(4, 'wrong sex id')
		#print "tid=" + thread.get_ident() + " Processing user " + user.firstname + " " + user.lastname
		print "tid=%d Processing user %s %s" % (thread.get_ident(), user.firstname, user.lastname)
		users.append(user)
		return 1

	def get_user(self, user_id):
		if user_id < 0:
			raise InvalidValueException(5, 'wrong id')
		return users[user_id]
		
	def clear_list(self):
		print 'Clearing list'
		print users
		del users [:]
		print users



handler = UserExchangeHandler()
processor = UserExchange.Processor(handler)
transport = TSocket.TServerSocket("localhost",9090)
tfactory = TTransport.TBufferedTransportFactory()
pfactory = TBinaryProtocol.TBinaryProtocolFactory()

server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)
#server = TServer.TThreadedServer(processor, transport, tfactory, pfactory)
#server = TServer.TThreadPoolServer(processor, transport, tfactory, pfactory)

print 'Starting the server...'
server.serve()
print 'done.'
