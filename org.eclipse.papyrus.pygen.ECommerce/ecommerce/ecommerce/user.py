from ecoreprimitivetypes.edate import EDate

class User:

	def __init__(self):
		self.__id: int = 0
		self.__email: str = ''
		self.__password: str = ''
		self.__lastLogin: EDate = None

	def getSession(self):
		pass

