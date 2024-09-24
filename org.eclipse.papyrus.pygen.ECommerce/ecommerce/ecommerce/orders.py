from ecoreprimitivetypes.edate import EDate
from ecoreprimitivetypes.edouble import EDouble

class Orders:

	def __init__(self):
		self.__id: int = 0
		self.__customerId: int = 0
		self.__orderDate: EDate = None
		self.__status: str = ''
		self.__totalPrice: EDouble = None

	def updateOrderStatus(self):
		pass

	def placeOrder(self):
		pass

	def cancelOrder(self):
		pass

