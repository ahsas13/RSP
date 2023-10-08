class Phone:
    def __init__(self, id, last_name, first_name, middle_name, address, credit_card_number, debit, credit, local_call_time, long_distance_call_time):
        self.id = id
        self.last_name = last_name
        self.first_name = first_name
        self.middle_name = middle_name
        self.address = address
        self.credit_card_number = credit_card_number
        self.debit = debit
        self.credit = credit
        self.local_call_time = local_call_time
        self.long_distance_call_time = long_distance_call_time

    def __str__(self):
        return f"ID: {self.id}, ФИО: {self.last_name} {self.first_name}, Адрес: {self.address}"

    def __hash__(self):
        return hash(self.id)

    def get_local_call_time(self):
        return self.local_call_time

    def set_local_call_time(self, time):
        self.local_call_time = time

def main():
    phone_list = [
        Phone(1, "Ivanov", "Ivan", "I.", "123 Main St", "123456789", 100.0, 0.0, 50.0, 20.0),
        Phone(2, "Petrov", "Petr", "P.", "456 Mira St", "987654321", 50.0, 25.0, 30.0, 40.0),
        Phone(3, "Sidorov", "Mihail", "V.", "789 Lenina St", "654321987", 200.0, 100.0, 70.0, 0.0),
        Phone(4, "Davidov", "Dimitry", "Y.", "321 Main St", "789456123", 150.0, 50.0, 80.0, 50.0)
    ]

    # a) Абоненты с временем внутригородских разговоров, превышающим заданное значение
    max_local_call_time = 60.0
    print(f"Абоненты с временем внутригородских разговоров > {max_local_call_time} минут:")
    for phone in phone_list:
        if phone.get_local_call_time() > max_local_call_time:
            print(phone)
    print()

    # b) Абоненты, использующие междугородную связь
    print("Абоненты, использующие междугородную связь:")
    for phone in phone_list:
        if phone.long_distance_call_time > 0.0:
            print(phone)
    print()

    # c) Абоненты в алфавитном порядке по фамилии
    print("Абоненты в алфавитном порядке:")
    sorted_phone_list = sorted(phone_list, key=lambda x: x.last_name)
    for phone in sorted_phone_list:
        print(phone)

if __name__ == "__main__":
    main()
