from ecoreprimitivetypes.edouble import EDouble
from ecoreprimitivetypes.edate import EDate

class Order Details:

	def __init__(self):
		self.__orderId: int = 0
		self.__shippingAddress: str = ''
		self.__shippingCost: EDouble = None
		self.__deliveryAddress: str = ''
		self.__createdDate: EDate = None

	def cancelOrder(self):
		pass

