from ecoreprimitivetypes.estring import EString
from .user import User

class Customer(User):

	def __init__(self):
		self.__name: str = ''
		self.__shippingAddress: EString = None
		self.__billingAddress: str = ''

	def signUp(self):
		pass

	def login(self):
		pass

