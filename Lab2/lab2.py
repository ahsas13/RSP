# определяем класс TravelPackage для представления путевки
class TravelPackage:
    def __init__(self, name, package_type, transport, meals, duration):
        self.name = name
        self.package_type = package_type
        self.transport = transport
        self.meals = meals
        self.duration = duration

travel_packages = [
    TravelPackage('Путевка 1', 'Отдых', 'Самолет', 'Завтрак', 7),
    TravelPackage('Путевка 2', 'Экскурсия', 'Автобус', 'Полный пансион', 1),
    TravelPackage('Путевка 3', 'Лечение', 'Поезд', 'Завтрак, обед', 14),
    TravelPackage('Путевка 4', 'Шоппинг', 'Самолет', 'Без питания', 5),
    TravelPackage('Путевка 5', 'Круиз', 'Корабль', 'Все включено', 7),
    TravelPackage('Путевка 6', 'Отдых', 'Самолет', 'Завтрак', 5),
    TravelPackage('Путевка 7', 'Отдых', 'Самолет', 'Завтрак', 10),
    TravelPackage('Путевка 8', 'Отдых', 'Самолет', 'Завтрак', 20),
    TravelPackage('Путевка 9', 'Отдых', 'Автобус', 'Без питания', 7),
    TravelPackage('Путевка 10', 'Экскурсия', 'Поезд', 'Полный пансион', 2),]

# вывод списка путевок
print("Доступные путевки:")
for package in travel_packages:
    print(f"{package.name} - Тип: {package.package_type}, Транспорт: {package.transport}, Питание: {package.meals}, Длительность: {package.duration} дней.")

# путевки по заданным параметрам
def select_packages(packages, package_type, transport, meals, duration):
    selected_packages = []
    for package in packages:
        if package.package_type == package_type \
                and package.transport == transport \
                and package.meals == meals \
                and package.duration >= duration:
            selected_packages.append(package)
    return selected_packages

# сортировка путевок по длительности
def sort_packages(packages):
    sorted_packages = sorted(packages, key=lambda package: package.duration)
    return sorted_packages

# вывод списка путевок по заданным параметрам
def display_packages(packages):
    if len(packages) == 0:
        print("Нет доступных путевок по заданным параметрам.")
    else:
        print("\n Доступные путевки по заданным параметрам:")
        for index, package in enumerate(packages, start=1):
            print(f"{index}. {package.name} - Тип: {package.package_type}, Транспорт: {package.transport}, Питание: {package.meals}, Длительность: {package.duration} дней.")

# параметры выбора и сортировки путевок
selected_package_type = 'Отдых'
selected_transport = 'Самолет'
selected_meals = 'Завтрак'
selected_duration = 5

# выбираем путевки по заданным параметрам
selected_packages = select_packages(travel_packages, selected_package_type, selected_transport, selected_meals, selected_duration)
# сортируем выбранные путевки по длительности
sorted_packages = sort_packages(selected_packages)
# выводим перечень доступных путевок
display_packages(sorted_packages)
