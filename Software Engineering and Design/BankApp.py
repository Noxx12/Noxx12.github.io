class Bank:
    def __init__(self):
        # Initialize investment details with default values
        self.initial_investment = 0.0
        self.monthly_deposit = 0.0
        self.annual_interest = 0.0
        self.years = 0.0
        self.total_amount = 0.0

    def get_user_input(self):
        # Prompt the user for input values
        try:
            self.initial_investment = float(input("Initial Investment Amount: $"))
            self.monthly_deposit = float(input("Monthly Deposit: $"))
            self.annual_interest = float(input("Annual Interest (%): "))
            self.years = int(input("Number of years: "))
            # Set total_amount to the initial investment
            self.total_amount = self.initial_investment
        except ValueError:
            # Handle invalid input
            print("Invalid input. Please enter numeric values.")

    def display_without_monthly_deposits(self):
        # Display results without considering additional monthly deposits
        print("\nBalance and Interest Without Additional Monthly Deposits")
        print("=============================================================")
        print("Year          Year End Balance          Year End Earned Interest")

        # Calculate interest and balance at the end of each year
        year_end_balance = self.initial_investment
        for year in range(1, int(self.years) + 1):
            interest_amount = year_end_balance * (self.annual_interest / 100)  # Calculate annual interest
            year_end_balance += interest_amount  # Update year-end balance
            # Print year, year-end balance, and interest earned for the year
            print(f"{year}\t\t${year_end_balance:.2f}\t\t\t${interest_amount:.2f}")

    def display_with_monthly_deposits(self):
        # Display results considering additional monthly deposits
        print("\nBalance and Interest With Additional Monthly Deposits")
        print("=============================================================")

        total_amount = self.initial_investment
        # Calculate interest and balance monthly, then accumulate over the years
        for year in range(1, int(self.years) + 1):
            yearly_interest = 0
            for _ in range(12):  # Loop over each month
                # Calculate monthly interest based on the updated total amount
                interest_amount = ((total_amount + self.monthly_deposit) * (self.annual_interest / 100)) / 12
                yearly_interest += interest_amount  # Accumulate yearly interest
                total_amount += self.monthly_deposit + interest_amount  # Update total amount each month
            # Print year, total amount at year-end, and total interest earned for the year
            print(f"{year}\t\t${total_amount:.2f}\t\t\t${yearly_interest:.2f}")


if __name__ == "__main__":
    # Create a Bank object and run the program
    bank = Bank()
    bank.get_user_input()
    bank.display_without_monthly_deposits()
    bank.display_with_monthly_deposits()
