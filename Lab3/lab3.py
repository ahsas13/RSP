import asyncio

pot = 3  # Изначальное количество порций в кастрюле
available = True  # Флаг, указывающий, что кастрюля готова для употребления
currentConsumer = 1  # Текущий дикарь
total_savages = 5  # Общее количество дикарей
# Асинхронная функция для приготовления еды
async def cook():
    print("Повар готовит еду...")
    await asyncio.sleep(2) #для имитации процесса готовки
    global pot, available
    pot = 3
    available = True
    print("Кастрюля наполнена")

# Aсинхронная функция для еды дикарей. проверяем,
# есть ли порции пищи в кастрюле, и уменьшаем количество порций при каждом приеме пищи.
# Если кастрюля пуста, устанавливаем флаг available в False.
async def consume():
    global pot, available, currentConsumer
    if pot > 0:
        pot -= 1
        print(f"Дикарь {currentConsumer} ест. Осталось в кастрюле: {pot} порций")
    else:
        print(f"Кастрюля пуста. Дикарь {currentConsumer} ждет.")
        available = False
    currentConsumer = (currentConsumer % total_savages) + 1 
    await asyncio.sleep(1)
# Aсинхронная функция, которая выполняет бесконечный цикл с проверкой доступности кастрюли.
# Если кастрюля недоступна, вызываем асинхронную функцию cook, иначе вызываем асинхронную функцию consume.
async def simulation():
    while True:
        if not available:
            await cook()
        await consume()

# Запуск асинхронной симуляции
asyncio.run(simulation())
