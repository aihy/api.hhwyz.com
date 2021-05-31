import datetime

from dateutil.relativedelta import relativedelta
from scipy import optimize
import sys


def xnpv(rate, cashflows):
    return sum([cf / (1 + rate) ** ((t - cashflows[0][0]).days / 365.0) for (t, cf) in cashflows])


def xirr(cashflows, guess=0.1):
    try:
        return optimize.newton(lambda r: xnpv(r, cashflows), guess)
    except:
        print('Calc Wrong')


def get(num_of_months, money_of_each_month, all_money, begin_date=datetime.date(2021, 1, 1)):
    data = [(begin_date, all_money)]
    for i in range(1, num_of_months + 1):
        data.append((begin_date + relativedelta(months=+1) * i, -1 * money_of_each_month))
    print("{:.2f}%".format(xirr(data) * 100))
    return "{:.2f}%".format(xirr(data) * 100)


if __name__ == "__main__":
    # get(36, 3550, 139900-20985)
    get(int(sys.argv[1]), int(sys.argv[2]), int(sys.argv[3]))
